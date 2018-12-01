package acceso;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Libro;

//DAO se encarga de guardar el DTO en el lugar que corresponda y decirle cómo se guarda
//Por ejemplo, si guardamos en BD hara insert a la BD, si guardamos en Fichero, se encarga de abrir fichero y guardar
//Data Access Object

//Esta clase en e Manual de alumno hce tambien la funcion de Fachada, pero la fachada debe ir una clase propia (Fachada)
public class AccesoLibroDAO extends AccesoBD implements IAcceso<Libro> {

	public AccesoLibroDAO() throws ClassNotFoundException, SQLException {
		super();
	}

	@Override
	public boolean insertar(Libro obj) throws SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
			return ejecutarUpdate(UtilSql.sqlInsertar(obj));
	}

	@Override
	public boolean borrar(String nombre) throws SQLException {
		return ejecutarUpdate(UtilSql.sqlBorrar(Libro.class, nombre));
	}

	@Override
	public Libro buscar(String nombre) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, SQLException {
		try {
			return (Libro) ejecutarConsulta(UtilSql.sqlBuscar(Libro.class, nombre), Libro.class).get(0);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}	
		
	}

	@Override
	public ArrayList<Libro> obtener() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, SQLException {
		return castearDTO(ejecutarConsulta(UtilSql.sqlObtener(Libro.class), Libro.class));
	}

	@Override
	public boolean modificar(String nombre, Libro obj) throws SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
			return ejecutarUpdate(UtilSql.sqlModificar(nombre, obj));
	}

	private ArrayList<Libro> castearDTO(ArrayList<Object> lista) {
		ArrayList<Libro> lista2 = new ArrayList<Libro>();
		for (Object object : lista) {
			lista2.add(((Libro) object));
		}
		return lista2;
	}

	public ArrayList<String> obtenerFormatos() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, SQLException {
		return ejecutarConsultaSinPOJO("select * from formato");
	}

	public ArrayList<String> obtenerEstados() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, SQLException {
		return ejecutarConsultaSinPOJO("select * from estado");
	}

}
