package Vistas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controlador.B_Datos;
import Controlador.Modelo;
import javax.swing.JMenuBar;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Desktop;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VistaPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtCorreo;
    JLabel lbContraseña;
    JDesktopPane dkpane;
    private JPasswordField txtContra;
    private JPasswordField txtConfir;
    private JCheckBox mostrarContra;
    private boolean mostrarContraseña = false;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VistaPrincipal frame = new VistaPrincipal();
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
    public VistaPrincipal() {
        setResizable(false);
        setTitle("Cargo Fleets Solutions");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage(VistaPrincipal.class.getResource("/Vistas/WhatsApp Image 2024-11-15 at 1.07.08 AM.jpeg")));
        setBounds(100, 100, 832, 486);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu mnNewMenu = new JMenu("Opciones");
        menuBar.add(mnNewMenu);
        
        JMenuItem mntmNewMenuItem = new JMenuItem("Ayuda");
        mntmNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String url="https://ayudaacliente.netlify.app/";
                if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)){
                    try {
                        Desktop.getDesktop().browse(new URI(url));
                    } catch (IOException | URISyntaxException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        mnNewMenu.add(mntmNewMenuItem);
        
        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Informacion");
        mnNewMenu.add(mntmNewMenuItem_1);
        
        JMenu mnNewMenu_1 = new JMenu("Pagina Web");
        menuBar.add(mnNewMenu_1);
        
        JMenuItem mntmNewMenuItem_2 = new JMenuItem("QR");
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VistaPrincipal vist = new VistaPrincipal();
                qr qr = new qr();
                qr.setVisible(true);
            }
        });
        mntmNewMenuItem_2.setIcon(new ImageIcon("E:\\Proyecto\\Imagenes\\QR3.png"));
        mnNewMenu_1.add(mntmNewMenuItem_2);
        
        JMenuItem mntmNewMenuItem_3 = new JMenuItem("Enlace");
        mntmNewMenuItem_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String url="https://cargofleetsolutionsempresa.netlify.app";
                if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)){
                    try {
                        Desktop.getDesktop().browse(new URI(url));
                    } catch (IOException | URISyntaxException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        mnNewMenu_1.add(mntmNewMenuItem_3);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        dkpane = new JDesktopPane();
        dkpane.setBackground(new Color(0, 0, 0));
        dkpane.setBounds(0, 0, 879, 433);
        contentPane.add(dkpane);
        
        JButton btRegis = new JButton("Registrar");
        btRegis.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/Vistas/img/registro-en-linea.png")));
        btRegis.setForeground(new Color(255, 255, 255));
        btRegis.setBackground(new Color(255, 0, 0));
        btRegis.setBounds(340, 357, 139, 31);
        btRegis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VistaPrincipal vist = new VistaPrincipal();
                SegundaVista vis = new SegundaVista();
                vis.setVisible(true);
                dispose();
            }
        });
        dkpane.setLayout(null);
        dkpane.add(btRegis);
        
        txtCorreo = new JTextField(30);
        txtCorreo.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		if(txtCorreo.getText().length()>=70) {
    				e.consume();
    				JOptionPane.showMessageDialog(null, "correo muy largo");
    				}
        	}
        });
        txtCorreo.setBounds(306, 99, 203, 31);
        dkpane.add(txtCorreo);
        txtCorreo.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("CORREO/TELEFONO");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBackground(new Color(255, 255, 255));
        lblNewLabel.setBounds(270, 57, 321, 31);
        lblNewLabel.setFont(new Font("Wide Latin", Font.PLAIN, 14));
        dkpane.add(lblNewLabel);
        
        lbContraseña = new JLabel("CONTRASEÑA");
        lbContraseña.setForeground(new Color(255, 255, 255));
        lbContraseña.setBounds(306, 141, 224, 26);
        lbContraseña.setFont(new Font("Wide Latin", Font.PLAIN, 14));
        dkpane.add(lbContraseña);
        
        JLabel lblNewLabel_1 = new JLabel("Confirmar contraseña");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(351, 204, 98, 20);
        lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 11));
        dkpane.add(lblNewLabel_1);
        
        JButton btIniciar = new JButton("INICIAR");
        btIniciar.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/Vistas/img/pagina-de-inicio.png")));
        btIniciar.setForeground(new Color(255, 255, 255));
        btIniciar.setBackground(new Color(255, 0, 0));
        btIniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Modelo db = new Modelo();
                String contraseña = txtContra.getText();
                String confirmarContraseña = txtConfir.getText();
                String correo = txtCorreo.getText();
                Inicio in = new Inicio();
                if (correo.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingresa tu correo");
                } else if (!db.validarCorreo(correo) && !db.validarTelefono(correo)) {
                    JOptionPane.showMessageDialog(null, "Correo o Telefono inválido");
                } else if (contraseña.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingresa tu contraseña");
                } else if (confirmarContraseña.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Confirma tu contraseña");
                } else if (!contraseña.equals(confirmarContraseña)) {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
                } else {
                    iniciarSesion(); 
                }
            }
        });
        btIniciar.setBounds(340, 307, 139, 31);
        dkpane.add(btIniciar);
        
        txtContra = new JPasswordField(30);
        txtContra.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		if(txtContra.getText().length()>=20) {
					e.consume();
					JOptionPane.showMessageDialog(null,"menos de 20 digitos en tu contraseña");
				}
        	}
        });
        txtContra.setBounds(306, 173, 203, 20);
        dkpane.add(txtContra);
        
        txtConfir = new JPasswordField(30);
        txtConfir.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		if(txtConfir.getText().length()>=20) {
					e.consume();
					JOptionPane.showMessageDialog(null,"menos de 20 digitos en tu contraseña");
				}
        	}
        });
        txtConfir.setBounds(306, 235, 203, 20);
        dkpane.add(txtConfir);
        
        JCheckBox mostrarcontra = new JCheckBox("Mostrar Contraseña");
        mostrarcontra.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/Vistas/img/candado.png")));
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
        mostrarcontra.setBounds(351, 262, 170, 23);
        dkpane.add(mostrarcontra);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/Vistas/img/WhatsApp Image 2024-11-18 at 8.30.38 PM.jpeg")));
        lblNewLabel_2.setBounds(0, 0, 321, 240);
        dkpane.add(lblNewLabel_2);
      
  
    
    }

    private void iniciarSesion() {
        B_Datos bd = new B_Datos();
        VistaUno vu = new VistaUno();
        String correo = txtCorreo.getText();
        String contraseña = txtContra.getText();
        boolean exito = bd.iniciarSesion(correo, contraseña);
        if (exito) {
            JOptionPane.showMessageDialog(this, "Bienevenido  :  " + correo);
            vu.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Correo o contraseña incorrectos.");
        }
    }
}
