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

public class Coti_Transporte extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txttra1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField txttra2;

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
    	setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 878, 587);
        
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
        contentPane.setBackground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Cotizemos Tu Transporte");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(277, 10, 322, 53);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Lugar A donde LLegara el Transporte");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setBounds(57, 103, 301, 31);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("¿Numero De Cargamento?");
        lblNewLabel_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1_1.setBounds(57, 204, 224, 31);
        contentPane.add(lblNewLabel_1_1_1);

        JLabel lblNewLabel_1_1_2 = new JLabel("¿Deseas Aportar Para el Programa EcoFrend del 10% de Tu costo?");
        lblNewLabel_1_1_2.setForeground(Color.WHITE);
        lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1_2.setBounds(10, 397, 499, 31);
        contentPane.add(lblNewLabel_1_1_2);

        JLabel lblNewLabel_1_1_3 = new JLabel("EL viaje Sera Privado o Publico");
        lblNewLabel_1_1_3.setForeground(Color.WHITE);
        lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1_3.setBounds(57, 323, 269, 31);
        contentPane.add(lblNewLabel_1_1_3);

        JLabel lblNewLabel_1_1_4 = new JLabel("¿Presupuesto Que Tiene A su Poder?");
        lblNewLabel_1_1_4.setForeground(Color.WHITE);
        lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1_4.setBounds(57, 246, 295, 31);
        contentPane.add(lblNewLabel_1_1_4);

        txttra1 = new JTextField();
        txttra1.setBounds(424, 111, 295, 19);
        contentPane.add(txttra1);
        txttra1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(424, 211, 295, 19);
        contentPane.add(textField_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(424, 254, 295, 19);
        contentPane.add(textField_3);

        JButton botonc = new JButton("Cotizar Transporte");
        botonc.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String ciudad1 = txttra1.getText().trim();  // Ciudad de salida
                String ciudad2 = txttra2.getText().trim();  // Ciudad de destino

                // Verificar que ambos campos tengan texto
                if (ciudad1.isEmpty() || ciudad2.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor ingresa ambas ciudades.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }else {
                	
                
                // Llamar al método calcularDistanciaYMostrar de la clase GoogleM
                GoogleM.calcularDistanciaYMostrar(ciudad1, ciudad2); 
                Final_Pedido fp=new Final_Pedido();
                dispose();
                fp.setVisible(true);
                } 
        	}
        });
        botonc.setBackground(new Color(255, 0, 0));
        botonc.setForeground(new Color(255, 255, 255));
        botonc.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        botonc.setBounds(328, 449, 199, 19);
        contentPane.add(botonc);

        // Crear los botones de radio
        JRadioButton rdbtnNewRadioButton = new JRadioButton("Privado");
        rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
        rdbtnNewRadioButton.setBounds(424, 330, 103, 21);
        contentPane.add(rdbtnNewRadioButton);

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Publico");
        rdbtnNewRadioButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
        rdbtnNewRadioButton_1.setBounds(559, 330, 103, 21);
        contentPane.add(rdbtnNewRadioButton_1);

        // Agrupar los botones de radio para que solo se pueda elegir uno
        ButtonGroup group = new ButtonGroup();
        group.add(rdbtnNewRadioButton);
        group.add(rdbtnNewRadioButton_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("Lugar de donde saldra  el Transporte");
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1_1.setBounds(57, 145, 301, 31);
        contentPane.add(lblNewLabel_1_1);
        
        txttra2 = new JTextField();
        txttra2.setColumns(10);
        txttra2.setBounds(424, 153, 295, 19);
        contentPane.add(txttra2);
        
        JRadioButton uno = new JRadioButton("SI");
        uno.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        uno.setBounds(545, 397, 48, 23);
        contentPane.add(uno);
        
        JRadioButton dos = new JRadioButton("NO");
        dos.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
        dos.setBounds(614, 397, 48, 23);
        contentPane.add(dos);
    }
}
