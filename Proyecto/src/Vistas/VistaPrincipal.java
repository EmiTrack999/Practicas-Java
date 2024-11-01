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
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Desktop;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Frame;
import java.awt.Window.Type;
import java.awt.Cursor;
import java.awt.Color;

public class VistaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCorreo;
	private JTextField txtContra;
	private JTextField txtConfir;
	JLabel lbContraseña;
	JDesktopPane dkpane;
	
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
		setTitle("Cargo Fleets Solutions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setLocationByPlatform(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno.SC3PC36.000\\Downloads\\WhatsApp Image 2024-10-10 at 3.44.30 PM (1).jpeg"));
		setBounds(100, 100, 631, 494);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Opciones");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Ayuda");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url="https://ayudaacliente.netlify.app/";
				if(Desktop.isDesktopSupported()&&Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)){
					try {
						Desktop.getDesktop().browse(new URI(url));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}				}
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
				VistaPrincipal vist=new VistaPrincipal();
				qr qr=new qr();
				qr.setVisible(true);	
				
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon("E:\\Proyecto\\Imagenes\\QR3.png"));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Enlace");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url="https://cargofleetsolutionsempresa.netlify.app";
				if(Desktop.isDesktopSupported()&&Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)){
					try {
						Desktop.getDesktop().browse(new URI(url));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}				}
								
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		dkpane = new JDesktopPane();
		dkpane.setBackground(new Color(0, 0, 0));
		dkpane.setBounds(0, 0, 624, 468);
		contentPane.add(dkpane);
		
		JButton btRegis = new JButton("Registrar");
		btRegis.setForeground(new Color(255, 255, 255));
		btRegis.setBackground(new Color(255, 0, 0));
		btRegis.setBounds(265, 317, 89, 26);
		btRegis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaPrincipal vist=new VistaPrincipal();
				SegundaVista vis=new SegundaVista();
				vis.setVisible(true);
				
				
				
				
				
				}
		});
		dkpane.setLayout(null);
		dkpane.add(btRegis);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(208, 96, 203, 31);
		dkpane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CORREO/TELEFONO");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(168, 57, 321, 31);
		lblNewLabel.setFont(new Font("Wide Latin", Font.PLAIN, 14));
		dkpane.add(lblNewLabel);
		
		lbContraseña = new JLabel("CONTRASEÑA");
		lbContraseña.setForeground(new Color(255, 255, 255));
		lbContraseña.setBounds(208, 126, 224, 26);
		lbContraseña.setFont(new Font("Wide Latin", Font.PLAIN, 14));
		dkpane.add(lbContraseña);
		
		txtContra = new JTextField();
		txtContra.setBounds(208, 163, 203, 31);
		txtContra.setColumns(10);
		dkpane.add(txtContra);
		txtConfir = new JTextField();
		txtConfir.setBounds(208, 235, 203, 20);
		dkpane.add(txtConfir);
		txtConfir.setColumns(10);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Confirmar contraseña");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(256, 204, 98, 20);
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 11));
		dkpane.add(lblNewLabel_1);
		
		JButton btIniciar = new JButton("INICIAR");
		btIniciar.setForeground(new Color(255, 255, 255));
		btIniciar.setBackground(new Color(255, 0, 0));
		btIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modelo db = new Modelo();
				String contraseña = txtContra.getText();
				String confirmarContraseña =txtConfir.getText();
				String correo = txtCorreo.getText();
				Inicio in = new Inicio();
				String iniciar=new String();
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
				} else {
					iniciarSesion(); 
				}
			}
		});
		btIniciar.setBounds(265, 266, 89, 23);
		dkpane.add(btIniciar);
	}
	  private void iniciarSesion() {
			B_Datos bd=new B_Datos();
			Inicio in=new Inicio();
			
	        String correo = txtCorreo.getText();
	        String contraseña =txtContra.getText();
	        boolean exito = bd.iniciarSesion(correo, contraseña);
	        if (exito) {
	            JOptionPane.showMessageDialog(this, "Bienevenido  :  "+correo);
	           in.setVisible(true);
	        } else {
	            JOptionPane.showMessageDialog(this, "Correo o contraseña incorrectos.");
	        }
	    }
}
