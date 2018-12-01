package acceso;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class AccesoBD {

	private Connection conexion = null;

	public AccesoBD() throws ClassNotFoundException, SQLException {
		conexion = ConexionJDBC.getConexion();
	}

	public void iniciarTransaccion() throws SQLException {
			conexion.setAutoCommit(false);
	}

	public void aceptarTransaccion() throws SQLException {
			conexion.commit();
	}

	public void cancelarTransaccion() throws SQLException {
			conexion.rollback();
	}

	public boolean ejecutarUpdate(String sql) throws SQLException {
		iniciarTransaccion();
		if (conexion.prepareStatement(sql).executeUpdate() > 0) {
			aceptarTransaccion();
			return true;
		}
		cancelarTransaccion();
		return false;
	}

	public ArrayList<Object> ejecutarConsulta(String sql, Class Clase) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLException, InstantiationException {
		ArrayList<Object> lista = new ArrayList<Object>();
			ResultSet rs = conexion.prepareStatement(sql).executeQuery();
			while (rs.next()) {
				Object object = Clase.newInstance();
				HashMap<String, Method> seters = MapsDTO.obtenerSeters(object);
				for (java.util.Map.Entry<String, Method> seter : seters.entrySet()) {
					seter.getValue().invoke(object, rs.getObject(seter.getKey()));
				}
				lista.add(object);
			}
		return lista;
	}
	
	public ArrayList<String> ejecutarConsultaSinPOJO(String sql) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLException, InstantiationException {
		ArrayList<String> lista = new ArrayList<String>();
			ResultSet rs = conexion.prepareStatement(sql).executeQuery();
			while (rs.next()) {
				lista.add(rs.getString(1));
			}
		return lista;
	}
	

}
