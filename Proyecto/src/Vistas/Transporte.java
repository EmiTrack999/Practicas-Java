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
    private JTextField txtApellidos;
    String textoSeleccionado;

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
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Transporte.class.getResource("/Vistas/img/cargofleets2.png")));
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
        lblTipoDeTransporte.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        lblTipoDeTransporte.setBounds(200, 134, 145, 30);
        contentPane.add(lblTipoDeTransporte);

        comboBox = new JComboBox<>();
        comboBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		textoSeleccionado = comboBox.getSelectedItem().toString();
                System.out.println("Texto seleccionado: " + textoSeleccionado);
        	}
        });
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Transporte", "Pesado", "Ligero"}));
        comboBox.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        comboBox.setBounds(383, 129, 145, 38);
        contentPane.add(comboBox);
  



        JLabel lblMaterialSensible = new JLabel("¿Material Sensible?    :");
        lblMaterialSensible.setForeground(Color.WHITE);
        lblMaterialSensible.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        lblMaterialSensible.setBounds(200, 206, 158, 30);
        contentPane.add(lblMaterialSensible);

        RADIOSIM = new JRadioButton("Si");
        RADIOSIM.setBackground(new Color(0, 0, 0));
        RADIOSIM.setForeground(new Color(255, 255, 255));
        RADIOSIM.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        RADIOSIM.setBounds(383, 210, 103, 21);
        contentPane.add(RADIOSIM);

        RADIONOM = new JRadioButton("No");
        RADIONOM.setBackground(new Color(0, 0, 0));
        RADIONOM.setForeground(new Color(255, 255, 255));
        RADIONOM.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        RADIONOM.setBounds(507, 210, 103, 21);
        contentPane.add(RADIONOM);

        JLabel lblTransportaPersonal = new JLabel("¿Se Transporta Personal?       :");
        lblTransportaPersonal.setForeground(Color.WHITE);
        lblTransportaPersonal.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        lblTransportaPersonal.setBounds(120, 269, 231, 30);
        contentPane.add(lblTransportaPersonal);

        rdbtnTransportaPersonalSi = new JRadioButton("Si");
        rdbtnTransportaPersonalSi.setBackground(new Color(0, 0, 0));
        rdbtnTransportaPersonalSi.setForeground(new Color(255, 255, 255));
        rdbtnTransportaPersonalSi.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        rdbtnTransportaPersonalSi.setBounds(383, 273, 103, 21);
        contentPane.add(rdbtnTransportaPersonalSi);

        rdbtnTransportaPersonalNo = new JRadioButton("No");
        rdbtnTransportaPersonalNo.setBackground(new Color(0, 0, 0));
        rdbtnTransportaPersonalNo.setForeground(new Color(255, 255, 255));
        rdbtnTransportaPersonalNo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        rdbtnTransportaPersonalNo.setBounds(507, 273, 103, 21);
        contentPane.add(rdbtnTransportaPersonalNo);

        JLabel lblParadasContinuas = new JLabel("¿El destino Tiene Paradas Continuas?       :");
        lblParadasContinuas.setForeground(Color.WHITE);
        lblParadasContinuas.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        lblParadasContinuas.setBounds(60, 333, 302, 30);
        contentPane.add(lblParadasContinuas);

        rdbtnParadasContinuasSi = new JRadioButton("Si");
        rdbtnParadasContinuasSi.setBackground(new Color(0, 0, 0));
        rdbtnParadasContinuasSi.setForeground(new Color(255, 255, 255));
        rdbtnParadasContinuasSi.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        rdbtnParadasContinuasSi.setBounds(383, 340, 103, 21);
        contentPane.add(rdbtnParadasContinuasSi);

        rdbtnParadasContinuasNo = new JRadioButton("No");
        rdbtnParadasContinuasNo.setBackground(new Color(0, 0, 0));
        rdbtnParadasContinuasNo.setForeground(new Color(255, 255, 255));
        rdbtnParadasContinuasNo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        rdbtnParadasContinuasNo.setBounds(507, 340, 103, 21);
        contentPane.add(rdbtnParadasContinuasNo);
        
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
        
        JLabel lblNewLabel_1 = new JLabel("Nombre  :");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(88, 89, 90, 14);
        contentPane.add(lblNewLabel_1);
        
        txtNombre = new JTextField();
        txtNombre.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        txtNombre.setBounds(175, 86, 179, 20);
        contentPane.add(txtNombre);
        txtNombre.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Apellidos   :");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        lblNewLabel_2.setBounds(395, 90, 84, 14);
        contentPane.add(lblNewLabel_2);
        
        txtApellidos = new JTextField();
        txtApellidos.setBounds(489, 87, 265, 20);
        contentPane.add(txtApellidos);
        txtApellidos.setColumns(10);
        
        JButton btnNewButton = new JButton("Iniciar");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Coti_Transporte ct=new Coti_Transporte();
        		ct.setVisible(true);
        		dispose();
        	}
        });
        btnNewButton.setBackground(new Color(255, 0, 0));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBounds(323, 374, 145, 39);
        contentPane.add(btnNewButton);
    }

}
