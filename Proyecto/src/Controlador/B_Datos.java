package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class B_Datos {
    PreparedStatement ps;
    Connection cn;
   
    public Connection conexion() {
        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cargofleets", "root", "");
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
        try (Connection conn = conexion(); 
             PreparedStatement pst = conn.prepareStatement(sql)) {
             
            pst.setString(1, correo);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar correo: " + e);
        }
        return false;
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
    
    //transporte
    public boolean guardarTransporte(String tipoTransporte, String nombre, boolean transportaPersonal, boolean paradasContinuas, boolean material_senci) {
        boolean guardado = false;
        String sql = "INSERT INTO transport VALUES (0,?,?,?,?,?)";

        try (Connection conn = conexion(); 
             PreparedStatement pst = conn.prepareStatement(sql)) {
        	pst.setString(1, nombre);
            pst.setString(2, tipoTransporte);
            pst.setBoolean(3, material_senci);
            pst.setBoolean(4, transportaPersonal);
            pst.setBoolean(5, paradasContinuas);
            
            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas > 0) {
                guardado = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar datos en la tabla transporte: " + e);
        }
        return guardado;
    }
    //pedido
   
    public boolean guardarPedido(String nombre, int codigo, String tCarga, String pedido, boolean ca_emp,String direccion, String destino) {
        boolean guardado = false;
        String sql = "INSERT INTO pedi VALUES (?, ?, ?, ?, ?,?,?)";
        
        try (Connection cn = conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {
            if (cn == null) {
                JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos.");
                return false;
            }
            ps.setString(1, nombre);
            ps.setInt(2, codigo);
            ps.setString(3, tCarga);
            ps.setString(4, pedido);
            ps.setBoolean(5, ca_emp);
            ps.setString(6, direccion);
            ps.setString(7, destino);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                guardado = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar datos en la tabla pedido: " + e.getMessage());
        }
        return guardado;
    }
     //Viaje
    public boolean viaje(String nombre, String personas, Boolean equipamiento, boolean ninos, Date fecha, String numero) {
        boolean guardado = false;
        String sql = "INSERT INTO via VALUES (?, ?, ?, ?, ?, ?)"; 

        try (Connection cn = conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {
            if (cn == null) {
                JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos.");
                return false;
            }
            if (fecha == null) {
                JOptionPane.showMessageDialog(null, "La fecha es obligatoria.");
                return false;
            }
            java.sql.Date sqlDate = new java.sql.Date(fecha.getTime()); 
            ps.setString(1, nombre);  
            ps.setString(2, personas); 
            ps.setBoolean(3, equipamiento); 
            ps.setBoolean(4, ninos); 
            ps.setDate(5, sqlDate); 
            ps.setString(6, numero);  
            int filas = ps.executeUpdate();
            if (filas > 0) {
                guardado = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar datos en la tabla viaje: " + e.getMessage());
            e.printStackTrace();
        }
        return guardado;
    }  
}

