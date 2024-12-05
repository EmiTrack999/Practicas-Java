package Vistas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controlador.B_Datos;
import java.awt.Color;
import java.awt.Desktop;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Viaje extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JTextField txtNumero;
	JComboBox cbPersonas;
	JRadioButton rbEquipamiento, rbNiños,rbEquipamiento2, rbNoNiños ;
	JDateChooser dateFecha;
	private JLabel lblNewLabel_6;
	private JTextField txtApellido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Viaje frame = new Viaje();
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
	public Viaje() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Viaje.class.getResource("/Vistas/Logo de la empresa.jpeg")));
		setResizable(false);
		setTitle("Cargo Fleets Solutions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 512);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnNewMenu = new JMenu("Opciones");
		menuBar.add(mnNewMenu);

		mntmNewMenuItem = new JMenuItem("Regresar al menu");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio in = new Inicio();
				in.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		mntmNewMenuItem_1 = new JMenuItem("Ayuda");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "https://ayudaacliente.netlify.app/";
				if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
					try {
						Desktop.getDesktop().browse(new URI(url));
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("COMENSEMOS SU VIAJE");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(250, 11, 313, 54);
		contentPane.add(lblNewLabel);

		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {if(txtNombre.getText().length()>30) {
					JOptionPane.showMessageDialog(null, "no poner mas de 30 digitos");
				}
			}
		});
		txtNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txtNombre.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		txtNombre.setForeground(new Color(0, 0, 0));
		txtNombre.setColumns(10);
		txtNombre.setBackground(new Color(255, 255, 255));
		txtNombre.setBounds(212, 101, 164, 20);
		contentPane.add(txtNombre);

		JLabel lblNewLabel_1 = new JLabel("Nombre    :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(115, 104, 87, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Cuantas personas Viajaran   :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(155, 155, 189, 14);
		contentPane.add(lblNewLabel_2);

		cbPersonas = new JComboBox();
		cbPersonas.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		cbPersonas.setModel(new DefaultComboBoxModel(new String[] { "Personas", "1", "2", "3", "4", "5", "6", "7", "8", "9", "mas de 9" }));
		cbPersonas.setBounds(377, 151, 99, 22);
		contentPane.add(cbPersonas);

		JLabel lblNewLabel_3 = new JLabel("Llevan Equipamiento    :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(180, 200, 164, 14);
		contentPane.add(lblNewLabel_3);

		rbEquipamiento = new JRadioButton("SI");
		rbEquipamiento.setBackground(new Color(0, 0, 0));
		rbEquipamiento.setForeground(new Color(255, 255, 255));
		rbEquipamiento.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		rbEquipamiento.setBounds(377, 196, 64, 23);
		contentPane.add(rbEquipamiento);

		 rbEquipamiento2 = new JRadioButton("NO");
		 rbEquipamiento2.setBackground(new Color(0, 0, 0));
		 rbEquipamiento2.setForeground(new Color(255, 255, 255));
		 rbEquipamiento2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		rbEquipamiento2.setBounds(490, 196, 64, 23);
		contentPane.add(rbEquipamiento2);

		JLabel lblNewLabel_3_1 = new JLabel("Llevan Niños menores de 5 años    :");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setBounds(110, 248, 234, 14);
		contentPane.add(lblNewLabel_3_1);

		rbNiños = new JRadioButton("SI");
		rbNiños.setBackground(new Color(0, 0, 0));
		rbNiños.setForeground(new Color(255, 255, 255));
		rbNiños.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		rbNiños.setBounds(377, 244, 64, 23);
		contentPane.add(rbNiños);

		 rbNoNiños = new JRadioButton("NO");
		 rbNoNiños.setBackground(new Color(0, 0, 0));
		 rbNoNiños.setForeground(new Color(255, 255, 255));
		 rbNoNiños.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		rbNoNiños.setBounds(490, 244, 64, 23);
		contentPane.add(rbNoNiños);

		JLabel lblNewLabel_4 = new JLabel("Fecha de Solicitud de Viaje   :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(155, 289, 189, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Numero al cual Comunicarse     :");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(127, 331, 217, 14);
		contentPane.add(lblNewLabel_5);

		txtNumero = new JTextField();
		txtNumero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {if(txtNumero.getText().length()>11) {
					JOptionPane.showMessageDialog(null, "pon un numero de 10 digitos");
				}
			}
		});
		txtNumero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txtNumero.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		txtNumero.setBounds(377, 328, 290, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);

		JButton btnNewButton = new JButton("Iniciar");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setIcon(new ImageIcon(Viaje.class.getResource("/Vistas/img/mapa-vial.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarViaje();
				Coti_Viaje cv=new Coti_Viaje();
				cv.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(308, 381, 120, 33);
		contentPane.add(btnNewButton);

		ButtonGroup group = new ButtonGroup();
		group.add(rbEquipamiento);
		group.add(rbEquipamiento2);

		ButtonGroup grupodos = new ButtonGroup();
		grupodos.add(rbNiños);
		grupodos.add(rbNoNiños);

		dateFecha = new JDateChooser();
		dateFecha.setForeground(new Color(255, 0, 0));
		dateFecha.setBackground(new Color(255, 255, 255));
		dateFecha.setBounds(371, 283, 164, 20);
		contentPane.add(dateFecha);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(10, 0, 269, 29);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Apellidos    :");
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBounds(414, 105, 76, 14);
		contentPane.add(lblNewLabel_7);
		
		txtApellido = new JTextField();
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {if(txtApellido.getText().length()>40) {
				JOptionPane.showMessageDialog(null, "no mas de 40 digitos");
			}
			}
		});
		txtApellido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		txtApellido.setForeground(Color.BLACK);
		txtApellido.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		txtApellido.setColumns(10);
		txtApellido.setBackground(Color.WHITE);
		txtApellido.setBounds(490, 102, 234, 20);
		contentPane.add(txtApellido);
	}

	public void guardarViaje() {
	    B_Datos bd = new B_Datos(); 
	    String nombre = txtNombre.getText().trim();
	    String personas = cbPersonas.getSelectedItem().toString();
	    boolean equip = rbEquipamiento.isSelected();
	    boolean niños = rbNiños.isSelected();
	    Date fecha = dateFecha.getDate();
	    String numero = txtNumero.getText().trim();
	    if (fecha == null) {
	        JOptionPane.showMessageDialog(null, "Por favor, selecciona una fecha.");
	        return;
	    }

	    if (fecha.before(new Date())) {
	        JOptionPane.showMessageDialog(null, "La fecha ya pasó.");
	        return;
	    }

	    if (nombre.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "El nombre es obligatorio.");
	        return;
	    }

	    if (numero.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "El número es obligatorio.");
	        return;
	    }

	    if (personas == null || personas.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Selecciona el número de personas.");
	        return;
	    }
	    if (!rbEquipamiento.isSelected() && !rbEquipamiento2.isSelected()) {
	        JOptionPane.showMessageDialog(null, "Por favor, selecciona si llevan equipamiento.");
	        return;
	    }

	    if (!rbNiños.isSelected() && !rbNoNiños.isSelected()) {
	        JOptionPane.showMessageDialog(null, "Por favor, selecciona si llevan niños.");
	        return;
	    }	   
	    bd.guarda_viaje(nombre, numero, personas, equip, niños, fecha, numero);
	}
}
