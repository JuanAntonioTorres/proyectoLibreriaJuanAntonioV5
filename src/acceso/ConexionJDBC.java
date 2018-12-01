package acceso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import control.Errores;

public class ConexionJDBC {

	// Atributos para el acceso a la BBDD
	private String usuario;
	private String constraseña;
	private String url;
	private String driver;
	// Parametro para el acceso al fichero de configuraciones (properties)
	private final ResourceBundle accesoPropiedades = ResourceBundle.getBundle("Config");
	
	
	// Parametros para el acceso a la conexion
	//Patron singleton
	//Este patron nos garantiza que solo haya una instancia de conexion para toda la aplicacion
	private static Connection conexion = null;

	/**
	 * Retorna la conexion
	 * 
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	//Este método estatico instancia un objeto de la clase si no existe
	public static Connection getConexion() throws ClassNotFoundException, SQLException {
		if (conexion == null) {
			new ConexionJDBC();
		}
		return conexion;
	}

	/**
	 * Crea la conexion 
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 */
	//Constructor private propio del patron singleton
	private ConexionJDBC() throws ClassNotFoundException, SQLException {
		Runtime.getRuntime().addShutdownHook(new MiShutDownHook());
		usuario = accesoPropiedades.getString("usuario");
		constraseña = accesoPropiedades.getString("password");
		url = accesoPropiedades.getString("url");
		driver = accesoPropiedades.getString("driver");
		Class.forName(driver);
		conexion = DriverManager.getConnection(url, usuario, constraseña);
	}

	/**
	 * Cierra la conexion al cerrar el programa
	 * 
	 * @author david
	 *
	 */
	public class MiShutDownHook extends Thread {
		public void run() {
			try {
				if(conexion != null)
				conexion.close();
			} catch (SQLException e) {
				new Errores(e);
			}
		};
	}

}
