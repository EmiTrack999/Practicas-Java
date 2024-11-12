package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.B_Datos;

import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Pedir_Pedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCodigo;
	private JTextField txtPedido;
	JComboBox cbTipo;
	JRadioButton rdCasa, rdEmp ;
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
		
		JLabel lblNewLabel_1 = new JLabel("Nombre Quien Recibe   :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(89, 102, 181, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Codigo de Seguridad (Tu lo otorgas)");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_2.setBounds(34, 151, 260, 39);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo de Carga    :");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_3.setBounds(139, 221, 121, 23);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Cual sera tu pedido   :");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_4.setBounds(112, 283, 158, 32);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Es casa o Empresa  :");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_5.setBounds(123, 351, 152, 23);
		contentPane.add(lblNewLabel_5);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(339, 111, 306, 20);
		contentPane.add(txtNombre);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(339, 162, 306, 20);
		contentPane.add(txtCodigo);
		
		txtPedido = new JTextField();
		txtPedido.setColumns(10);
		txtPedido.setBounds(339, 278, 306, 44);
		contentPane.add(txtPedido);
		
		rdCasa = new JRadioButton("Casa");
		rdCasa.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		rdCasa.setBounds(349, 350, 109, 23);
		contentPane.add(rdCasa);
		
		 rdEmp = new JRadioButton("Empresa");
		rdEmp.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		rdEmp.setBounds(554, 350, 109, 23);
		contentPane.add(rdEmp);
		
		JButton btnNewButton = new JButton("Iniciar");
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				camposVacios();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.setBounds(329, 407, 109, 14);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Bienvenido Iniciemos tu Pedido");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(234, 23, 342, 36);
		contentPane.add(lblNewLabel);
		
		cbTipo = new JComboBox();
		cbTipo.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"TIPO", "Pesada", "Ligera"}));
		cbTipo.setBounds(339, 222, 134, 22);
		contentPane.add(cbTipo);
	}
	
	public void camposVacios() {
		if(txtNombre.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "no dejar campos vacios");
		}else if(txtCodigo.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "no dejar campos vacios");
		}else if(txtPedido.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "no dejar campos vacios");
		} else {
			Verificacio_Costo veCo=new Verificacio_Costo();
			guardarPedido();
			JOptionPane.showMessageDialog(null, "Coticemos tu viaje");
			veCo.setVisible(true);
		}
	}	
	public void guardarPedido() {
		    	B_Datos bd=new B_Datos();
		    String nombre=txtNombre.getText();
		    int codigo=Integer.parseInt(txtCodigo.getText());
		    String tipo=cbTipo.getSelectedItem().toString();
		    String pedido=txtPedido.getText();
		    boolean casa=rdCasa.isSelected();
		    boolean empre=rdEmp.isSelected();
		    boolean resultado =bd.guardarPedido(nombre, codigo, tipo, pedido, empre);
		    if (resultado) {
		        JOptionPane.showMessageDialog(null, "Tus datos ya fueron guardados");
		    } else {
		        JOptionPane.showMessageDialog(null, "Hubo un error al guardar tus datos");	    }
	}
}
