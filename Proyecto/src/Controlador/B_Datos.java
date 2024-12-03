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

import Modelo.Modelo;

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
    
   
 

    public void coti_pedido(String noCalle, int noInt, int noExt, String sector, int cp, String estado, boolean ecoFriendly) {
        String sql = "INSERT INTO coti_ped  VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection cn = conexion(); 
             PreparedStatement stmt = cn.prepareStatement(sql)) {

            // Configurando los parámetros
            stmt.setString(1, noCalle);
            stmt.setInt(2, noInt);
            stmt.setInt(3, noExt);
            stmt.setString(4, sector);
            stmt.setInt(5, cp);
            stmt.setString(6, estado);
            stmt.setBoolean(7, ecoFriendly);
            int filasInsertadas = stmt.executeUpdate();
            if (filasInsertadas > 0) {
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Muestra el stack trace para facilitar la depuración
            JOptionPane.showMessageDialog(null, "Error al guardar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    public boolean coti_trans(String nom_calle, int no_int, int no_ext, String nom_sect, int cp, String nom_estado) {
        String sql = "INSERT INTO coti_trans VALUES (?, ?, ?, ?, ?, ?)";
        Connection cn = conexion();
        PreparedStatement ps = null;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, nom_calle);
            ps.setInt(2, no_int);
            ps.setInt(3, no_ext);
            ps.setString(4, nom_sect);
            ps.setInt(5, cp);
            ps.setString(6, nom_estado);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                return true;  // Si se insertaron filas, la inserción fue exitosa.
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar recursos: " + e.getMessage());
            }
        }
        return false;  // Si no se insertaron filas, la inserción falló.
    }
    
    
    
    public boolean coti_Dtrans(String nom_calle, int no_int, int no_ext, String nom_sect, int cp, String nom_estado, boolean priv, boolean ecofrien) {
        String sql = "INSERT INTO  cot_tran_dest VALUES (?, ?, ?, ?, ?, ?,?,?)";
        Connection cn = conexion();
        PreparedStatement ps = null;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, nom_calle);
            ps.setInt(2, no_int);
            ps.setInt(3, no_ext);
            ps.setString(4, nom_sect);
            ps.setInt(5, cp);
            ps.setString(6, nom_estado);
            ps.setBoolean(7, priv);
            ps.setBoolean(8, ecofrien);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                return true; 
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar recursos: " + e.getMessage());
            }
        }
        return false;  // Si no se insertaron filas, la inserción falló.
    }
    
    public boolean coti_viaje(String nom_calle, int no_int, int no_ext, String nom_sect, int cp, String nom_estado, boolean ecofrien) {
        String sql = "INSERT INTO  coti_viaj VALUES (?, ?, ?, ?, ?, ?,?)";
        Connection cn = conexion();
        PreparedStatement ps = null;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, nom_calle);
            ps.setInt(2, no_int);
            ps.setInt(3, no_ext);
            ps.setString(4, nom_sect);
            ps.setInt(5, cp);
            ps.setString(6, nom_estado);
            ps.setBoolean(7, ecofrien);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                return true; 
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar recursos: " + e.getMessage());
            }
        }
        return false;  
    }
    public boolean dest_viaje(String nom_calle, int no_int, int no_ext, String nom_sect, int cp, String nom_estado) {
        String sql = "INSERT INTO  dest_viaj VALUES (?, ?, ?, ?, ?, ?)";
        Connection cn = conexion();
        PreparedStatement ps = null;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, nom_calle);
            ps.setInt(2, no_int);
            ps.setInt(3, no_ext);
            ps.setString(4, nom_sect);
            ps.setInt(5, cp);
            ps.setString(6, nom_estado);
         
            int filas = ps.executeUpdate();
            if (filas > 0) {
                return true; 
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar recursos: " + e.getMessage());
            }
        }
        return false; 
    }
    public boolean guarda_tra(String Nombre, String Apellido, String transporte, boolean Senci, boolean persona, boolean paradas) {
        String sql = "INSERT INTO  transporte VALUES (?, ?, ?, ?, ?, ?)";
        Connection cn = conexion();
        PreparedStatement ps = null;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, Nombre);
            ps.setString(2, Apellido);
            ps.setString(3, transporte);
            ps.setBoolean(4, Senci);
            ps.setBoolean(5, persona);
            ps.setBoolean(6, paradas);
         
            int filas = ps.executeUpdate();
            if (filas > 0) {
                return true; 
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar recursos: " + e.getMessage());
            }
        }
        return false; 
    }
    public boolean guarda_ped(String Nombre, String Apellido, String Codigo, String Carga, String Su_ped, boolean Casa_emp) {
        String sql = "INSERT INTO  pedir_ped VALUES (?, ?, ?, ?, ?, ?)";
        Connection cn = conexion();
        PreparedStatement ps = null;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, Nombre);
            ps.setString(2, Apellido);
            ps.setString(3, Codigo);
            ps.setString(4, Carga);
            ps.setString(5, Su_ped);
            ps.setBoolean(6, Casa_emp);
         
            int filas = ps.executeUpdate();
            if (filas > 0) {
                return true; 
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar recursos: " + e.getMessage());
            }
        }
        return false; 
    }
    public boolean guarda_viaje(String Nombre, String Apellido, String Persona, boolean Equi, boolean niños, Date Fecha,int Num_de_seg) {
        String sql = "INSERT INTO  Viaje VALUES (?, ?, ?, ?, ?, ?)";
        Connection cn = conexion();
        PreparedStatement ps = null;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, Nombre);
            ps.setString(2, Apellido);
            ps.setString(3, Persona);
            ps.setBoolean(4, Equi);
            ps.setBoolean(5, niños);
            ps.setDate(6, (java.sql.Date) Fecha);
         
            int filas = ps.executeUpdate();
            if (filas > 0) {
                return true; 
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos: " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar recursos: " + e.getMessage());
            }
        }
        return false; 
    }
    
   
    
    }


    	
    	
  

