package acceso;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IAcceso <obj> {

	public boolean insertar(obj obj) throws SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public boolean borrar(String nombre) throws SQLException;
	public obj buscar(String nombre) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, SQLException;
	public ArrayList<obj> obtener() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, SQLException;
	public boolean modificar(String nombre,obj obj) throws SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
}
