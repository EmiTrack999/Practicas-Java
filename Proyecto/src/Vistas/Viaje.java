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
		lblNewLabel.setBounds(230, 26, 313, 54);
		contentPane.add(lblNewLabel);

		txtNombre = new JTextField();
		txtNombre.setForeground(new Color(0, 0, 0));
		txtNombre.setColumns(10);
		txtNombre.setBackground(new Color(255, 255, 255));
		txtNombre.setBounds(293, 101, 290, 20);
		contentPane.add(txtNombre);

		JLabel lblNewLabel_1 = new JLabel("Nombre del Solicitante   :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(131, 104, 127, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Cuantas personas Viajaran   :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(107, 155, 153, 14);
		contentPane.add(lblNewLabel_2);

		cbPersonas = new JComboBox();
		cbPersonas.setModel(new DefaultComboBoxModel(new String[] { "Personas", "1", "2", "3", "4", "5", "6", "7", "8", "9", "mas de 9" }));
		cbPersonas.setBounds(293, 151, 99, 22);
		contentPane.add(cbPersonas);

		JLabel lblNewLabel_3 = new JLabel("Llevan Equipamiento    :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(131, 200, 129, 14);
		contentPane.add(lblNewLabel_3);

		rbEquipamiento = new JRadioButton("SI");
		rbEquipamiento.setBounds(293, 196, 64, 23);
		contentPane.add(rbEquipamiento);

		 rbEquipamiento2 = new JRadioButton("NO");
		rbEquipamiento2.setBounds(406, 196, 64, 23);
		contentPane.add(rbEquipamiento2);

		JLabel lblNewLabel_3_1 = new JLabel("Llevan Niños menores de 5 años    :");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setBounds(90, 248, 170, 14);
		contentPane.add(lblNewLabel_3_1);

		rbNiños = new JRadioButton("SI");
		rbNiños.setBounds(293, 244, 64, 23);
		contentPane.add(rbNiños);

		 rbNoNiños = new JRadioButton("NO");
		rbNoNiños.setBounds(406, 244, 64, 23);
		contentPane.add(rbNoNiños);

		JLabel lblNewLabel_4 = new JLabel("Fecha de Solicitud de Viaje   :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(118, 289, 142, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Numero al cual Comunicarse     :");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(96, 331, 164, 14);
		contentPane.add(lblNewLabel_5);

		txtNumero = new JTextField();
		txtNumero.setBounds(293, 328, 290, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);

		JButton btnNewButton = new JButton("Iniciar");
		btnNewButton.setIcon(new ImageIcon(Viaje.class.getResource("/Vistas/img/mapa-vial.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Validaciones antes de guardar
				if (txtNombre.getText().trim().isEmpty() || 
				    cbPersonas.getSelectedIndex() == 0 || 
				    txtNumero.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(contentPane,
						"Por favor, complete todos los campos obligatorios.",
						"Campos Vacíos",
						JOptionPane.WARNING_MESSAGE);
				} else {
					 guardarViaje();
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(340, 385, 120, 33);
		contentPane.add(btnNewButton);

		ButtonGroup group = new ButtonGroup();
		group.add(rbEquipamiento);
		group.add(rbEquipamiento2);

		ButtonGroup grupodos = new ButtonGroup();
		grupodos.add(rbNiños);
		grupodos.add(rbNoNiños);

		dateFecha = new JDateChooser();
		dateFecha.setBounds(287, 283, 164, 20);
		contentPane.add(dateFecha);
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
	    }	    boolean resultado = bd.viaje(nombre, personas, equip, niños, fecha, numero);
	    if (resultado) {
	        JOptionPane.showMessageDialog(null, "Tus datos ya fueron guardados.");
	        Coti_Viaje cv = new Coti_Viaje();
	        cv.setVisible(true);
	        dispose();
	    } else {
	        JOptionPane.showMessageDialog(null, "Hubo un error al guardar tus datos.");
	    }
	}
}
