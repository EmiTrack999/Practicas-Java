package Vistas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.B_Datos;
import Modelo.Modelo;

import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Desktop;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SegundaVista extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtCorreo;
    private JPasswordField txtContra;
    private JPasswordField txtConfir;

    // Variable de control para la visibilidad de la contraseña
    private boolean mostrarContraseña = false;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SegundaVista frame = new SegundaVista();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public SegundaVista() {
        setTitle("Cargo Fleets Solutions");
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(SegundaVista.class.getResource("/Vistas/Logo de la empresa.jpeg")));
        setBounds(100, 100, 730, 555);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("Opciones");
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("Regresar al menu");
        mntmNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VistaPrincipal vp = new VistaPrincipal();
                vp.setVisible(true);
                dispose();
            }
        });
        mnNewMenu.add(mntmNewMenuItem);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Iniciar con N. Telefonico");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TerceraVista ter = new TerceraVista();
                ter.setVisible(true);
                dispose();
            }
        });
        mnNewMenu.add(mntmNewMenuItem_1);

        JMenuItem mntmNewMenuItem_2 = new JMenuItem("Ayuda");
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String url = "https://ayudaacliente.netlify.app/";
                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    try {
                        Desktop.getDesktop().browse(new URI(url));
                    } catch (IOException | URISyntaxException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        mnNewMenu.add(mntmNewMenuItem_2);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JDesktopPane desktopPane = new JDesktopPane();
        desktopPane.setBackground(new Color(0, 0, 0));
        desktopPane.setBounds(0, 0, 766, 481);
        contentPane.add(desktopPane);

        JLabel lblNewLabel = new JLabel("Ingresa tu correo");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel.setBounds(305, 211, 118, 20);
        desktopPane.add(lblNewLabel);

        txtCorreo = new JTextField();
        txtCorreo.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		if(txtCorreo.getText().length()>=70) {
    				e.consume();
    				JOptionPane.showMessageDialog(null, "correo muy largo");
    				}
        	}
        });
        txtCorreo.setBounds(242, 241, 241, 20);
        desktopPane.add(txtCorreo);
        txtCorreo.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Crea tu contraseña");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_1.setBounds(305, 271, 118, 14);
        desktopPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Confirma tu contraseña");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_2.setBounds(285, 325, 148, 14);
        desktopPane.add(lblNewLabel_2);

        JButton btnNewButton = new JButton("Registrarme");
        btnNewButton.setIcon(new ImageIcon(SegundaVista.class.getResource("/Vistas/img/registro-en-linea.png")));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(255, 0, 0));
        btnNewButton.setSelectedIcon(new ImageIcon("E:\\Proyecto\\Imagenes\\goku.jpg"));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Modelo db = new Modelo();
                String contraseña = txtContra.getText();
                String confirmarContraseña = txtConfir.getText();
                String correo = txtCorreo.getText();
                Inicio in = new Inicio();
                B_Datos bd = new B_Datos();
                if (correo.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingresa tu correo");
                } else if (!db.validarCorreo(correo)) {
                    JOptionPane.showMessageDialog(null, "Correo inválido");
                } else if (contraseña.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingresa tu contraseña");
                } else if (confirmarContraseña.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Confirma tu contraseña");
                } else if (!contraseña.equals(confirmarContraseña)) {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
                } else  if(txtContra.getText().length()<6) {
					
					JOptionPane.showMessageDialog(null,"mas de 6 digitos en tu contraseña");
				}else {
                    registrar();
				}
            }
        });
        btnNewButton.setBounds(285, 440, 137, 31);
        desktopPane.add(btnNewButton);

        JLabel lblNewLabel_3 = new JLabel("Registro");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setBounds(285, 11, 148, 64);
        desktopPane.add(lblNewLabel_3);

        txtContra = new JPasswordField();
        txtContra.addKeyListener(new KeyAdapter() {
        	
        	public void keyTyped(KeyEvent e) {
        		if(txtContra.getText().length()>=20) {
					e.consume();
					JOptionPane.showMessageDialog(null,"menos de 20 digitos en tu contraseña");
				}
        	}
        });
        txtContra.setBounds(242, 295, 241, 20);
        desktopPane.add(txtContra);

        txtConfir = new JPasswordField();
        txtConfir.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		if(txtConfir.getText().length()>=20) {
					e.consume();
					JOptionPane.showMessageDialog(null,"menos de 20 digitos en tu contraseña");
				}
        	}
        });
        txtConfir.setBounds(242, 349, 241, 20);
        desktopPane.add(txtConfir);
        
        JCheckBox mostrarcontra = new JCheckBox("Mostrar Contraseña");
        mostrarcontra.setIcon(new ImageIcon(SegundaVista.class.getResource("/Vistas/img/candado.png")));
        mostrarcontra.setForeground(new Color(255, 255, 255));
        mostrarcontra.setBackground(new Color(0, 0, 0));
        mostrarcontra.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		  if (mostrarContraseña) {
                      txtContra.setEchoChar('x');
                      txtConfir.setEchoChar('x');
                      mostrarContraseña = false;
                  } else {
                      txtContra.setEchoChar((char) 0);
                      txtConfir.setEchoChar((char) 0);
                      mostrarContraseña = true;
                  }
        	}
        });
        mostrarcontra.setBounds(269, 386, 186, 25);
        desktopPane.add(mostrarcontra);
        
        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon(SegundaVista.class.getResource("/Vistas/img/REGSITROOOS.png")));
        lblNewLabel_4.setBounds(295, 68, 128, 139);
        desktopPane.add(lblNewLabel_4);
    }

    public void registrar() {
        B_Datos bd = new B_Datos();
        VistaUno vu=new VistaUno();
        String correo = txtCorreo.getText();
        String contraseña = txtContra.getText();
        String confirmar = txtConfir.getText();
        if (bd.verificarCorreo(correo)) {
            JOptionPane.showMessageDialog(null, "El correo ya está registrado.");
            return;
        }
        Modelo mo = new Modelo();
        mo.setCorreo(correo);
        mo.setContraseña(contraseña);
        if (bd.registrarse(mo)) {
            JOptionPane.showMessageDialog(null, "Bienvenido  " + correo);
            vu.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar.");
        }
    }
}
