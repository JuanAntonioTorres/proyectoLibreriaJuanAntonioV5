package modelo;

import java.lang.reflect.Field;
import java.util.HashMap;

import acceso.Clave;

@Clave(clavePrimaria="isbn")
public class Libro{
	private String isbn;
	private String titulo;
	private String autor;
	private String tema;
	private int paginas;
	private String formato;
	private String estado;
	private String editorial;
	private int unidades;
	
	public Libro() {
		super();
	}

	public Libro(HashMap<String, Object> datosLibro) throws IllegalArgumentException, IllegalAccessException, SecurityException {
	    Field[] declaredFields = this.getClass().getDeclaredFields();
	    for (int i = 0; i < declaredFields.length; i++) {
	      declaredFields[i].set(this, datosLibro.get(declaredFields[i].getName()));
	    }
	  }

	public boolean esIgualQue(Libro libro) {
		if(this.autor.equals(libro.getAutor()))return false;
		if(this.editorial.equals(libro.getEditorial()))return false;
		if(this.estado.equals(libro.getEstado()))return false;
		if(this.formato.equals(libro.getFormato()))return false;
		if(this.paginas==libro.getPaginas())return false;
		if(this.tema.equals(libro.getTema()))return false;
		if(this.titulo.equals(libro.getTitulo()))return false;
		return (this.unidades==libro.getUnidades());
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}


	

}
