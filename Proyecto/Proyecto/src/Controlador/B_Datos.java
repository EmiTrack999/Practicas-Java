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
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/registros311", "root", "");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos: " + e);
        }
        return cn;
    }

    // Método para registrar el correo si no está ya registrado
    public boolean registrarse(Modelo vi) {
        boolean reg = false;
        
        if (isUserRegistered(vi.getCorreo())) {
            JOptionPane.showMessageDialog(null, "El correo ya está registrado. No necesitas registrarte de nuevo.");
            return reg;
        }

        try {
            Connection cn = conexion();
            PreparedStatement ps = cn.prepareStatement("INSERT INTO registro (correo, contra) VALUES(?, ?)");
            ps.setString(1, vi.getCorreo().toLowerCase()); // Convertir a minúsculas para evitar problemas de comparación
            ps.setString(2, vi.getContraseña());
            int guardar = ps.executeUpdate();
            if (guardar == 1) {
                reg = true;
                JOptionPane.showMessageDialog(null, "Registrado exitosamente.");
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

    // Método para verificar si un correo ya está registrado
    public boolean isUserRegistered(String correo) {
        String query = "SELECT COUNT(*) FROM registro WHERE correo = ?"; 
        boolean registrado = false;

        try {
            Connection cn = conexion(); 
            PreparedStatement stmt = cn.prepareStatement(query);

            stmt.setString(1, correo.toLowerCase()); // Convertir a minúsculas para comparar de forma consistente

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                registrado = rs.getInt(1) > 0; // Devuelve true si se encuentra al menos un registro
            }

            rs.close();
            stmt.close();
            cn.close();

        } catch (SQLException e) {
            System.err.println("Error al verificar usuario registrado: " + e.getMessage());
        }

        return registrado; 
    }

    // Nuevo método para verificar y mostrar mensaje
    public void verificarCorreo(String correo) {
        if (!isUserRegistered(correo)) {
            JOptionPane.showMessageDialog(null, "Este correo no está registrado.");
        } else {
            JOptionPane.showMessageDialog(null, "Este correo ya está registrado.");
        }
    }
}
