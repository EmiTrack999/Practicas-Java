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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setLocationByPlatform(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Proyecto\\Imagenes\\goku.jpg"));
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
		dkpane.setBounds(0, 0, 624, 468);
		contentPane.add(dkpane);
		
		JButton btRegis = new JButton("Registrar");
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
		lblNewLabel.setBounds(168, 57, 321, 31);
		lblNewLabel.setFont(new Font("Wide Latin", Font.PLAIN, 14));
		dkpane.add(lblNewLabel);
		
		lbContraseña = new JLabel("CONTRASEÑA");
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
		lblNewLabel_1.setBounds(218, 204, 168, 20);
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 11));
		dkpane.add(lblNewLabel_1);
		
		JButton btIniciar = new JButton("INICIAR");
		btIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btIniciar.setBounds(265, 266, 89, 23);
		dkpane.add(btIniciar);
		
		
		
		
	}
	
	public void registrar() {
		B_Datos bd=new B_Datos();
		Modelo mo=new Modelo();
		mo.setCorreo(txtCorreo.getText());
		mo.setContraseña(txtContra.getText());
		bd.registrarse(mo);
		
	}
	 private void iniciarSesion() {
	        String correo = txtCorreo.getText();
	        String contraseña = new String(txtContra.getText());
	        Modelo modelo = new Modelo();
	 }
}
