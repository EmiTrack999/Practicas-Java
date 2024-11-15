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
    public boolean guardarTransporte(String tipoTransporte, String nombre, boolean transportaPersonal, boolean paradasContinuas) {
        boolean guardado = false;
        String sql = "INSERT INTO transporte VALUES (0,?, ?, ?,?)";

        try (Connection conn = conexion(); 
             PreparedStatement pst = conn.prepareStatement(sql)) {
        	pst.setString(1, nombre);
            pst.setString(2, tipoTransporte);
            pst.setBoolean(3, transportaPersonal);
            pst.setBoolean(4, paradasContinuas);
            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas > 0) {
                guardado = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar datos en la tabla transporte: " + e);
        }
        return guardado;
    }
    
    //Viaje
    public boolean guardarPedido(String nombre, int codigo, String tCarga,String pedido, boolean ca_emp) {
		boolean guardado=false;
		 String sql = "INSERT INTO pedido VALUES (?, ?, ?, ?, ?)";
		try {
			ps=cn.prepareStatement(sql);
			ps.setString(1, nombre);
			ps.setInt(2, codigo);
			ps.setString(3,tCarga);
			ps.setString(4, pedido);
			ps.setBoolean(5, ca_emp);
			int filas=ps.executeUpdate();
			if(filas>0) {
				guardado=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar datos en la tabla transporte: " + e);
		}
		return guardado;
    	
    }
    
    //pedido
    public boolean viaje(String nombre, int codigo, String tCarga,String pedido, boolean ca_emp) {
  		boolean guardado=false;
  		 String sql = "INSERT INTO pedido VALUES (?, ?, ?, ?, ?)";
  		try {
  			ps=cn.prepareStatement(sql);
  			ps.setString(1, nombre);
  			ps.setInt(2, codigo);
  			ps.setString(3,tCarga);
  			ps.setString(4, pedido);
  			ps.setBoolean(5, ca_emp);
  			int filas=ps.executeUpdate();
  			if(filas>0) {
  				guardado=true;
  			}
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			//e.printStackTrace();
              JOptionPane.showMessageDialog(null, "Error al guardar datos en la tabla transporte: " + e);
  		}
  		return guardado;
      	
      }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

