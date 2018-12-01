package control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import javax.swing.JButton;
import vista.LogicaGrafica;

public class ListenerPanelTemas implements ActionListener {
	private Logica logica;
	private LogicaGrafica logicaGrafica;

	public ListenerPanelTemas(Logica logica, LogicaGrafica logicaGrafica) {
		this.logica = logica;
		this.logicaGrafica = logicaGrafica;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String accionActual = ((JButton)arg0.getSource()).getText();
			try {
				if(accionActual.equals("insertar")) {
					if(logica.guardarTema(logicaGrafica.getTextFieldNuevoTema().getText())){
						gestionarCorrecto(accionActual);
					}
					else {
						gestionarNoCorrecto(accionActual);
					}
				}
				if(accionActual.equals("modificar")) {
					if(logica.modificarTema(logicaGrafica.getTemas().getSelectedItem().toString(), logicaGrafica.getTextFieldNuevoTema().getText())) {
						gestionarCorrecto(accionActual);
					}				
					else {
						gestionarNoCorrecto(accionActual);
					}
				}
				if(accionActual.equals("borrar")) {
					if(logica.borrarTema(logicaGrafica.getTemas().getSelectedItem().toString())) {
						gestionarCorrecto(accionActual);
					}
					else {
						gestionarNoCorrecto(accionActual);
					}
				}
			} catch (IOException | IllegalArgumentException | IllegalAccessException | SecurityException | SQLException | InvocationTargetException | InstantiationException e) {
				e.printStackTrace();
			}
	}

	private void gestionarNoCorrecto(String accionActual) {
		logicaGrafica.getInfoTemas().setForeground(Color.RED);
		logicaGrafica.getInfoTemas().setText(accionActual+"tema NO correcto");
		logicaGrafica.getTextFieldNuevoTema().setText("");
	}

	private void gestionarCorrecto(String accionActual) throws IllegalArgumentException, IllegalAccessException, SecurityException, IOException, SQLException, InvocationTargetException, InstantiationException {
		logicaGrafica.getInfoTemas().setForeground(Color.GREEN);
		logicaGrafica.getInfoTemas().setText(accionActual+"tema correcto");
		logicaGrafica.getTextFieldNuevoTema().setText("");
		logicaGrafica.actualizarTemas(logica);
	}

}
