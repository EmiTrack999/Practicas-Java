package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.B_Datos;
import Controlador.Modelo;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TerceraVista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTelefono;
	private JTextField txtContra;
	private JTextField textField_2;
	private JTextField txtConfir;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TerceraVista frame = new TerceraVista();
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
	public TerceraVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 436);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Opciones");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Regresar al menu");
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Iniciar con Correo");
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingresa tu Telefono:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(272, 73, 138, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Crea tu Contraseña:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(272, 159, 132, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Confirma tu contraseña:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(261, 235, 149, 14);
		contentPane.add(lblNewLabel_2);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(219, 98, 250, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtContra = new JTextField();
		txtContra.setBounds(219, 184, 250, 20);
		contentPane.add(txtContra);
		txtContra.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(1000, 1000, 1000, 1000);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		txtConfir = new JTextField();
		txtConfir.setBounds(219, 260, 250, 20);
		contentPane.add(txtConfir);
		txtConfir.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Registro");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(272, 0, 149, 48);
		contentPane.add(lblNewLabel_3);
		
		btnNewButton = new JButton("Registrarme");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modelo db = new Modelo();
				String contraseña = txtContra.getText();
				String confirmarContraseña = txtConfir.getText();
				String telefono = txtTelefono.getText();
				Inicio in = new Inicio();
				B_Datos bd=new B_Datos();
				if (telefono.isEmpty()) {
				    JOptionPane.showMessageDialog(null, "Ingresa tu correo");
				  
				} else if (!db.validarCorreo(telefono)) {
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
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(293, 306, 111, 14);
		contentPane.add(btnNewButton);
	}
	public void registrar() {
		B_Datos bd=new B_Datos();
		Inicio in=new Inicio();
		String telefono = txtTelefono.getText();
	    String contraseña = txtContra.getText();
	    String confirmar = txtConfir.getText();
	    if (bd.verificarCorreo(telefono)) {
	        JOptionPane.showMessageDialog(null, "El correo ya está registrado.");
	        return;
	    }
	    Modelo mo = new Modelo();
	    mo.setCorreo(telefono);
	    mo.setContraseña(contraseña);
	    if (bd.registrarse(mo)) {
	        JOptionPane.showMessageDialog(null, "Bienvenido");
	        in.setVisible(true);
	    } else {
	        JOptionPane.showMessageDialog(null, "Error al registrar.");
	    }
	}
}
