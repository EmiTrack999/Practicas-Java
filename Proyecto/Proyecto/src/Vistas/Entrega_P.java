package Vistas;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;

public class Entrega_P extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entrega_P frame = new Entrega_P();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Entrega_P() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 832, 528);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Residencia");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(23, 28, 109, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre Quien Recibe");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(23, 65, 194, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Codigo de Seguridad");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(23, 112, 181, 39);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Estado de Paquete");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(25, 175, 192, 23);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Observaciones hacia el Repartidor");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(23, 231, 306, 32);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Llego en tiempo y forma");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(24, 289, 240, 23);
		contentPane.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(302, 27, 306, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(302, 65, 306, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(302, 115, 306, 20);
		contentPane.add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(318, 227, 306, 44);
		contentPane.add(textField_4);
		
		// Radio buttons para Estado de Paquete
		JRadioButton rdbtnBueno = new JRadioButton("Bueno");
		rdbtnBueno.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnBueno.setBounds(302, 177, 109, 23);
		contentPane.add(rdbtnBueno);
		
		JRadioButton rdbtnRegular = new JRadioButton("Regular");
		rdbtnRegular.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnRegular.setBounds(428, 177, 109, 23);
		contentPane.add(rdbtnRegular);
		
		JRadioButton rdbtnMalo = new JRadioButton("Malo");
		rdbtnMalo.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnMalo.setBounds(554, 177, 109, 23);
		contentPane.add(rdbtnMalo);
		
		// Agrupar los radio buttons de Estado de Paquete
		ButtonGroup estadoGroup = new ButtonGroup();
		estadoGroup.add(rdbtnBueno);
		estadoGroup.add(rdbtnRegular);
		estadoGroup.add(rdbtnMalo);
		
		// Radio buttons para "Llego en tiempo y forma"
		JRadioButton rdbtnSi = new JRadioButton("Si");
		rdbtnSi.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnSi.setBounds(302, 291, 109, 23);
		contentPane.add(rdbtnSi);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnNo.setBounds(499, 291, 109, 23);
		contentPane.add(rdbtnNo);
		
		// Agrupar los radio buttons de "Llego en tiempo y forma"
		ButtonGroup tiempoFormaGroup = new ButtonGroup();
		tiempoFormaGroup.add(rdbtnSi);
		tiempoFormaGroup.add(rdbtnNo);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnEnviar.setBounds(343, 344, 150, 50);
		contentPane.add(btnEnviar);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("E:\\Proyecto\\Imagenes\\Entrega_P.png"));
		lblNewLabel_6.setBounds(0, 0, 816, 489);
		contentPane.add(lblNewLabel_6);
	}
}
