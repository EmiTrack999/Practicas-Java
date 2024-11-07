package Vistas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Controlador.B_Datos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Transporte extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> comboBox;
    private JRadioButton RADIOSIM, RADIONOM, rdbtnMaterialPesadoSi, rdbtnMaterialPesadoNo;
    private JRadioButton rdbtnTransportaPersonalSi, rdbtnTransportaPersonalNo, rdbtnParadasContinuasSi, rdbtnParadasContinuasNo;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Transporte frame = new Transporte();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Transporte() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 834, 500);
        contentPane = new JPanel();
        contentPane.setBackground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Bienvenido ¡Iniciaemos Tu Transporte!");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(200, 25, 430, 30);
        contentPane.add(lblNewLabel);

        JLabel lblTipoDeTransporte = new JLabel("Tipo de Transporte    :");
        lblTipoDeTransporte.setForeground(Color.WHITE);
        lblTipoDeTransporte.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        lblTipoDeTransporte.setBounds(148, 71, 145, 30);
        contentPane.add(lblTipoDeTransporte);

        comboBox = new JComboBox<>();
        comboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Transporte", "Pesado", "Ligero"}));
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
        comboBox.setBounds(318, 66, 145, 38);
        contentPane.add(comboBox);

        JLabel lblMaterialSensible = new JLabel("¿Material Sensible?    :");
        lblMaterialSensible.setForeground(Color.WHITE);
        lblMaterialSensible.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
        lblMaterialSensible.setBounds(135, 145, 158, 30);
        contentPane.add(lblMaterialSensible);

        RADIOSIM = new JRadioButton("Si");
        RADIOSIM.setFont(new Font("Tahoma", Font.BOLD, 15));
        RADIOSIM.setBounds(318, 149, 103, 21);
        contentPane.add(RADIOSIM);

        RADIONOM = new JRadioButton("No");
        RADIONOM.setFont(new Font("Tahoma", Font.BOLD, 15));
        RADIONOM.setBounds(442, 149, 103, 21);
        contentPane.add(RADIONOM);

        JLabel lblMaterialPesado = new JLabel("¿El Material es pesado?      :");
        lblMaterialPesado.setForeground(Color.WHITE);
        lblMaterialPesado.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
        lblMaterialPesado.setBounds(101, 211, 196, 30);
        contentPane.add(lblMaterialPesado);

        rdbtnMaterialPesadoSi = new JRadioButton("Si");
        rdbtnMaterialPesadoSi.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnMaterialPesadoSi.setBounds(318, 215, 103, 21);
        contentPane.add(rdbtnMaterialPesadoSi);

        rdbtnMaterialPesadoNo = new JRadioButton("No");
        rdbtnMaterialPesadoNo.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnMaterialPesadoNo.setBounds(442, 215, 103, 21);
        contentPane.add(rdbtnMaterialPesadoNo);

        JLabel lblTransportaPersonal = new JLabel("¿Se Transporta Personal?       :");
        lblTransportaPersonal.setForeground(Color.WHITE);
        lblTransportaPersonal.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
        lblTransportaPersonal.setBounds(82, 269, 204, 30);
        contentPane.add(lblTransportaPersonal);

        rdbtnTransportaPersonalSi = new JRadioButton("Si");
        rdbtnTransportaPersonalSi.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnTransportaPersonalSi.setBounds(318, 273, 103, 21);
        contentPane.add(rdbtnTransportaPersonalSi);

        rdbtnTransportaPersonalNo = new JRadioButton("No");
        rdbtnTransportaPersonalNo.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnTransportaPersonalNo.setBounds(442, 273, 103, 21);
        contentPane.add(rdbtnTransportaPersonalNo);

        JLabel lblParadasContinuas = new JLabel("¿El destino Tiene Paradas Continuas?       :");
        lblParadasContinuas.setForeground(Color.WHITE);
        lblParadasContinuas.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
        lblParadasContinuas.setBounds(10, 333, 287, 30);
        contentPane.add(lblParadasContinuas);

        rdbtnParadasContinuasSi = new JRadioButton("Si");
        rdbtnParadasContinuasSi.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnParadasContinuasSi.setBounds(318, 340, 103, 21);
        contentPane.add(rdbtnParadasContinuasSi);

        rdbtnParadasContinuasNo = new JRadioButton("No");
        rdbtnParadasContinuasNo.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnParadasContinuasNo.setBounds(442, 340, 103, 21);
        contentPane.add(rdbtnParadasContinuasNo);

        JButton btnEnviar = new JButton("Enviar");
        btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnEnviar.setBounds(607, 399, 112, 21);
        contentPane.add(btnEnviar);
        btnEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	guardar_transporte();
            }
        });
    }
    public void guardar_transporte() {
    	B_Datos bd=new B_Datos();
    String tipoTransporte = comboBox.getSelectedItem().toString();
    boolean materialSensible = RADIOSIM.isSelected();
    boolean materialPesado = rdbtnMaterialPesadoSi.isSelected();
    boolean transportaPersonal = rdbtnTransportaPersonalSi.isSelected();
    boolean paradasContinuas = rdbtnParadasContinuasSi.isSelected();
    boolean resultado = bd.guardarTransporte(tipoTransporte, materialSensible, materialPesado, transportaPersonal, paradasContinuas);
    if (resultado) {
        JOptionPane.showMessageDialog(null, "Tus datos ya fueron guardados");
    } else {
        JOptionPane.showMessageDialog(null, "Hubo un error al guardar tus datos");
    } 
    }
}
