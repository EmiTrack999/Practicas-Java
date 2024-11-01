package Vistas;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;

public class Viaje extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Viaje frame = new Viaje();
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
	public Viaje() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\hola_pancho\\Proyecto\\Imagenes\\Camion.jfif"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1083, 633);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIniciemosUnNuevo = new JLabel("Iniciemos un nuevo viaje ");
		lblIniciemosUnNuevo.setForeground(Color.BLACK);
		lblIniciemosUnNuevo.setFont(new Font("MS UI Gothic", Font.BOLD, 20));
		lblIniciemosUnNuevo.setBounds(305, 10, 252, 37);
		contentPane.add(lblIniciemosUnNuevo);
		
		JLabel lblLocalidadDondeSe = new JLabel("Localidad donde se lleva el Producto");
		lblLocalidadDondeSe.setForeground(Color.BLACK);
		lblLocalidadDondeSe.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLocalidadDondeSe.setBounds(275, 57, 282, 19);
		contentPane.add(lblLocalidadDondeSe);
		
		textField = new JTextField();
		textField.setBounds(275, 86, 282, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblelProductoEs = new JLabel("¿El Producto es Fragil?");
		lblelProductoEs.setForeground(Color.BLACK);
		lblelProductoEs.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblelProductoEs.setBounds(325, 115, 185, 19);
		contentPane.add(lblelProductoEs);
		
		JRadioButton rdbtnSi = new JRadioButton("Si");
		rdbtnSi.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnSi.setBounds(278, 140, 103, 21);
		contentPane.add(rdbtnSi);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNo.setBounds(454, 140, 103, 21);
		contentPane.add(rdbtnNo);
		
		// Crear el ButtonGroup para agrupar "Si" y "No"
		ButtonGroup fragilGroup = new ButtonGroup();
		fragilGroup.add(rdbtnSi);
		fragilGroup.add(rdbtnNo);
		
		JLabel lblLugarDondeSe = new JLabel("Lugar donde Se llevara Acabo el Viaje");
		lblLugarDondeSe.setForeground(Color.BLACK);
		lblLugarDondeSe.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLugarDondeSe.setBounds(275, 173, 306, 19);
		contentPane.add(lblLugarDondeSe);
		
		textField_1 = new JTextField();
		textField_1.setBounds(275, 202, 282, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Finalizar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(371, 344, 139, 45);
		contentPane.add(btnNewButton);
	}
}
