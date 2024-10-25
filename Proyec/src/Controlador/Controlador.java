package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Modelo.Modelo;

public class Controlador {
	PreparedStatement ps;
	Connection cn;
	
	public Connection conexion() {
		try {
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/registros311","root","");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null,"error al acceder a la base de datos"+ e);
		}
		return cn;
	}
	public boolean registrarse(Modelo vi) {
		boolean reg=false;
		conexion();
		try {
			PreparedStatement ps=cn.prepareStatement("insert into registro values(?,?)");
			ps.setString(1, vi.getCorreo());
			ps.setString(2, vi.getContraseña());
			int guardar=ps.executeUpdate();
			if(guardar==1) {
				reg=true;
				JOptionPane.showMessageDialog(null, "Registrado");
				
			}else {
				JOptionPane.showMessageDialog(null, "Error al Registrar");
			}
			ps.close();
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null,"error al registrar datos"+ e);
		}
		return reg;
	}
}
