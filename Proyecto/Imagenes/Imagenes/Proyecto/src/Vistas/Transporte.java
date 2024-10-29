package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;

public class Transporte extends JFrame {

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
					Transporte frame = new Transporte();
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
	public Transporte() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 879, 509);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Localidad donde se lleva al personal");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(276, 22, 276, 13);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setBounds(276, 45, 276, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblLugarDondeEl = new JLabel("Lugar donde el persona acude");
		lblLugarDondeEl.setForeground(Color.WHITE);
		lblLugarDondeEl.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLugarDondeEl.setBounds(299, 92, 243, 19);
		contentPane.add(lblLugarDondeEl);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setBounds(276, 121, 276, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSexoDelPersonal = new JLabel("Sexo del Personal ");
		lblSexoDelPersonal.setForeground(Color.WHITE);
		lblSexoDelPersonal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSexoDelPersonal.setBounds(342, 150, 169, 19);
		contentPane.add(lblSexoDelPersonal);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Hombre");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnNewRadioButton.setBounds(276, 185, 103, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Mujer");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnNewRadioButton_1.setBounds(439, 185, 103, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Mixto");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnNewRadioButton_2.setBounds(361, 224, 103, 21);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JButton btnNewButton = new JButton("Finalizar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(361, 303, 124, 48);
		contentPane.add(btnNewButton);
	}
}
