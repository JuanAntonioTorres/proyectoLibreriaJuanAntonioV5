package acceso;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccesoTemaDAO extends AccesoBD {

	public AccesoTemaDAO() throws ClassNotFoundException, SQLException {
		super();
	}

	public boolean insertar(String obj) throws SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return ejecutarUpdate("INSERT INTO `tema`(`tema`) VALUES ('"+obj+"')");
	}

	public boolean borrar(String nombre) throws SQLException {
		return ejecutarUpdate("delete from tema where tema = '"+nombre+"'");
	}

	public ArrayList<String> obtener() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, SQLException {
		return ejecutarConsultaSinPOJO("select * from tema");
	}

	public boolean modificar(String nombre, String obj) throws SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
			return ejecutarUpdate("UPDATE `tema` SET `tema`='"+obj+"' WHERE tema='"+nombre+"'");
	}

}
