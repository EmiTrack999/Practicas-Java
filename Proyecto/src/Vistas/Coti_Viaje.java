package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.GoogleM;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Coti_Viaje extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Coti_Viaje frame = new Coti_Viaje();
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
	public Coti_Viaje() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Coti_Viaje.class.getResource("/Vistas/Logo de la empresa.jpeg")));
		setResizable(false);
		setTitle("Cargo Fleets Solutions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1389, 781);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Opciones");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Info. de Ecofrend");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url="https://ayudaalusuario.netlify.app/";
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
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Ubicaciones Disponibles");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url="https://municipiosdisponibles.netlify.app/";
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
		mnNewMenu.add(mntmNewMenuItem_3);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Regresar al menu");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio in=new Inicio();
				in.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Ayuda");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
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
		mnNewMenu.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Coticemos tu Viaje");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(577, 10, 248, 54);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Deseas aportar  para el programa ecofrend del 10% de tu costo    :");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_3.setBounds(280, 484, 325, 14);
		contentPane.add(lblNewLabel_3);
		
		JRadioButton uno = new JRadioButton("SI");
		uno.setBounds(723, 480, 48, 23);
		contentPane.add(uno);
		
		JRadioButton dos = new JRadioButton("NO");
		dos.setBounds(874, 480, 48, 23);
		contentPane.add(dos);
		
		JButton btnNewButton = new JButton("Cotizar");
		btnNewButton.setIcon(new ImageIcon(Coti_Viaje.class.getResource("/Vistas/img/grafico-de-cotizaciones.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        	}
		});
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(604, 609, 139, 36);
		contentPane.add(btnNewButton);
		 ButtonGroup group = new ButtonGroup();
	        group.add(uno);
	        group.add(dos);
	        
	        JLabel lblNewLabel_1 = new JLabel("Nombre de La Calle");
	        lblNewLabel_1.setForeground(Color.WHITE);
	        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	        lblNewLabel_1.setBounds(52, 152, 301, 31);
	        contentPane.add(lblNewLabel_1);
	        
	        textField = new JTextField();
	        textField.setColumns(10);
	        textField.setBounds(398, 160, 295, 19);
	        contentPane.add(textField);
	        
	        JLabel lblNewLabel_1_1 = new JLabel("NO.Exterior");
	        lblNewLabel_1_1.setForeground(Color.WHITE);
	        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	        lblNewLabel_1_1.setBounds(52, 248, 301, 31);
	        contentPane.add(lblNewLabel_1_1);
	        
	        textField_1 = new JTextField();
	        textField_1.setColumns(10);
	        textField_1.setBounds(398, 207, 295, 19);
	        contentPane.add(textField_1);
	        
	        JLabel lblNewLabel_1_1_1 = new JLabel("Nombre del Barrio,Sector o Cuidad");
	        lblNewLabel_1_1_1.setForeground(Color.WHITE);
	        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	        lblNewLabel_1_1_1.setBounds(52, 301, 301, 31);
	        contentPane.add(lblNewLabel_1_1_1);
	        
	        JLabel lblNewLabel_1_2 = new JLabel("NO.Interior ");
	        lblNewLabel_1_2.setForeground(Color.WHITE);
	        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
	        lblNewLabel_1_2.setBounds(52, 207, 301, 31);
	        contentPane.add(lblNewLabel_1_2);
	        
	        textField_2 = new JTextField();
	        textField_2.setColumns(10);
	        textField_2.setBounds(398, 256, 295, 19);
	        contentPane.add(textField_2);
	        
	        textField_3 = new JTextField();
	        textField_3.setColumns(10);
	        textField_3.setBounds(398, 309, 295, 19);
	        contentPane.add(textField_3);
	        
	        JLabel lblNewLabel_1_1_1_1 = new JLabel("Codigo Postal");
	        lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
	        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	        lblNewLabel_1_1_1_1.setBounds(52, 355, 301, 31);
	        contentPane.add(lblNewLabel_1_1_1_1);
	        
	        textField_4 = new JTextField();
	        textField_4.setColumns(10);
	        textField_4.setBounds(398, 363, 295, 19);
	        contentPane.add(textField_4);
	        
	        JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Nombre del Estado o Pais ");
	        lblNewLabel_1_1_1_1_1.setForeground(Color.WHITE);
	        lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	        lblNewLabel_1_1_1_1_1.setBounds(52, 401, 301, 31);
	        contentPane.add(lblNewLabel_1_1_1_1_1);
	        
	        textField_5 = new JTextField();
	        textField_5.setColumns(10);
	        textField_5.setBounds(398, 409, 295, 19);
	        contentPane.add(textField_5);
	        
	        JLabel lblNewLabel_1_3 = new JLabel("Nombre de La Calle");
	        lblNewLabel_1_3.setForeground(Color.WHITE);
	        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
	        lblNewLabel_1_3.setBounds(703, 152, 301, 31);
	        contentPane.add(lblNewLabel_1_3);
	        
	        textField_6 = new JTextField();
	        textField_6.setColumns(10);
	        textField_6.setBounds(1049, 160, 295, 19);
	        contentPane.add(textField_6);
	        
	        JLabel lblNewLabel_1_1_2 = new JLabel("NO.Exterior");
	        lblNewLabel_1_1_2.setForeground(Color.WHITE);
	        lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
	        lblNewLabel_1_1_2.setBounds(703, 248, 301, 31);
	        contentPane.add(lblNewLabel_1_1_2);
	        
	        textField_7 = new JTextField();
	        textField_7.setColumns(10);
	        textField_7.setBounds(1049, 207, 295, 19);
	        contentPane.add(textField_7);
	        
	        JLabel lblNewLabel_1_1_1_2 = new JLabel("Nombre del Barrio,Sector o Cuidad");
	        lblNewLabel_1_1_1_2.setForeground(Color.WHITE);
	        lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
	        lblNewLabel_1_1_1_2.setBounds(703, 301, 301, 31);
	        contentPane.add(lblNewLabel_1_1_1_2);
	        
	        JLabel lblNewLabel_1_2_1 = new JLabel("NO.Interior ");
	        lblNewLabel_1_2_1.setForeground(Color.WHITE);
	        lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	        lblNewLabel_1_2_1.setBounds(703, 207, 301, 31);
	        contentPane.add(lblNewLabel_1_2_1);
	        
	        textField_8 = new JTextField();
	        textField_8.setColumns(10);
	        textField_8.setBounds(1049, 256, 295, 19);
	        contentPane.add(textField_8);
	        
	        textField_9 = new JTextField();
	        textField_9.setColumns(10);
	        textField_9.setBounds(1049, 309, 295, 19);
	        contentPane.add(textField_9);
	        
	        JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Codigo Postal");
	        lblNewLabel_1_1_1_1_2.setForeground(Color.WHITE);
	        lblNewLabel_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
	        lblNewLabel_1_1_1_1_2.setBounds(703, 355, 301, 31);
	        contentPane.add(lblNewLabel_1_1_1_1_2);
	        
	        textField_10 = new JTextField();
	        textField_10.setColumns(10);
	        textField_10.setBounds(1049, 363, 295, 19);
	        contentPane.add(textField_10);
	        
	        JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Nombre del Estado o Pais ");
	        lblNewLabel_1_1_1_1_1_1.setForeground(Color.WHITE);
	        lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	        lblNewLabel_1_1_1_1_1_1.setBounds(703, 401, 301, 31);
	        contentPane.add(lblNewLabel_1_1_1_1_1_1);
	        
	        textField_11 = new JTextField();
	        textField_11.setColumns(10);
	        textField_11.setBounds(1049, 409, 295, 19);
	        contentPane.add(textField_11);
	        
	        JLabel lblNewLabel_1_4 = new JLabel("LUGAR INICIAL DEL VIAJE");
	        lblNewLabel_1_4.setForeground(Color.WHITE);
	        lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
	        lblNewLabel_1_4.setBounds(52, 88, 301, 31);
	        contentPane.add(lblNewLabel_1_4);
	        
	        JLabel lblNewLabel_1_4_1 = new JLabel("DESTINO");
	        lblNewLabel_1_4_1.setForeground(Color.WHITE);
	        lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	        lblNewLabel_1_4_1.setBounds(964, 88, 93, 31);
	        contentPane.add(lblNewLabel_1_4_1);
	        
	        JLabel lblNewLabel_2 = new JLabel("");
	        lblNewLabel_2.setForeground(Color.WHITE);
	        lblNewLabel_2.setBounds(10, 0, 457, 29);
	        contentPane.add(lblNewLabel_2);
	}
}
