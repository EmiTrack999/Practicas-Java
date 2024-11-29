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
    private JTextField txt1;
    private JTextField txt2;
    private ButtonGroup aportar;
    private JRadioButton dos ;
    private JRadioButton uno ;
    private JTextField txt3;
    private JTextField txt4;
    private JTextField txt5;
    private JTextField txt6;
    private JTextField txt7;
    private JTextField txt8;
    private JTextField txt9;
    private JTextField txt10;
    private JTextField txt11;
    private JTextField txt12;
    private JRadioButton rbPriv;

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
        setBounds(100, 100, 1395, 779);
        
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
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(525, 11, 332, 53);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Nombre de La Calle");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setBounds(57, 103, 301, 31);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1_2 = new JLabel("¿Deseas Aportar Para el Programa Ecofriend del 10% de Tu costo?");
        lblNewLabel_1_1_2.setForeground(Color.WHITE);
        lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        lblNewLabel_1_1_2.setBounds(277, 513, 562, 31);
        contentPane.add(lblNewLabel_1_1_2);

        JLabel lblNewLabel_1_1_3 = new JLabel("EL viaje Sera Privado o Publico");
        lblNewLabel_1_1_3.setForeground(Color.WHITE);
        lblNewLabel_1_1_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        lblNewLabel_1_1_3.setBounds(330, 446, 269, 31);
        contentPane.add(lblNewLabel_1_1_3);

        txt1 = new JTextField();
        txt1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        txt1.setBounds(403, 111, 295, 19);
        contentPane.add(txt1);
        txt1.setColumns(10);

      
        rbPriv = new JRadioButton("Privado");
        rbPriv.setBackground(new Color(0, 0, 0));
        rbPriv.setForeground(new Color(255, 255, 255));
        rbPriv.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        rbPriv.setBounds(754, 452, 103, 21);
        contentPane.add(rbPriv);

        JRadioButton rbPubli = new JRadioButton("Publico");
        rbPubli.setBackground(new Color(0, 0, 0));
        rbPubli.setForeground(new Color(255, 255, 255));
        rbPubli.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        rbPubli.setBounds(926, 452, 103, 21);
        contentPane.add(rbPubli);

       
        ButtonGroup group = new ButtonGroup();
        group.add(rbPriv);
        group.add(rbPubli);
        
        JLabel lblNewLabel_1_1 = new JLabel("NO.Exterior");
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        lblNewLabel_1_1.setBounds(57, 199, 301, 31);
        contentPane.add(lblNewLabel_1_1);
        
        txt2 = new JTextField();
        txt2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        txt2.setColumns(10);
        txt2.setBounds(403, 158, 295, 19);
        contentPane.add(txt2);
        
        uno = new JRadioButton("SI");
        uno.setBackground(new Color(0, 0, 0));
        uno.setForeground(new Color(255, 255, 255));
        uno.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        uno.setBounds(825, 517, 48, 23);
        contentPane.add(uno);
        
        dos = new JRadioButton("NO");
        dos.setBackground(new Color(0, 0, 0));
        dos.setForeground(new Color(255, 255, 255));
        dos.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        dos.setBounds(970, 518, 59, 23);
        contentPane.add(dos);
        
        
        ButtonGroup privado_public = new ButtonGroup();
        aportar = new ButtonGroup();
        privado_public.add(rbPubli);
        privado_public.add(rbPriv);
        aportar.add(uno);
        aportar.add(dos);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Nombre del Barrio,Sector o Cuidad");
        lblNewLabel_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        lblNewLabel_1_1_1.setBounds(57, 252, 301, 31);
        contentPane.add(lblNewLabel_1_1_1);
        
        JLabel lblNewLabel_1_2 = new JLabel("NO.Interior ");
        lblNewLabel_1_2.setForeground(Color.WHITE);
        lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        lblNewLabel_1_2.setBounds(57, 158, 301, 31);
        contentPane.add(lblNewLabel_1_2);
        
        txt3 = new JTextField();
        txt3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        txt3.setColumns(10);
        txt3.setBounds(403, 207, 295, 19);
        contentPane.add(txt3);
        
        txt4 = new JTextField();
        txt4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        txt4.setColumns(10);
        txt4.setBounds(403, 260, 295, 19);
        contentPane.add(txt4);
        
        JLabel lblNewLabel_1_1_1_1 = new JLabel("Codigo Postal");
        lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        lblNewLabel_1_1_1_1.setBounds(57, 306, 301, 31);
        contentPane.add(lblNewLabel_1_1_1_1);
        
        txt5 = new JTextField();
        txt5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        txt5.setColumns(10);
        txt5.setBounds(403, 314, 295, 19);
        contentPane.add(txt5);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setBounds(10, 0, 269, 29);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Nombre del Estado o Pais ");
        lblNewLabel_1_1_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        lblNewLabel_1_1_1_1_1.setBounds(57, 373, 301, 31);
        contentPane.add(lblNewLabel_1_1_1_1_1);
        
        txt6 = new JTextField();
        txt6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        txt6.setColumns(10);
        txt6.setBounds(403, 385, 295, 19);
        contentPane.add(txt6);
        
        JLabel lblNewLabel_1_3 = new JLabel("Nombre de La Calle");
        lblNewLabel_1_3.setForeground(Color.WHITE);
        lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        lblNewLabel_1_3.setBounds(728, 103, 301, 31);
        contentPane.add(lblNewLabel_1_3);
        
        txt7 = new JTextField();
        txt7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        txt7.setColumns(10);
        txt7.setBounds(1074, 111, 295, 19);
        contentPane.add(txt7);
        
        JLabel lblNewLabel_1_1_4 = new JLabel("NO.Exterior");
        lblNewLabel_1_1_4.setForeground(Color.WHITE);
        lblNewLabel_1_1_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        lblNewLabel_1_1_4.setBounds(728, 199, 301, 31);
        contentPane.add(lblNewLabel_1_1_4);
        
        txt8 = new JTextField();
        txt8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        txt8.setColumns(10);
        txt8.setBounds(1074, 158, 295, 19);
        contentPane.add(txt8);
        
        JLabel lblNewLabel_1_1_1_2 = new JLabel("Nombre del Barrio,Sector o Cuidad");
        lblNewLabel_1_1_1_2.setForeground(Color.WHITE);
        lblNewLabel_1_1_1_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        lblNewLabel_1_1_1_2.setBounds(728, 252, 301, 31);
        contentPane.add(lblNewLabel_1_1_1_2);
        
        JLabel lblNewLabel_1_2_1 = new JLabel("NO.Interior ");
        lblNewLabel_1_2_1.setForeground(Color.WHITE);
        lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        lblNewLabel_1_2_1.setBounds(728, 158, 301, 31);
        contentPane.add(lblNewLabel_1_2_1);
        
        txt9 = new JTextField();
        txt9.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        txt9.setColumns(10);
        txt9.setBounds(1074, 207, 295, 19);
        contentPane.add(txt9);
        
        txt10 = new JTextField();
        txt10.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        txt10.setColumns(10);
        txt10.setBounds(1074, 260, 295, 19);
        contentPane.add(txt10);
        
        JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Codigo Postal");
        lblNewLabel_1_1_1_1_2.setForeground(Color.WHITE);
        lblNewLabel_1_1_1_1_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        lblNewLabel_1_1_1_1_2.setBounds(728, 306, 301, 31);
        contentPane.add(lblNewLabel_1_1_1_1_2);
        
        txt11 = new JTextField();
        txt11.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        txt11.setColumns(10);
        txt11.setBounds(1074, 314, 295, 19);
        contentPane.add(txt11);
        
        JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Nombre del Estado o Pais ");
        lblNewLabel_1_1_1_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        lblNewLabel_1_1_1_1_1_1.setBounds(728, 373, 301, 31);
        contentPane.add(lblNewLabel_1_1_1_1_1_1);
        
        txt12 = new JTextField();
        txt12.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        txt12.setColumns(10);
        txt12.setBounds(1074, 385, 295, 19);
        contentPane.add(txt12);
        
        JButton btnNewButton = new JButton("Cotizar Transporte");
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        btnNewButton.setIcon(new ImageIcon(Coti_Transporte.class.getResource("/Vistas/img/bolsa-de-valores.png")));
        btnNewButton.setBackground(new Color(255, 0, 0));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		guardarFinal();
        	}
        });
        btnNewButton.setBounds(623, 605, 172, 41);
        contentPane.add(btnNewButton);
    }
    
    public void guardar_Uinicial() {
        try {
            String nomCalle = txt1.getText();
            int noInt = Integer.parseInt(txt2.getText());
            int noExt = Integer.parseInt(txt3.getText()); 
            String nomSect = txt4.getText();
            int cp = Integer.parseInt(txt5.getText());    
            String nomEstado = txt6.getText();
            B_Datos bd = new B_Datos();
            boolean conf =bd.coti_trans(nomCalle, noInt, noExt, nomSect, cp, nomEstado);

            if (conf) {
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar los datos.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese solo valores numéricos en los campos de números.");
        } 
        }
    public void guardar_Ufinal() {
        try {
           
            String nomCalle2 = txt7.getText();
            int noInt2 = Integer.parseInt(txt8.getText());
            int noExt2 = Integer.parseInt(txt9.getText());
            String nomSect2 = txt10.getText();
            int cp2 = Integer.parseInt(txt11.getText());
            String nomEstado2 = txt12.getText();
            boolean isPriv = rbPriv.isSelected();
            boolean isEcoFrien = uno.isSelected(); 
            B_Datos bd = new B_Datos();
            boolean conf = bd.coti_Dtrans(nomCalle2, noInt2, noExt2, nomSect2, cp2, nomEstado2, isPriv, isEcoFrien);

           
            if (conf) {
               
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar los datos.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese solo valores numéricos en los campos de números.");
        }
    }
    public void guardarFinal() {
    	guardar_Uinicial();
    	guardar_Ufinal(); 
    	JOptionPane.showMessageDialog(null, "Tu transporte fue cotizado");
                Final_Pedido pf = new Final_Pedido();
                pf.setVisible(true);
                dispose();
    }

    }
