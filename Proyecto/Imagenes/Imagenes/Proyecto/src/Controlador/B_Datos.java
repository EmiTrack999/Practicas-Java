package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class B_Datos {
    PreparedStatement ps;
    Connection cn;
    // Método para establecer conexión con la base de datos
    public Connection conexion() {
        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/correos", "root", "");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos: " + e);
        }
        return cn;
    }

   
    public boolean registrarse(Modelo vi) {
        boolean reg = false;

        try {
            Connection cn = conexion();
            PreparedStatement ps = cn.prepareStatement("INSERT INTO usuarios (correo, contra) VALUES(?, ?)");
            ps.setString(1, vi.getCorreo().toLowerCase());
            ps.setString(2, vi.getContraseña());
            int guardar = ps.executeUpdate();
            if (guardar == 1) {
                reg = true;
            } else {
                JOptionPane.showMessageDialog(null, "Error al Registrar.");
            }
            ps.close();
            cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar datos: " + e);
        }
        return reg;
    }
    public boolean verificarCorreo(String correo) {
        String sql = "SELECT COUNT(*) FROM usuarios WHERE correo = ?";
        try (Connection conn = conexion(); // Método que retorna la conexión a la base de datos
             PreparedStatement pst = conn.prepareStatement(sql)) {
             
            pst.setString(1, correo);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1) > 0; // Retorna true si el correo ya está registrado
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar correo: " + e.getMessage());
        }
        return false; // Retorna false si el correo no está registrado o si ocurre un error
    }
    
    public boolean iniciarSesion(String correo, String contraseña) {
        String sql = "SELECT COUNT(*) FROM usuarios WHERE correo = ? AND contra = ?";
        try (Connection conn = conexion();
             PreparedStatement pst = conn.prepareStatement(sql)) {
             
            pst.setString(1, correo.toLowerCase());
            pst.setString(2, contraseña);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1) > 0; 
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión: " + e);
        }
        return false;
    }
}