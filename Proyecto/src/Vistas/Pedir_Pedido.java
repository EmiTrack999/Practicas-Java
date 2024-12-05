package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.B_Datos;
import Modelo.GoogleM;

import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class Pedir_Pedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtPedido;
	private JComboBox cbTipo;
	JRadioButton rdCasa, rdEmp ;
	private JPasswordField txtCodigo;
	private JTextField txtApellido;
	private boolean mostrarContraseña = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pedir_Pedido frame = new Pedir_Pedido();
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
	public Pedir_Pedido() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Pedir_Pedido.class.getResource("/Vistas/Logo de la empresa.jpeg")));
		setTitle("Cargo Fleets Solutions");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 522);
		
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
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Ubicaciones Disponibles");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
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
		mnNewMenu.add(mntmNewMenuItem_2);
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
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre   :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(90, 70, 84, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Codigo de Seguridad (Tu lo otorgas)");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setBounds(42, 135, 260, 39);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo de Carga    :");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_3.setBounds(160, 195, 121, 23);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Cual sera tu pedido   :");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_4.setBounds(127, 250, 158, 32);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Es casa o Empresa  :");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_5.setBounds(149, 335, 152, 23);
		contentPane.add(lblNewLabel_5);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtNombre.getText().length()>30) {
					e.consume();
					JOptionPane.showMessageDialog(null, "no mas de 30 digitos");

				}
			}
		});
		txtNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txtNombre.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		txtNombre.setColumns(10);
		txtNombre.setBounds(171, 79, 139, 20);
		contentPane.add(txtNombre);
		
		txtPedido = new JTextField();
		txtPedido.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		txtPedido.setColumns(10);
		txtPedido.setBounds(353, 246, 358, 44);
		contentPane.add(txtPedido);
		
		rdCasa = new JRadioButton("Casa");
		rdCasa.setBackground(new Color(0, 0, 0));
		rdCasa.setForeground(new Color(255, 255, 255));
		rdCasa.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		rdCasa.setBounds(369, 339, 109, 23);
		contentPane.add(rdCasa);
		
		 rdEmp = new JRadioButton("Empresa");
		 rdEmp.setBackground(new Color(0, 0, 0));
		 rdEmp.setForeground(new Color(255, 255, 255));
		rdEmp.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		rdEmp.setBounds(514, 339, 109, 23);
		contentPane.add(rdEmp);
		
		JButton btnNewButton =  new JButton("Iniciar");
		btnNewButton.setIcon(new ImageIcon(Pedir_Pedido.class.getResource("/Vistas/img/realizar-pedidos.png")));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarPedido();
			}
        	
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBounds(352, 407, 109, 32);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Bienvenido Iniciemos tu Pedido");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(234, 23, 342, 36);
		contentPane.add(lblNewLabel);
		
		cbTipo = new JComboBox();
		cbTipo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"TIPO", "Pesada", "Ligera"}));
		cbTipo.setBounds(349, 196, 134, 22);
		contentPane.add(cbTipo);
		
		txtCodigo = new JPasswordField();
		txtCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtCodigo.getText().length()>6) {
					e.consume();
					JOptionPane.showMessageDialog(null, "no mas de 6 digitos");
				}
			}
		});
		txtCodigo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		txtCodigo.setBounds(346, 145, 152, 20);
		contentPane.add(txtCodigo);
		
		JLabel lblNewLabel_6 = new JLabel("Apellidos  :");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_6.setBounds(353, 82, 88, 14);
		contentPane.add(lblNewLabel_6);
		
		txtApellido = new JTextField();
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
	if(txtApellido.getText().length()>30) {
					
					JOptionPane.showMessageDialog(null, "no mas de 30 digitos");

				}
			}
		});
		txtApellido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtApellido.getText().length()>30) {
					
					JOptionPane.showMessageDialog(null, "no mas de 30 digitos");

				}
			}
		});
		txtApellido.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		txtApellido.setBounds(451, 82, 260, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Mostrar Codigo de Seguridad");
		chckbxNewCheckBox.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		chckbxNewCheckBox.setIcon(new ImageIcon(Pedir_Pedido.class.getResource("/Vistas/img/candado.png")));
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  if (mostrarContraseña) {
	                    txtCodigo.setEchoChar('x');
	                    mostrarContraseña = false;
	                } else {
	                    txtCodigo.setEchoChar((char) 0);
	                    mostrarContraseña = true;
	                }
				 
			}
		});
		chckbxNewCheckBox.setForeground(new Color(255, 255, 255));
		chckbxNewCheckBox.setBackground(new Color(0, 0, 0));
		chckbxNewCheckBox.setBounds(551, 144, 227, 23);
		contentPane.add(chckbxNewCheckBox);
		ButtonGroup group = new ButtonGroup();
	        group.add(rdCasa);
	        group.add(rdEmp);
	        
	        JLabel lblNewLabel_7 = new JLabel("New label");
	        lblNewLabel_7.setIcon(new ImageIcon(Pedir_Pedido.class.getResource("/Vistas/img/pedido-en-linea.png")));
	        lblNewLabel_7.setBounds(20, 23, 72, 76);
	        contentPane.add(lblNewLabel_7);
	        
	        JLabel lblNewLabel_8 = new JLabel("");
	        lblNewLabel_8.setIcon(new ImageIcon(Pedir_Pedido.class.getResource("/Vistas/img/pedido-en-linea (1).png")));
	        lblNewLabel_8.setBounds(690, 321, 88, 92);
	        contentPane.add(lblNewLabel_8);
	        
	        JLabel lblNewLabel_9 = new JLabel("");
	        lblNewLabel_9.setIcon(new ImageIcon(Pedir_Pedido.class.getResource("/Vistas/img/Pedido Grande.png")));
	        lblNewLabel_9.setBounds(20, 260, 199, 193);
	        contentPane.add(lblNewLabel_9);
	}
	

	public void guardarPedido() {
		    	B_Datos bd=new B_Datos();
		    	 String nombre = txtNombre.getText().trim();
		    	    String apellidos = txtApellido.getText().trim();
		    	    String codigoSeguridad = new String(txtCodigo.getPassword()).trim();
		    	    String tipoCarga = cbTipo.getSelectedItem() != null ? cbTipo.getSelectedItem().toString() : "";
		    	    String pedido = txtPedido.getText().trim();
		    	    boolean ubicacion = rdCasa.isSelected();

	    if (txtNombre.getText().trim().isEmpty()) {
	        JOptionPane.showMessageDialog(this, "El campo 'Nombre' no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
	        txtNombre.requestFocus();
	        }
	       
	        if(txtApellido.getText().isEmpty()) {
	        	JOptionPane.showMessageDialog(this, "El campo 'Apellidos' no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
	    	txtApellido.requestFocus();
	    
	     }
	   
	    if (new String(txtCodigo.getPassword()).trim().isEmpty()) {
	        JOptionPane.showMessageDialog(this, "El campo 'Código de Seguridad' no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
	        txtCodigo.requestFocus();
	        
	    }
	    if (cbTipo.getSelectedIndex() == 0) { 
	        JOptionPane.showMessageDialog(this, "Debes seleccionar un tipo de carga.", "Error", JOptionPane.ERROR_MESSAGE);
	        cbTipo.requestFocus();
	       
	    }
	    if (txtPedido.getText().trim().isEmpty()) {
	        JOptionPane.showMessageDialog(this, "El campo 'Pedido' no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
	        txtPedido.requestFocus();
	       
	    }
	    if (!rdCasa.isSelected() && !rdEmp.isSelected()) {
	        JOptionPane.showMessageDialog(this, "Debes seleccionar si es 'Casa' o 'Empresa'.", "Error", JOptionPane.ERROR_MESSAGE);
	     
	    }
	  bd.guarda_ped(nombre, apellidos, codigoSeguridad, tipoCarga, pedido, ubicacion);
      JOptionPane.showMessageDialog(null, "tus datos fueron guardados");

	  Coti_Pedido cp=new Coti_Pedido();
		cp.setVisible(true);
		dispose();
	    
	}
	
}
