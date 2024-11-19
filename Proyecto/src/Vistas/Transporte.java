package Vistas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Controlador.B_Datos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class Transporte extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> comboBox;
    private JRadioButton RADIOSIM, RADIONOM;
    private JRadioButton rdbtnTransportaPersonalSi, rdbtnTransportaPersonalNo, rdbtnParadasContinuasSi, rdbtnParadasContinuasNo;
    private JTextField txtNombre;

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
    	setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 834, 500);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu mnNewMenu = new JMenu("Opciones");
        menuBar.add(mnNewMenu);
        
        JMenuItem mntmNewMenuItem = new JMenuItem("Regresar al menu");
        mntmNewMenuItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Inicio in=new Inicio();
				in.setVisible(true);
				dispose();  	
        	}
        });
        mnNewMenu.add(mntmNewMenuItem);
        
        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Ayuda");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String url="https://ayudaacliente.netlify.app/";
				if(Desktop.isDesktopSupported()&&Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)){
					try {
						Desktop.getDesktop().browse(new URI(url));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}				}
        	}
        });
        mnNewMenu.add(mntmNewMenuItem_1);
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
        lblTipoDeTransporte.setBounds(135, 134, 145, 30);
        contentPane.add(lblTipoDeTransporte);

        comboBox = new JComboBox<>();
        comboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Transporte", "Pesado", "Ligero"}));
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
        comboBox.setBounds(318, 129, 145, 38);
        contentPane.add(comboBox);

        JLabel lblMaterialSensible = new JLabel("¿Material Sensible?    :");
        lblMaterialSensible.setForeground(Color.WHITE);
        lblMaterialSensible.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
        lblMaterialSensible.setBounds(135, 206, 158, 30);
        contentPane.add(lblMaterialSensible);

        RADIOSIM = new JRadioButton("Si");
        RADIOSIM.setFont(new Font("Tahoma", Font.BOLD, 15));
        RADIOSIM.setBounds(318, 210, 103, 21);
        contentPane.add(RADIOSIM);

        RADIONOM = new JRadioButton("No");
        RADIONOM.setFont(new Font("Tahoma", Font.BOLD, 15));
        RADIONOM.setBounds(442, 210, 103, 21);
        contentPane.add(RADIONOM);

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
        btnEnviar.setBackground(new Color(255, 0, 0));
        btnEnviar.setForeground(new Color(255, 255, 255));
        btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnEnviar.setBounds(341, 390, 112, 21);
        contentPane.add(btnEnviar);
        btnEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	guardar_transporte();
            }
        });
        
        ButtonGroup bgMaterialSensible = new ButtonGroup();
        ButtonGroup bgMaterialPesado = new ButtonGroup();
        ButtonGroup bgTransportaPersonal = new ButtonGroup();
        ButtonGroup bgParadasContinuas = new ButtonGroup();

        bgMaterialSensible.add(RADIOSIM);
        bgMaterialSensible.add(RADIONOM);

        bgTransportaPersonal.add(rdbtnTransportaPersonalSi);
        bgTransportaPersonal.add(rdbtnTransportaPersonalNo);

        bgParadasContinuas.add(rdbtnParadasContinuasSi);
        bgParadasContinuas.add(rdbtnParadasContinuasNo);
        
        JLabel lblNewLabel_1 = new JLabel("Nombre del Solicitante   :");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(128, 87, 158, 14);
        contentPane.add(lblNewLabel_1);
        
        txtNombre = new JTextField();
        txtNombre.setBounds(320, 85, 329, 20);
        contentPane.add(txtNombre);
        txtNombre.setColumns(10);
    }
    public void guardar_transporte() {
        try {
            if (comboBox.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Selecciona un tipo de transporte.");
                return;
            }

            if (!RADIOSIM.isSelected() && !RADIONOM.isSelected()) {
                JOptionPane.showMessageDialog(null, "Selecciona si el material es sensible.");
                return;
            }

            if (!rdbtnTransportaPersonalSi.isSelected() && !rdbtnTransportaPersonalNo.isSelected()) {
                JOptionPane.showMessageDialog(null, "Selecciona si se transporta personal.");
                return;
            }

            if (!rdbtnParadasContinuasSi.isSelected() && !rdbtnParadasContinuasNo.isSelected()) {
                JOptionPane.showMessageDialog(null, "Selecciona si el destino tiene paradas continuas.");
                return;
            }

            B_Datos bd = new B_Datos();
            String nombre = txtNombre.getText(); 
            String tipoTransporte = comboBox.getSelectedItem().toString();
            boolean materialSensible = RADIOSIM.isSelected();
            boolean paradasContinuas = rdbtnParadasContinuasSi.isSelected();
            boolean personal = rdbtnTransportaPersonalSi.isSelected();

            boolean resultado = bd.guardarTransporte(tipoTransporte, nombre, personal, paradasContinuas, materialSensible);

            if (resultado) {
                JOptionPane.showMessageDialog(null, "Tus datos ya fueron guardados");
                Coti_Transporte ct = new Coti_Transporte();
                ct.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error al guardar tus datos");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Se produjo un error inesperado.");
        }
    }

}
