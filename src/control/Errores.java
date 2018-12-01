package control;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;

public class Errores {

	public Errores(Exception e){
		if (e.getClass().equals(ClassNotFoundException.class) || e.getClass().equals(NullPointerException.class)) {
			JOptionPane.showMessageDialog(null, "Error al acceder a la clase");
		}else if (e.getClass().equals(SQLException.class) || e.getClass().equals(MySQLSyntaxErrorException.class)) {
			JOptionPane.showMessageDialog(null, "Error al hacer la consulta (SQL)");
		}
		else if (e.getClass().equals(SQLException.class) || e.getClass().equals(InstantiationException.class)) {
			JOptionPane.showMessageDialog(null, "Error al instanciar el objeto");
		}
		else if (e.getClass().equals(SQLException.class) || e.getClass().equals(IllegalAccessException.class)) {
			JOptionPane.showMessageDialog(null, "Error, intenta acceder a un sitio restringido");
		}
		else if (e.getClass().equals(SQLException.class) || e.getClass().equals(IllegalArgumentException.class)) {
			JOptionPane.showMessageDialog(null, "Error, argumento incorrecto");
		}
		else if (e.getClass().equals(SQLException.class) || e.getClass().equals(InvocationTargetException.class)) {
			JOptionPane.showMessageDialog(null, "Error al invocar el metodo");
		}
	}

}
