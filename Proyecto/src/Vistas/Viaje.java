package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
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
import java.awt.event.ActionEvent;

public class Viaje extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JTextField txtFecha;
	private JTextField txtNumero;

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
				Inicio in=new Inicio();
				in.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Ayuda");
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
		
		JComboBox cbPersonas = new JComboBox();
		cbPersonas.setModel(new DefaultComboBoxModel(new String[] {"Personas", "1", "2", "3", "4", "5", "6", "7", "8", "9", "mas de 9"}));
		cbPersonas.setBounds(293, 151, 99, 22);
		contentPane.add(cbPersonas);
		
		JLabel lblNewLabel_3 = new JLabel("Llevan Equipamiento    :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(131, 200, 129, 14);
		contentPane.add(lblNewLabel_3);
		
		JRadioButton rbEquipamiento = new JRadioButton("SI");
		rbEquipamiento.setBounds(293, 196, 64, 23);
		contentPane.add(rbEquipamiento);
		
		JRadioButton rbEquipamiento2 = new JRadioButton("NO");
		rbEquipamiento2.setBounds(406, 196, 64, 23);
		contentPane.add(rbEquipamiento2);
		
		JLabel lblNewLabel_3_1 = new JLabel("Llevan Niños menores de 5 años    :");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setBounds(90, 248, 170, 14);
		contentPane.add(lblNewLabel_3_1);
		
		JRadioButton rbNiños = new JRadioButton("SI");
		rbNiños.setBounds(293, 244, 64, 23);
		contentPane.add(rbNiños);
		
		JRadioButton rbNoNiños = new JRadioButton("NO");
		rbNoNiños.setBounds(406, 244, 64, 23);
		contentPane.add(rbNoNiños);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha de Solicitud de Viaje   :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(118, 289, 142, 14);
		contentPane.add(lblNewLabel_4);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(293, 286, 290, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 if (txtNombre.getText().trim().isEmpty() || 
				            cbPersonas.getSelectedIndex() == 0 ||
				            txtFecha.getText().trim().isEmpty() || 
				            txtNumero.getText().trim().isEmpty()) {
				            
				            JOptionPane.showMessageDialog(
				                contentPane,
				                "Por favor, complete todos los campos obligatorios.",
				                "Campos Vacíos",
				                JOptionPane.WARNING_MESSAGE
				            );
				        } else {
				            // Si todos los campos están llenos, procede a mostrar la siguiente ventana
				            Coti_Viaje cv = new Coti_Viaje();
				            dispose();
				            cv.setVisible(true);
				        }
			}
		});
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(340, 385, 106, 14);
		contentPane.add(btnNewButton);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rbEquipamiento);
		group.add(rbEquipamiento2);

		ButtonGroup grupodos = new ButtonGroup();
		grupodos.add(rbNiños);
		grupodos.add(rbNoNiños);
	
	}
	
} 