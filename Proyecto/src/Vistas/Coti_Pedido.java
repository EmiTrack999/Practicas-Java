package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.B_Datos;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;

public class Coti_Pedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	JRadioButton uno;
	JRadioButton dos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Coti_Pedido frame = new Coti_Pedido();
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
	public Coti_Pedido() {
		setTitle("Cargo Fleets Solitions");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Coti_Pedido.class.getResource("/Vistas/img/cargofleets2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1111, 716);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Opciones");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Ubicaciones disponibles");
		mntmNewMenuItem.addActionListener(new ActionListener() {
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
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Regresar al menu");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaPrincipal vp=new VistaPrincipal();
				vp.setVisible(true);
				dispose();
				}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Ayuda");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
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
		mnNewMenu.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("Nombre de La Calle donde se Entregara");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_3.setBounds(191, 115, 301, 31);
		contentPane.add(lblNewLabel_1_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		textField.setColumns(10);
		textField.setBounds(537, 123, 295, 19);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("NO.Exterior");
		lblNewLabel_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_1_2.setBounds(191, 211, 301, 31);
		contentPane.add(lblNewLabel_1_1_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(537, 170, 295, 19);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Nombre del Barrio,Sector o Cuidad");
		lblNewLabel_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_1_1_2.setBounds(191, 264, 301, 31);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("NO.Interior ");
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_2_1.setBounds(191, 170, 301, 31);
		contentPane.add(lblNewLabel_1_2_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(537, 219, 295, 19);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(537, 272, 295, 19);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Codigo Postal");
		lblNewLabel_1_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_1_1_1_2.setBounds(191, 318, 301, 31);
		contentPane.add(lblNewLabel_1_1_1_1_2);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(537, 326, 295, 19);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Nombre del Estado o Pais ");
		lblNewLabel_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_1_1_1_1_1.setBounds(191, 364, 301, 31);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		textField_5.setColumns(10);
		textField_5.setBounds(537, 372, 295, 19);
		contentPane.add(textField_5);
		
		JLabel lblNewLabel = new JLabel("Coticemos tu pedido");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(397, 10, 257, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3_1 = new JLabel("Deseas aportar  para el programa ecofrend del 10% de tu costo    :");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_3_1.setBounds(181, 437, 477, 14);
		contentPane.add(lblNewLabel_3_1);
		
		uno = new JRadioButton("SI");
		uno.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		uno.setBackground(new Color(0, 0, 0));
		uno.setForeground(new Color(255, 255, 255));
		uno.setBounds(686, 434, 48, 23);
		contentPane.add(uno);
		
		dos = new JRadioButton("NO");
		dos.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		dos.setBackground(new Color(0, 0, 0));
		dos.setForeground(new Color(255, 255, 255));
		dos.setBounds(756, 434, 57, 23);
		contentPane.add(dos);
		
		JButton btnNewButton = new JButton("Cotizar");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        if (textField.getText().isEmpty() || textField_1.getText().isEmpty() ||
		            textField_2.getText().isEmpty() || textField_3.getText().isEmpty() ||
		            textField_4.getText().isEmpty() || textField_5.getText().isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        try { 	
		            String noCalle = textField.getText().trim();
		            int noInterior = Integer.parseInt(textField_1.getText().trim());
		            int noExterior = Integer.parseInt(textField_2.getText().trim());
		            String sector = textField_3.getText().trim();
		            int codigoPostal = Integer.parseInt(textField_4.getText().trim());
		            String estadoPais = textField_5.getText().trim();
		            boolean ecoFriendly = uno.isSelected(); 
		            B_Datos bd = new B_Datos();
		            bd.coti_pedido(noCalle, noInterior, noExterior, sector, codigoPostal, estadoPais, ecoFriendly);
		            JOptionPane.showMessageDialog(null, "tu pedido fue cotizado");
		            Final_Pedido fp=new Final_Pedido();
		            fp.setVisible(true);
		            dispose();
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Por favor, ingresa valores válidos en los campos numéricos.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Ocurrió un error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }
		        
			}
			
		});
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setIcon(new ImageIcon(Coti_Pedido.class.getResource("/Vistas/img/bolsa-de-valores.png")));
		btnNewButton.setBounds(469, 516, 168, 45);
		contentPane.add(btnNewButton);
		ButtonGroup group = new ButtonGroup();
        group.add(uno);
        group.add(dos);
	}
	}
	
	
	

