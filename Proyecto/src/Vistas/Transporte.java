package Vistas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
        lblNewLabel.setBounds(127, 10, 489, 30);
        contentPane.add(lblNewLabel);

        JLabel lblTipoDeTransporte = new JLabel("Tipo de Transporte");
        lblTipoDeTransporte.setForeground(Color.WHITE);
        lblTipoDeTransporte.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTipoDeTransporte.setBounds(101, 74, 196, 30);
        contentPane.add(lblTipoDeTransporte);

        comboBox = new JComboBox<>();
        comboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Transporte", "Pesado", "Ligero"}));
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
        comboBox.setBounds(318, 66, 145, 38);
        contentPane.add(comboBox);

        JLabel lblMaterialSensible = new JLabel("¿Material Sensible?");
        lblMaterialSensible.setForeground(Color.WHITE);
        lblMaterialSensible.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblMaterialSensible.setBounds(101, 142, 196, 30);
        contentPane.add(lblMaterialSensible);

        RADIOSIM = new JRadioButton("Si");
        RADIOSIM.setFont(new Font("Tahoma", Font.BOLD, 15));
        RADIOSIM.setBounds(318, 149, 103, 21);
        contentPane.add(RADIOSIM);

        RADIONOM = new JRadioButton("No");
        RADIONOM.setFont(new Font("Tahoma", Font.BOLD, 15));
        RADIONOM.setBounds(442, 149, 103, 21);
        contentPane.add(RADIONOM);

        ButtonGroup materialSensibleGroup = new ButtonGroup();
        materialSensibleGroup.add(RADIOSIM);
        materialSensibleGroup.add(RADIONOM);

        JLabel lblMaterialPesado = new JLabel("¿El Material es pesado?");
        lblMaterialPesado.setForeground(Color.WHITE);
        lblMaterialPesado.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblMaterialPesado.setBounds(101, 208, 196, 30);
        contentPane.add(lblMaterialPesado);

        rdbtnMaterialPesadoSi = new JRadioButton("Si");
        rdbtnMaterialPesadoSi.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnMaterialPesadoSi.setBounds(318, 215, 103, 21);
        contentPane.add(rdbtnMaterialPesadoSi);

        rdbtnMaterialPesadoNo = new JRadioButton("No");
        rdbtnMaterialPesadoNo.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnMaterialPesadoNo.setBounds(442, 215, 103, 21);
        contentPane.add(rdbtnMaterialPesadoNo);

        ButtonGroup materialPesadoGroup = new ButtonGroup();
        materialPesadoGroup.add(rdbtnMaterialPesadoSi);
        materialPesadoGroup.add(rdbtnMaterialPesadoNo);

        JLabel lblTransportaPersonal = new JLabel("¿Se Transporta Personal?");
        lblTransportaPersonal.setForeground(Color.WHITE);
        lblTransportaPersonal.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTransportaPersonal.setBounds(101, 266, 196, 30);
        contentPane.add(lblTransportaPersonal);

        rdbtnTransportaPersonalSi = new JRadioButton("Si");
        rdbtnTransportaPersonalSi.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnTransportaPersonalSi.setBounds(318, 273, 103, 21);
        contentPane.add(rdbtnTransportaPersonalSi);

        rdbtnTransportaPersonalNo = new JRadioButton("No");
        rdbtnTransportaPersonalNo.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnTransportaPersonalNo.setBounds(442, 273, 103, 21);
        contentPane.add(rdbtnTransportaPersonalNo);

        ButtonGroup transportaPersonalGroup = new ButtonGroup();
        transportaPersonalGroup.add(rdbtnTransportaPersonalSi);
        transportaPersonalGroup.add(rdbtnTransportaPersonalNo);

        JLabel lblParadasContinuas = new JLabel("¿El destino Tiene Paradas Continuas?");
        lblParadasContinuas.setForeground(Color.WHITE);
        lblParadasContinuas.setFont(new Font("Tahoma", Font.BOLD, 15));
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

        ButtonGroup paradasContinuasGroup = new ButtonGroup();
        paradasContinuasGroup.add(rdbtnParadasContinuasSi);
        paradasContinuasGroup.add(rdbtnParadasContinuasNo);

        JButton btnEnviar = new JButton("Enviar");
        btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnEnviar.setBounds(607, 399, 112, 21);
        contentPane.add(btnEnviar);

        // Configuración del botón para guardar en la base de datos
        btnEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tipoTransporte = comboBox.getSelectedItem().toString();
                boolean materialSensible = RADIOSIM.isSelected();
                boolean materialPesado = rdbtnMaterialPesadoSi.isSelected();
                boolean transportaPersonal = rdbtnTransportaPersonalSi.isSelected();
                boolean paradasContinuas = rdbtnParadasContinuasSi.isSelected();

                boolean resultado = guardarTransporte(tipoTransporte, materialSensible, materialPesado, transportaPersonal, paradasContinuas);
                
                if (resultado) {
                    JOptionPane.showMessageDialog(null, "Datos guardados exitosamente en la base de datos.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar los datos en la base de datos.");
                }
            }
        });
    }

    // Método para establecer conexión con la base de datos
    public Connection conexion() {
        Connection cn = null;
        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/correos", "root", "");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos: " + e);
        }
        return cn;
    }

    // Método para guardar los datos del transporte en la base de datos
    public boolean guardarTransporte(String tipoTransporte, boolean materialSensible, boolean materialPesado, boolean transportaPersonal, boolean paradasContinuas) {
        boolean guardado = false;
        String sql = "INSERT INTO transporte (tipo_transporte, material_sensible, material_pesado, transporta_personal, paradas_continuas) VALUES (?, ?, ?, ?, ?)";
        try (Connection cn = conexion(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, tipoTransporte);
            ps.setBoolean(2, materialSensible);
            ps.setBoolean(3, materialPesado);
            ps.setBoolean(4, transportaPersonal);
            ps.setBoolean(5, paradasContinuas);
            ps.executeUpdate();
            guardado = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar en la base de datos: " + e);
        }
        return guardado;
    }
}