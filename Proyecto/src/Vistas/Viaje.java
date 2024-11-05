package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class Viaje extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblDireccinDeDestino_1;
	private JTextField textField_3;

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
		setTitle("VIAJES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 512);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("COMENSEMOS SU VIAJE");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(212, 11, 423, 54);
		contentPane.add(lblNewLabel);
		
		JLabel lblNumeroDePersonas = new JLabel("NUMERO DE PERSONAS QUE VIAJAN :");
		lblNumeroDePersonas.setForeground(Color.WHITE);
		lblNumeroDePersonas.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNumeroDePersonas.setBounds(31, 76, 322, 37);
		contentPane.add(lblNumeroDePersonas);
		
		textField = new JTextField();
		textField.setBackground(new Color(35, 35, 35));
		textField.setForeground(new Color(255, 255, 255));
		textField.setBounds(396, 85, 222, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDireccionDesdeLa = new JLabel("DIRECCION DESDE LA QUE SE RECOGE:");
		lblDireccionDesdeLa.setForeground(Color.WHITE);
		lblDireccionDesdeLa.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblDireccionDesdeLa.setBounds(31, 124, 322, 37);
		contentPane.add(lblDireccionDesdeLa);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(35, 35, 35));
		textField_1.setBounds(396, 133, 222, 20);
		contentPane.add(textField_1);
		
		JLabel lblDireccinDeDestino = new JLabel("DIRECCIÓN DE DESTINO: ");
		lblDireccinDeDestino.setForeground(Color.WHITE);
		lblDireccinDeDestino.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblDireccinDeDestino.setBounds(31, 182, 322, 37);
		contentPane.add(lblDireccinDeDestino);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.WHITE);
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(35, 35, 35));
		textField_2.setBounds(396, 191, 222, 20);
		contentPane.add(textField_2);
		
		lblDireccinDeDestino_1 = new JLabel("DIRECCIÓN DE DESTINO: ");
		lblDireccinDeDestino_1.setForeground(Color.WHITE);
		lblDireccinDeDestino_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblDireccinDeDestino_1.setBounds(31, 240, 322, 37);
		contentPane.add(lblDireccinDeDestino_1);
		
		textField_3 = new JTextField();
		textField_3.setForeground(Color.WHITE);
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(35, 35, 35));
		textField_3.setBounds(396, 249, 222, 20);
		contentPane.add(textField_3);
	}
} 