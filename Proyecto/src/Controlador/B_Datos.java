package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Vistas.VistaPrincipal;

public class B_Datos {
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
		public boolean iniciarSesion(String correo, String contraseña) {
	        boolean inicioExitoso = false;
	        conexion();
    try {
    	conexion();
    	Modelo mo=new Modelo();
        PreparedStatement ps = cn.prepareStatement("SELECT * FROM registro WHERE correo = ? AND contraseña = ?");
        ps.setString(1, mo.correo);
        ps.setString(2, mo.contraseña);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            inicioExitoso = true;
            JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
        } else {
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
        }
        rs.close();
        ps.close();
        cn.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al iniciar sesión: " + e);
    }
    return inicioExitoso;
}

public boolean estaRegistrado(String correo) {
    boolean registrado = false;
    conexion();
    try {
        PreparedStatement ps = cn.prepareStatement("SELECT * FROM registro WHERE correo = ?");
        ps.setString(1, correo);
        ResultSet rs = ps.executeQuery();
        registrado = rs.next(); // Si hay un resultado, ya está registrado
        rs.close();
        ps.close();
        cn.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al verificar registro: " + e);
    }
    return registrado;
} }

