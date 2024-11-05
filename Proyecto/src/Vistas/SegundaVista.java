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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Color;

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
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Proyecto\\Imagenes\\goku.jpg"));
		setBounds(100, 100, 730, 441);
		
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
		desktopPane.setBackground(new Color(0, 0, 0));
		desktopPane.setBounds(0, 0, 766, 481);
		contentPane.add(desktopPane);
		
		JLabel lblNewLabel = new JLabel("Ingresa tu correo");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(308, 86, 108, 14);
		desktopPane.add(lblNewLabel);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(242, 120, 241, 20);
		desktopPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Crea tu contraseña");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(308, 159, 115, 14);
		desktopPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Confirma tu contraseña");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2.setBounds(297, 226, 148, 14);
		desktopPane.add(lblNewLabel_2);
		
		txtContra = new JTextField();
		txtContra.setBounds(242, 184, 241, 20);
		desktopPane.add(txtContra);
		txtContra.setColumns(10);
		
		txtConfir = new JTextField();
		txtConfir.setBounds(242, 251, 241, 20);
		desktopPane.add(txtConfir);
		txtConfir.setColumns(10);
		
		JButton btnNewButton = new JButton("Registrarme");
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
				B_Datos bd=new B_Datos();
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
					 registrar();
				 
				}
				
				
				   
				
				
				
			}
		});
		btnNewButton.setBounds(308, 296, 108, 14);
		desktopPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Registro");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(285, 11, 148, 64);
		desktopPane.add(lblNewLabel_3);
	}
	public void registrar() {
		B_Datos bd=new B_Datos();
		Inicio in=new Inicio();
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
	        JOptionPane.showMessageDialog(null, "Bienvenido  "+ correo);
	        in.setVisible(true);
	    } else {
	        JOptionPane.showMessageDialog(null, "Error al registrar.");
	    }
	

	}
}
