package control;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import acceso.AccesoLibroDAO;
import acceso.AccesoTemaDAO;
import modelo.Libro;

public class Logica {
	private AccesoLibroDAO almacenLibreria;
	private AccesoTemaDAO almacenTemas;
	
	public Logica() throws ClassNotFoundException, SQLException {
		super();
		this.almacenLibreria = new AccesoLibroDAO();
		this.almacenTemas = new AccesoTemaDAO();
	}

	public void altaLibro(Libro libro) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLException {
		assert libro != null;
		almacenLibreria.insertar(libro);
	}

	public boolean borrarLibro(String isbn) throws IOException, SQLException {
		assert isbn.length()==13:"ISBN incorrecto";
		return almacenLibreria.borrar(isbn);
	}

	public ArrayList<Libro> getLibros(){
		try {
			return almacenLibreria.obtener();
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException
				| SQLException e) {
			new Errores(e);
			e.printStackTrace();
		}
		return null;
	}

	public boolean modificarLibro(Libro original,Libro modificado) {
		assert original != null && modificado != null:"algun libro para modificar ha llegado null";
		try {
			return almacenLibreria.modificar(original.getIsbn(),modificado);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | SQLException e) {
			new Errores(e);
		}
		return false;
	}

	public Libro obtenerLibro(String isbn) throws IllegalArgumentException, IllegalAccessException, SecurityException, IOException, SQLException {
		assert isbn.length()==13:"longitud isbn incorrecta";
		try {
			return almacenLibreria.buscar(isbn);
		} catch (InvocationTargetException | InstantiationException e) {
			new Errores(e);
		}
		return null;
	}

	public ArrayList<String> obtenerFormatos() throws IOException, SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		return almacenLibreria.obtenerFormatos();
	}

	public ArrayList<String> obtenerEstados() throws IOException, SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		return almacenLibreria.obtenerEstados();
	}

	public boolean guardarTema(String tema) throws IOException {
		try {
			return almacenTemas.insertar(tema);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | SQLException e) {
			new Errores(e);
		}
		return false;
	}

	public ArrayList<String> leerTema(){
		try {
			return almacenTemas.obtener();
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException
				| SQLException e) {
			new Errores(e);
		}
		return null;
	}
	
	public String[] leerTemaStrings()
			throws IOException, SQLException, IllegalArgumentException, IllegalAccessException, SecurityException, InvocationTargetException, InstantiationException {
		 ArrayList<String> temas =almacenTemas.ejecutarConsultaSinPOJO("select * from tema");
		 String [] temasStrings = new String [temas.size()];
		 for (int i = 0; i < temas.size(); i++) {
			temasStrings[i]=temas.get(i);
		}
		 return temasStrings;
	}

	public boolean borrarTema(String tema) throws IOException {
		try {
			return almacenTemas.borrar(tema);
		} catch (SQLException e) {
			new Errores(e);
		}
		return false;
	}

	public boolean modificarTema(String original, String modificado) throws IOException {
		try {
			return almacenTemas.modificar(original, modificado);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | SQLException e) {
			new Errores(e);
		}
		return false;
	}
	
	
	
}
