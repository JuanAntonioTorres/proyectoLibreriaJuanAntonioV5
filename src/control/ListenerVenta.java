package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import modelo.Libro;
import vista.LogicaGrafica;

public class ListenerVenta implements ActionListener {

	private Logica logica;
	private LogicaGrafica logicaGrafica;
	
	public ListenerVenta(Logica logica, LogicaGrafica logicaGrafica) {
		super();
		this.logica = logica;
		this.logicaGrafica = logicaGrafica;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String isbn = logicaGrafica.obtenerIsbn();
		int unidadesMas=logicaGrafica.obtenerUnidades();
		int unidadesDisponibles = 0;
		try {
			unidadesDisponibles = Integer.valueOf(logica.obtenerLibro(isbn).getUnidades());
		} catch (IllegalArgumentException | IllegalAccessException | SecurityException | IOException
				| SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if(unidadesMas<=unidadesDisponibles) {
				Libro libro = logica.obtenerLibro(isbn);
				logica.borrarLibro(logicaGrafica.obtenerIsbn());
				libro.setUnidades(unidadesDisponibles-unidadesMas);
				logica.altaLibro(libro);
				logicaGrafica.pintarLista(logica.getLibros());
				logicaGrafica.resetearInformacion();
				logicaGrafica.pintarLibro(logica.obtenerLibro(isbn));
			}
			else {
				logicaGrafica.mostrarMensajeError("Las unidades vendidas superan la cantidad disponible", true);
			}
		} catch (IllegalArgumentException | IllegalAccessException | SecurityException | IOException | SQLException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
