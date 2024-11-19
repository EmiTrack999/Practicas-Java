package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

public class Final_Pedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Final_Pedido frame = new Final_Pedido();
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
	public Final_Pedido() {
		setResizable(false);
		setTitle("Cargo Fleets Solutions");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Final_Pedido.class.getResource("/Vistas/Logo de la empresa.jpeg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 844, 553);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Opciones");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cancelar Viaje");
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gracias Por tu Eleccion.");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(259, 11, 267, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tu Solicitud esta en Camino....");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(259, 90, 255, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Decesas realizar otra accion   :");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_2.setBounds(113, 199, 218, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("SI");
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio in=new Inicio();
				dispose();
				in.setVisible(true);	}
		});
		btnNewButton.setBounds(341, 196, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNo = new JButton("     ");
		btnNo.setBackground(new Color(255, 0, 0));
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaUno vu=new VistaUno();
				dispose();
				vu.setVisible(true);
			}
		});
		btnNo.setBounds(500, 196, 89, 23);
		contentPane.add(btnNo);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Final_Pedido.class.getResource("/Vistas/WhatsApp Image 2024-11-18 at 8.30.38 PM.jpeg")));
		lblNewLabel_3.setBounds(221, 230, 359, 251);
		contentPane.add(lblNewLabel_3);
	}
}
