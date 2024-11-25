package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class VistaUno extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JLabel lblUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaUno frame = new VistaUno();
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
	public VistaUno() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaUno.class.getResource("/Vistas/Logo de la empresa.jpeg")));
		setTitle("Cargo Fleets Solutions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 564);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Opciones");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Cerrar Sesiòn");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaPrincipal vp=new VistaPrincipal();
				vp.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Ayuda");
		mntmNewMenuItem.addActionListener(new ActionListener() {
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
		mnNewMenu.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido a CargoFleets");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setBounds(177, 11, 449, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Esperamos Poder Ayudarte");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(267, 100, 234, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Comencemos");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_2.setBounds(331, 159, 105, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Comenzar");
		btnNewButton.setIcon(new ImageIcon(VistaUno.class.getResource("/Vistas/img/rapido.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio in=new Inicio();
				in.setVisible(true);
				dispose();
			
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(60, 183, 180));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.setBounds(310, 194, 138, 33);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(VistaUno.class.getResource("/Vistas/WhatsApp Image 2024-11-18 at 8.30.38 PM.jpeg")));
		lblNewLabel_3.setBounds(215, 240, 359, 252);
		contentPane.add(lblNewLabel_3);
		
		lblUsuario = new JLabel("");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setBounds(658, 21, 137, 14);
		contentPane.add(lblUsuario);
	}
}
