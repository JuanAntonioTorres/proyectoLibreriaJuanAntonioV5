package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.Dimension;

public class PanelTemas extends JPanel{
	private JTextField textFieldNuevoTema;
	private JLabel accionActualTitulo;
	private JButton btnAccionAdmin;
	private JLabel lblmodificar;
	private JLabel nuevoTema;
	private JLabel infoTemas;
	private JComboBox<String> temas;
	
	public PanelTemas() {
		setBackground(new Color(255, 255, 255));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{46, 94, 84, 104, 84, 52, 0};
		gridBagLayout.rowHeights = new int[]{29, 0, 35, 47, 32, 39, 37, 31, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		accionActualTitulo = new JLabel("");
		accionActualTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		accionActualTitulo.setMaximumSize(new Dimension(400, 50));
		accionActualTitulo.setForeground(new Color(0, 0, 128));
		accionActualTitulo.setFont(new Font("Segoe Script", Font.BOLD, 25));
		GridBagConstraints gbc_accionActualTitulo = new GridBagConstraints();
		gbc_accionActualTitulo.fill = GridBagConstraints.BOTH;
		gbc_accionActualTitulo.gridwidth = 4;
		gbc_accionActualTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_accionActualTitulo.gridx = 1;
		gbc_accionActualTitulo.gridy = 0;
		add(accionActualTitulo, gbc_accionActualTitulo);
		
		lblmodificar = new JLabel();
		lblmodificar.setMaximumSize(new Dimension(200, 30));
		lblmodificar.setForeground(Color.ORANGE);
		lblmodificar.setFont(new Font("Segoe Print", Font.BOLD, 18));
		lblmodificar.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNombreTema = new GridBagConstraints();
		gbc_lblNombreTema.gridwidth = 2;
		gbc_lblNombreTema.fill = GridBagConstraints.BOTH;
		gbc_lblNombreTema.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreTema.gridx = 1;
		gbc_lblNombreTema.gridy = 2;
		add(lblmodificar, gbc_lblNombreTema);
		
		temas = new JComboBox<>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 2;
		add(temas, gbc_comboBox);
		
		nuevoTema = new JLabel("");
		nuevoTema.setMaximumSize(new Dimension(200, 30));
		nuevoTema.setForeground(new Color(0, 100, 0));
		nuevoTema.setFont(new Font("Segoe Print", Font.BOLD, 18));
		nuevoTema.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_nuevoTema = new GridBagConstraints();
		gbc_nuevoTema.gridwidth = 2;
		gbc_nuevoTema.fill = GridBagConstraints.VERTICAL;
		gbc_nuevoTema.insets = new Insets(0, 0, 5, 5);
		gbc_nuevoTema.gridx = 1;
		gbc_nuevoTema.gridy = 4;
		add(nuevoTema, gbc_nuevoTema);
		
		textFieldNuevoTema = new JTextField();
		textFieldNuevoTema.setMaximumSize(new Dimension(200, 30));
		textFieldNuevoTema.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 100, 0), null, null, null));
		textFieldNuevoTema.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNuevoTema.setColumns(10);
		GridBagConstraints gbc_textFieldNuevoTema = new GridBagConstraints();
		gbc_textFieldNuevoTema.gridwidth = 2;
		gbc_textFieldNuevoTema.fill = GridBagConstraints.BOTH;
		gbc_textFieldNuevoTema.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNuevoTema.gridx = 3;
		gbc_textFieldNuevoTema.gridy = 4;
		add(textFieldNuevoTema, gbc_textFieldNuevoTema);
		
		btnAccionAdmin = new JButton("");
		btnAccionAdmin.setMaximumSize(new Dimension(400, 50));
		btnAccionAdmin.setForeground(new Color(0, 51, 0));
		btnAccionAdmin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAccionAdmin.setBackground(new Color(204, 255, 204));
		GridBagConstraints gbc_btnAccionAdmin = new GridBagConstraints();
		gbc_btnAccionAdmin.fill = GridBagConstraints.BOTH;
		gbc_btnAccionAdmin.gridwidth = 2;
		gbc_btnAccionAdmin.insets = new Insets(0, 0, 5, 5);
		gbc_btnAccionAdmin.gridx = 2;
		gbc_btnAccionAdmin.gridy = 6;
		add(btnAccionAdmin, gbc_btnAccionAdmin);
		
		JPanel panelParaError = new JPanel();
		panelParaError.setBackground(Color.WHITE);
		GridBagConstraints gbc_panelParaError = new GridBagConstraints();
		gbc_panelParaError.gridwidth = 2;
		gbc_panelParaError.insets = new Insets(0, 0, 5, 0);
		gbc_panelParaError.fill = GridBagConstraints.BOTH;
		gbc_panelParaError.gridx = 4;
		gbc_panelParaError.gridy = 6;
		add(panelParaError, gbc_panelParaError);
		GridBagLayout gbl_panelParaError = new GridBagLayout();
		gbl_panelParaError.columnWidths = new int[]{46, 0};
		gbl_panelParaError.rowHeights = new int[]{14, 0};
		gbl_panelParaError.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelParaError.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelParaError.setLayout(gbl_panelParaError);
		
		infoTemas = new JLabel("");
		infoTemas.setForeground(Color.GREEN);
		infoTemas.setBackground(Color.WHITE);
		infoTemas.setHorizontalAlignment(SwingConstants.CENTER);
		infoTemas.setMaximumSize(new Dimension(100, 30));
		infoTemas.setHorizontalTextPosition(SwingConstants.CENTER);
		GridBagConstraints gbc_infoTemas = new GridBagConstraints();
		gbc_infoTemas.fill = GridBagConstraints.BOTH;
		gbc_infoTemas.gridx = 0;
		gbc_infoTemas.gridy = 0;
		panelParaError.add(infoTemas, gbc_infoTemas);
		
	}
	
	public JTextField getTextFieldNuevoTema() {
		return textFieldNuevoTema;
	}

	public JButton getBtnAccionAdmin() {
		return btnAccionAdmin;
	}

	public JLabel getNuevoTema() {
		return nuevoTema;
	}

	public void configurarCamposSegunTipo(String tipo) {
		if(tipo != null && tipo.equals("insertar")) {
			lblmodificar.setVisible(false);
			temas.setVisible(false);
			nuevoTema.setVisible(true);
			textFieldNuevoTema.setVisible(true);
		}
		else if (tipo.equals("modificar")){
			lblmodificar.setVisible(true);
			temas.setVisible(true);
			nuevoTema.setVisible(true);
			textFieldNuevoTema.setVisible(true);
		}
		else {
			lblmodificar.setVisible(true);
			temas.setVisible(true);
			nuevoTema.setVisible(false);
			textFieldNuevoTema.setVisible(false);
		}
		lblmodificar.setText("tema para " + tipo);
		accionActualTitulo.setText(tipo + " tema");
		btnAccionAdmin.setText(tipo);
		nuevoTema.setText(tipo + " tema");
	}

	public JLabel getInfoTemas() {
		return infoTemas;
	}

	public JComboBox<String> getTemas() {
		return temas;
	}

	public void setTemas(JComboBox<String> temas) {
		this.temas = temas;
	}

}
