package Vistas;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class Transporte extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		setBounds(100, 100, 834, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido ¡Iniciemos Tu Transporte!");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(127, 10, 489, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblTipoDeTransporte = new JLabel("Tipo de Transporte");
		lblTipoDeTransporte.setForeground(Color.WHITE);
		lblTipoDeTransporte.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTipoDeTransporte.setBounds(101, 74, 196, 30);
		contentPane.add(lblTipoDeTransporte);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"Transporte", "Pesado", "Ligero"}));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox.setBounds(318, 66, 145, 38);
		contentPane.add(comboBox);
		
		JLabel lblmaterialSensible = new JLabel("¿Material Sensible?");
		lblmaterialSensible.setForeground(Color.WHITE);
		lblmaterialSensible.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblmaterialSensible.setBounds(101, 142, 196, 30);
		contentPane.add(lblmaterialSensible);
		
		JRadioButton RADIOSIM = new JRadioButton("Si");
		RADIOSIM.setFont(new Font("Tahoma", Font.BOLD, 15));
		RADIOSIM.setBounds(318, 149, 103, 21);
		contentPane.add(RADIOSIM);
		
		JRadioButton RADIONOM = new JRadioButton("No");
		RADIONOM.setFont(new Font("Tahoma", Font.BOLD, 15));
		RADIONOM.setBounds(442, 149, 103, 21);
		contentPane.add(RADIONOM);
		
		ButtonGroup grupoMaterialSensible = new ButtonGroup();
		grupoMaterialSensible.add(RADIOSIM);
		grupoMaterialSensible.add(RADIONOM);
		
		JLabel lblelMaterialEs = new JLabel("¿El Material es pesado?");
		lblelMaterialEs.setForeground(Color.WHITE);
		lblelMaterialEs.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblelMaterialEs.setBounds(101, 208, 196, 30);
		contentPane.add(lblelMaterialEs);
		
		JRadioButton rdbtnMaterialPesadoSi = new JRadioButton("Si");
		rdbtnMaterialPesadoSi.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnMaterialPesadoSi.setBounds(318, 215, 103, 21);
		contentPane.add(rdbtnMaterialPesadoSi);
		
		JRadioButton rdbtnMaterialPesadoNo = new JRadioButton("No");
		rdbtnMaterialPesadoNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnMaterialPesadoNo.setBounds(442, 215, 103, 21);
		contentPane.add(rdbtnMaterialPesadoNo);
		
		ButtonGroup grupoMaterialPesado = new ButtonGroup();
		grupoMaterialPesado.add(rdbtnMaterialPesadoSi);
		grupoMaterialPesado.add(rdbtnMaterialPesadoNo);
		
		JLabel lblseTransportaPersonal = new JLabel("¿Se Transporta Personal?");
		lblseTransportaPersonal.setForeground(Color.WHITE);
		lblseTransportaPersonal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblseTransportaPersonal.setBounds(101, 266, 196, 30);
		contentPane.add(lblseTransportaPersonal);
		
		JRadioButton rdbtnTransportaPersonalSi = new JRadioButton("Si");
		rdbtnTransportaPersonalSi.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnTransportaPersonalSi.setBounds(318, 273, 103, 21);
		contentPane.add(rdbtnTransportaPersonalSi);
		
		JRadioButton rdbtnTransportaPersonalNo = new JRadioButton("No");
		rdbtnTransportaPersonalNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnTransportaPersonalNo.setBounds(442, 273, 103, 21);
		contentPane.add(rdbtnTransportaPersonalNo);
		
		ButtonGroup grupoTransportaPersonal = new ButtonGroup();
		grupoTransportaPersonal.add(rdbtnTransportaPersonalSi);
		grupoTransportaPersonal.add(rdbtnTransportaPersonalNo);
		
		JLabel lblelDestinoTiene = new JLabel("¿El destino Tiene Paradas Continuas?");
		lblelDestinoTiene.setForeground(Color.WHITE);
		lblelDestinoTiene.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblelDestinoTiene.setBounds(10, 333, 287, 30);
		contentPane.add(lblelDestinoTiene);
		
		JRadioButton rdbtnParadasContinuasSi = new JRadioButton("Si");
		rdbtnParadasContinuasSi.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnParadasContinuasSi.setBounds(318, 340, 103, 21);
		contentPane.add(rdbtnParadasContinuasSi);
		
		JRadioButton rdbtnParadasContinuasNo = new JRadioButton("No");
		rdbtnParadasContinuasNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnParadasContinuasNo.setBounds(442, 340, 103, 21);
		contentPane.add(rdbtnParadasContinuasNo);
		
		ButtonGroup grupoParadasContinuas = new ButtonGroup();
		grupoParadasContinuas.add(rdbtnParadasContinuasSi);
		grupoParadasContinuas.add(rdbtnParadasContinuasNo);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEnviar.setBounds(607, 399, 112, 21);
		contentPane.add(btnEnviar);
		
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipoTransporte = comboBox.getSelectedItem().toString();
				String materialSensible = RADIOSIM.isSelected() ? "Si" : "No";
				String materialPesado = rdbtnMaterialPesadoSi.isSelected() ? "Si" : "No";
				String transportaPersonal = rdbtnTransportaPersonalSi.isSelected() ? "Si" : "No";
				String paradasContinuas = rdbtnParadasContinuasSi.isSelected() ? "Si" : "No";
				
				// Muestra la información en un cuadro de diálogo
				JOptionPane.showMessageDialog(contentPane, 
					"Tipo de Transporte: " + tipoTransporte + "\n" +
					"Material Sensible: " + materialSensible + "\n" +
					"Material Pesado: " + materialPesado + "\n" +
					"Transporte de Personal: " + transportaPersonal + "\n" +
					"Paradas Continuas: " + paradasContinuas,
					"Información del Transporte",
					JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
}

