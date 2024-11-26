package Vistas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.GoogleM;

import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Coti_Transporte extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txttra1;
    private JTextField txttra2;
    private ButtonGroup aportar;
    private JRadioButton dos ;
    private JRadioButton uno ;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Coti_Transporte frame = new Coti_Transporte();
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
    public Coti_Transporte() {
    	setTitle("Cargo Fleets Solutions");
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Coti_Transporte.class.getResource("/Vistas/Logo de la empresa.jpeg")));
    	setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 839, 779);
        
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
        contentPane.setBackground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Cotizemos Tu Transporte");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(277, 10, 322, 53);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Nombre de La Calle");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setBounds(57, 103, 301, 31);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1_2 = new JLabel("¿Deseas Aportar Para el Programa EcoFrend del 10% de Tu costo?");
        lblNewLabel_1_1_2.setForeground(Color.WHITE);
        lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1_2.setBounds(10, 518, 562, 31);
        contentPane.add(lblNewLabel_1_1_2);

        JLabel lblNewLabel_1_1_3 = new JLabel("EL viaje Sera Privado o Publico");
        lblNewLabel_1_1_3.setForeground(Color.WHITE);
        lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1_3.setBounds(44, 446, 269, 31);
        contentPane.add(lblNewLabel_1_1_3);

        txttra1 = new JTextField();
        txttra1.setBounds(403, 111, 295, 19);
        contentPane.add(txttra1);
        txttra1.setColumns(10);

        JButton botonc = new JButton("Cotizar Transporte");
        botonc.setIcon(new ImageIcon(Coti_Transporte.class.getResource("/Vistas/img/bolsa-de-valores.png")));
        botonc.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String ciudad1 = txttra1.getText().trim();
        		String ciudad2 = txttra2.getText().trim();
        		boolean aplicarIncremento = uno.isSelected();

        		if (ciudad1.isEmpty() || ciudad2.isEmpty()) {
        		    JOptionPane.showMessageDialog(null, "Por favor ingresa ubicaciones", "Error", JOptionPane.ERROR_MESSAGE);
        		    return;
        		} else {
        		    // Llamar al método para calcular distancia y mostrar información
        		    GoogleM.calcularDistanciaYMostrar(ciudad1, ciudad2, aplicarIncremento);

        		    // Mostrar la siguiente ventana
        		    Final_Pedido fp = new Final_Pedido();
        		    dispose();
        		    fp.setVisible(true);
        		}
        	}
        });
        botonc.setBackground(new Color(255, 0, 0));
        botonc.setForeground(new Color(255, 255, 255));
        botonc.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        botonc.setBounds(296, 604, 189, 38);
        contentPane.add(botonc);

      
        JRadioButton rbPriv = new JRadioButton("Privado");
        rbPriv.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
        rbPriv.setBounds(403, 452, 103, 21);
        contentPane.add(rbPriv);

        JRadioButton rbPubli = new JRadioButton("Publico");
        rbPubli.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
        rbPubli.setBounds(595, 452, 103, 21);
        contentPane.add(rbPubli);

       
        ButtonGroup group = new ButtonGroup();
        group.add(rbPriv);
        group.add(rbPubli);
        
        JLabel lblNewLabel_1_1 = new JLabel("NO.Exterior");
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1.setBounds(57, 199, 301, 31);
        contentPane.add(lblNewLabel_1_1);
        
        txttra2 = new JTextField();
        txttra2.setColumns(10);
        txttra2.setBounds(403, 158, 295, 19);
        contentPane.add(txttra2);
        
        uno = new JRadioButton("SI");
        uno.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        uno.setBounds(578, 523, 48, 23);
        contentPane.add(uno);
        
        dos = new JRadioButton("NO");
        dos.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        dos.setBounds(650, 523, 48, 23);
        contentPane.add(dos);
        
        
        ButtonGroup privado_public = new ButtonGroup();
        aportar = new ButtonGroup();
        privado_public.add(rbPubli);
        privado_public.add(rbPriv);
        aportar.add(uno);
        aportar.add(dos);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Nombre del Barrio,Sector o Cuidad");
        lblNewLabel_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1_1.setBounds(57, 252, 301, 31);
        contentPane.add(lblNewLabel_1_1_1);
        
        JLabel lblNewLabel_1_2 = new JLabel("NO.Interior ");
        lblNewLabel_1_2.setForeground(Color.WHITE);
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_2.setBounds(57, 158, 301, 31);
        contentPane.add(lblNewLabel_1_2);
        
        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(403, 207, 295, 19);
        contentPane.add(textField);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(403, 260, 295, 19);
        contentPane.add(textField_1);
        
        JLabel lblNewLabel_1_1_1_1 = new JLabel("Codigo Postal");
        lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1_1_1.setBounds(57, 306, 301, 31);
        contentPane.add(lblNewLabel_1_1_1_1);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(403, 314, 295, 19);
        contentPane.add(textField_2);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setBounds(10, 0, 269, 29);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Nombre del Estado o Pais ");
        lblNewLabel_1_1_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1_1_1_1.setBounds(57, 373, 301, 31);
        contentPane.add(lblNewLabel_1_1_1_1_1);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(403, 385, 295, 19);
        contentPane.add(textField_3);
    }
}
