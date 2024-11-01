package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.B_Datos;
import Controlador.Modelo;

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
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class SegundaVista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCorreo;
	private JTextField txtContra;
	private JTextField txtConfir;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Proyecto\\Imagenes\\goku.jpg"));
		setBounds(100, 100, 753, 428);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Opciones");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Regresar al menu");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaPrincipal prin=new VistaPrincipal();
				SegundaVista vis=new SegundaVista();
				prin.setVisible(true);
				vis.setVisible(false);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Iniciar con N. Telefonico");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TerceraVista ter= new TerceraVista();
				ter.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 766, 481);
		contentPane.add(desktopPane);
		
		JLabel lblNewLabel = new JLabel("Ingresa tu correo");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblNewLabel.setBounds(308, 43, 127, 14);
		desktopPane.add(lblNewLabel);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(242, 67, 241, 20);
		desktopPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Crea tu contraseña");
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(308, 110, 156, 14);
		desktopPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Confirma tu contraseña");
		lblNewLabel_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(297, 178, 148, 14);
		desktopPane.add(lblNewLabel_2);
		
		txtContra = new JTextField();
		txtContra.setBounds(242, 137, 241, 20);
		desktopPane.add(txtContra);
		txtContra.setColumns(10);
		
		txtConfir = new JTextField();
		txtConfir.setBounds(242, 203, 241, 20);
		desktopPane.add(txtConfir);
		txtConfir.setColumns(10);
		
		JButton btnNewButton = new JButton("Registrarme");
		btnNewButton.setSelectedIcon(new ImageIcon("E:\\Proyecto\\Imagenes\\goku.jpg"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modelo db = new Modelo();
				String contraseña = txtContra.getText();
				String confirmarContraseña = txtConfir.getText();
				String correo = txtCorreo.getText();
				Inicio in = new Inicio();

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
				    verificarCorreo();
				    registrar();  
				}
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(308, 265, 108, 14);
		desktopPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("E:\\Proyecto\\Imagenes\\125757761-fondo-creativo-de-onda-para-fondos-de-pantalla-de-presentaciones-de-negocios-folletos-portadas.jpg"));
		lblNewLabel_3.setBounds(0, 0, 737, 459);
		desktopPane.add(lblNewLabel_3);
	}
	public void registrar() {
		B_Datos bd=new B_Datos();
		Modelo mo=new Modelo();
		mo.setCorreo(txtCorreo.getText());
		mo.setContraseña(txtContra.getText());
		mo.setConfir(txtConfir.getText());
		bd.registrarse(mo);
		
	}
	 
	  private void verificarCorreo() {
	        String correo = txtCorreo.getText().toLowerCase();
			B_Datos bd=new B_Datos();
			Inicio in=new Inicio();
	        if (bd.verificarCorreo(correo)) {
	        	JOptionPane.showMessageDialog(contentPane, "El correo ya está registrado.");
	        } else {
	            JOptionPane.showMessageDialog(contentPane, "bienvenido");
	            in.setVisible(true);
	        }
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
