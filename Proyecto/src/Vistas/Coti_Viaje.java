package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.B_Datos;
import Modelo.GoogleM;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Coti_Viaje extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;
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
	JRadioButton uno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Coti_Viaje frame = new Coti_Viaje();
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
	public Coti_Viaje() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Coti_Viaje.class.getResource("/Vistas/Logo de la empresa.jpeg")));
		setResizable(false);
		setTitle("Cargo Fleets Solutions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1389, 781);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Opciones");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Info. de Ecofrend");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url="https://ayudaalusuario.netlify.app/";
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
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Regresar al menu");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio in=new Inicio();
				in.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Ayuda");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
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
		mnNewMenu.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Coticemos tu Viaje");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(530, 10, 295, 54);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Deseas aportar  para el programa Ecofriend del 10% de tu costo    :");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_3.setBounds(281, 481, 427, 19);
		contentPane.add(lblNewLabel_3);
		
		uno = new JRadioButton("SI");
		uno.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		uno.setBackground(new Color(0, 0, 0));
		uno.setForeground(new Color(255, 255, 255));
		uno.setBounds(738, 480, 48, 23);
		contentPane.add(uno);
		
		JRadioButton dos = new JRadioButton("NO");
		dos.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		dos.setBackground(new Color(0, 0, 0));
		dos.setForeground(new Color(255, 255, 255));
		dos.setBounds(874, 480, 48, 23);
		contentPane.add(dos);
		
		JButton btnNewButton = new JButton("Cotizar");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setIcon(new ImageIcon(Coti_Viaje.class.getResource("/Vistas/img/grafico-de-cotizaciones.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarFinal();
				
        	}
		});
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(604, 609, 139, 36);
		contentPane.add(btnNewButton);
		 ButtonGroup group = new ButtonGroup();
	        group.add(uno);
	        group.add(dos);
	        
	        JLabel lblNewLabel_1 = new JLabel("Nombre de La Calle");
	        lblNewLabel_1.setForeground(Color.WHITE);
	        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
	        lblNewLabel_1.setBounds(52, 152, 301, 31);
	        contentPane.add(lblNewLabel_1);
	        
	        txt1 = new JTextField();
	        txt1.addKeyListener(new KeyAdapter() {
	        	@Override
	        	public void keyTyped(KeyEvent e) {if(txt1.getText().length()>50) {
	        			JOptionPane.showMessageDialog(null, "no poner mas de 50 digitos");
	        		}
	        	}
	        });
	        txt1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        	}
	        });
	        txt1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
	        txt1.setColumns(10);
	        txt1.setBounds(398, 160, 295, 19);
	        contentPane.add(txt1);
	        
	        JLabel lblNewLabel_1_1 = new JLabel("NO.Exterior");
	        lblNewLabel_1_1.setForeground(Color.WHITE);
	        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
	        lblNewLabel_1_1.setBounds(52, 248, 301, 31);
	        contentPane.add(lblNewLabel_1_1);
	        
	        txt2 = new JTextField();
	        txt2.addKeyListener(new KeyAdapter() {
	        	@Override
	        	public void keyTyped(KeyEvent e) {if(txt2.getText().length()>4) {
	        		e.consume();
	        			JOptionPane.showMessageDialog(null, "no poner mas de 4 digitos");
	        		}
	        	}
	        });
	        txt2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        	}
	        });
	        txt2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
	        txt2.setColumns(10);
	        txt2.setBounds(398, 207, 295, 19);
	        contentPane.add(txt2);
	        
	        JLabel lblNewLabel_1_1_1 = new JLabel("Nombre del Barrio,Sector o Cuidad");
	        lblNewLabel_1_1_1.setForeground(Color.WHITE);
	        lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
	        lblNewLabel_1_1_1.setBounds(52, 301, 301, 31);
	        contentPane.add(lblNewLabel_1_1_1);
	        
	        JLabel lblNewLabel_1_2 = new JLabel("NO.Interior ");
	        lblNewLabel_1_2.setForeground(Color.WHITE);
	        lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
	        lblNewLabel_1_2.setBounds(52, 207, 301, 31);
	        contentPane.add(lblNewLabel_1_2);
	        
	        txt3 = new JTextField();
	        txt3.addKeyListener(new KeyAdapter() {
	        	@Override
	        	public void keyTyped(KeyEvent e) {if(txt3.getText().length()>4){
	        		e.consume();
	        			JOptionPane.showMessageDialog(null, "no poner mas de 4 digitos");
	        		}
	        	}
	        });
	        txt3.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        	}
	        });
	        txt3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
	        txt3.setColumns(10);
	        txt3.setBounds(398, 256, 295, 19);
	        contentPane.add(txt3);
	        
	        txt4 = new JTextField();
	        txt4.addKeyListener(new KeyAdapter() {
	        	@Override
	        	public void keyTyped(KeyEvent e) {if(txt4.getText().length()>30) {
	        			JOptionPane.showMessageDialog(null, "no poner mas de 30 digitos");
	        		}
	        	}
	        });
	        txt4.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		
	        	}
	        });
	        txt4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
	        txt4.setColumns(10);
	        txt4.setBounds(398, 309, 295, 19);
	        contentPane.add(txt4);
	        
	        JLabel lblNewLabel_1_1_1_1 = new JLabel("Codigo Postal");
	        lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
	        lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
	        lblNewLabel_1_1_1_1.setBounds(52, 355, 301, 31);
	        contentPane.add(lblNewLabel_1_1_1_1);
	        
	        txt5 = new JTextField();
	        txt5.addKeyListener(new KeyAdapter() {
	        	@Override
	        	public void keyTyped(KeyEvent e) {if(txt5.getText().length()>5) {
	        		e.consume();
	        			JOptionPane.showMessageDialog(null, "no poner mas de 5 digitos");
	        		}
	        	}
	        });
	        txt5.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        	}
	        });
	        txt5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
	        txt5.setColumns(10);
	        txt5.setBounds(398, 363, 295, 19);
	        contentPane.add(txt5);
	        
	        JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Nombre del Estado o Pais ");
	        lblNewLabel_1_1_1_1_1.setForeground(Color.WHITE);
	        lblNewLabel_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
	        lblNewLabel_1_1_1_1_1.setBounds(52, 401, 301, 31);
	        contentPane.add(lblNewLabel_1_1_1_1_1);
	        
	        txt6 = new JTextField();
	        txt6.addKeyListener(new KeyAdapter() {
	        	@Override
	        	public void keyTyped(KeyEvent e) {if(txt6.getText().length()>40) {
	        			JOptionPane.showMessageDialog(null, "no poner mas de 40 digitos");
	        		}
	        	}
	        });
	        txt6.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        	}
	        });
	        txt6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
	        txt6.setColumns(10);
	        txt6.setBounds(398, 409, 295, 19);
	        contentPane.add(txt6);
	        
	        JLabel lblNewLabel_1_3 = new JLabel("Nombre de La Calle");
	        lblNewLabel_1_3.setForeground(Color.WHITE);
	        lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
	        lblNewLabel_1_3.setBounds(703, 152, 301, 31);
	        contentPane.add(lblNewLabel_1_3);
	        
	        txt7 = new JTextField();
	        txt7.addKeyListener(new KeyAdapter() {
	        	@Override
	        	public void keyTyped(KeyEvent e) {if(txt7.getText().length()>50) {
	        			JOptionPane.showMessageDialog(null, "no poner mas de 50 digitos");
	        		}
	        	}
	        });
	        txt7.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        	}
	        });
	        txt7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
	        txt7.setColumns(10);
	        txt7.setBounds(1049, 160, 295, 19);
	        contentPane.add(txt7);
	        
	        JLabel lblNewLabel_1_1_2 = new JLabel("NO.Exterior");
	        lblNewLabel_1_1_2.setForeground(Color.WHITE);
	        lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
	        lblNewLabel_1_1_2.setBounds(703, 248, 301, 31);
	        contentPane.add(lblNewLabel_1_1_2);
	        
	        txt8 = new JTextField();
	        txt8.addKeyListener(new KeyAdapter() {
	        	@Override
	        	public void keyTyped(KeyEvent e) {if(txt8.getText().length()>4) {
	        		e.consume();
	        			JOptionPane.showMessageDialog(null, "no poner mas de 4 digitos");
	        		}
	        	}
	        });
	        txt8.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        	}
	        });
	        txt8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
	        txt8.setColumns(10);
	        txt8.setBounds(1049, 207, 295, 19);
	        contentPane.add(txt8);
	        
	        JLabel lblNewLabel_1_1_1_2 = new JLabel("Nombre del Barrio,Sector o Cuidad");
	        lblNewLabel_1_1_1_2.setForeground(Color.WHITE);
	        lblNewLabel_1_1_1_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
	        lblNewLabel_1_1_1_2.setBounds(703, 301, 301, 31);
	        contentPane.add(lblNewLabel_1_1_1_2);
	        
	        JLabel lblNewLabel_1_2_1 = new JLabel("NO.Interior ");
	        lblNewLabel_1_2_1.setForeground(Color.WHITE);
	        lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
	        lblNewLabel_1_2_1.setBounds(703, 207, 301, 31);
	        contentPane.add(lblNewLabel_1_2_1);
	        
	        txt9 = new JTextField();
	        txt9.addKeyListener(new KeyAdapter() {
	        	@Override
	        	public void keyTyped(KeyEvent e) {if(txt9.getText().length()>4) {
	        		e.consume();
	        			JOptionPane.showMessageDialog(null, "no poner mas de 4 digitos");
	        		}
	        	}
	        });
	        txt9.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		
	        	}
	        });
	        txt9.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
	        txt9.setColumns(10);
	        txt9.setBounds(1049, 256, 295, 19);
	        contentPane.add(txt9);
	        
	        txt10 = new JTextField();
	        txt10.addKeyListener(new KeyAdapter() {
	        	@Override
	        	public void keyTyped(KeyEvent e) {if(txt10.getText().length()>30) {
	        			JOptionPane.showMessageDialog(null, "no poner mas de 30 digitos");
	        		}
	        	}
	        });
	        txt10.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        	}
	        });
	        txt10.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
	        txt10.setColumns(10);
	        txt10.setBounds(1049, 309, 295, 19);
	        contentPane.add(txt10);
	        
	        JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Codigo Postal");
	        lblNewLabel_1_1_1_1_2.setForeground(Color.WHITE);
	        lblNewLabel_1_1_1_1_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
	        lblNewLabel_1_1_1_1_2.setBounds(703, 355, 301, 31);
	        contentPane.add(lblNewLabel_1_1_1_1_2);
	        
	        txt11 = new JTextField();
	        txt11.addKeyListener(new KeyAdapter() {
	        	@Override
	        	public void keyTyped(KeyEvent e) {if(txt11.getText().length()>5) {
	        		e.consume();
	        			JOptionPane.showMessageDialog(null, "no poner mas de 5 digitos");
	        		}
	        	}
	        });
	        txt11.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        	}
	        });
	        txt11.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
	        txt11.setColumns(10);
	        txt11.setBounds(1049, 363, 295, 19);
	        contentPane.add(txt11);
	        
	        JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Nombre del Estado o Pais ");
	        lblNewLabel_1_1_1_1_1_1.setForeground(Color.WHITE);
	        lblNewLabel_1_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
	        lblNewLabel_1_1_1_1_1_1.setBounds(703, 401, 301, 31);
	        contentPane.add(lblNewLabel_1_1_1_1_1_1);
	        
	        txt12 = new JTextField();
	        txt12.addKeyListener(new KeyAdapter() {
	        	@Override
	        	public void keyTyped(KeyEvent e) {if(txt12.getText().length()>30) {
	        			JOptionPane.showMessageDialog(null, "no poner mas de 30 digitos");
	        		}
	        	}
	        });
	        txt12.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        	}
	        });
	        txt12.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
	        txt12.setColumns(10);
	        txt12.setBounds(1049, 409, 295, 19);
	        contentPane.add(txt12);
	        
	        JLabel lblNewLabel_1_4 = new JLabel("LUGAR INICIAL DEL VIAJE");
	        lblNewLabel_1_4.setForeground(Color.WHITE);
	        lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
	        lblNewLabel_1_4.setBounds(52, 88, 301, 31);
	        contentPane.add(lblNewLabel_1_4);
	        
	        JLabel lblNewLabel_1_4_1 = new JLabel("DESTINO");
	        lblNewLabel_1_4_1.setForeground(Color.WHITE);
	        lblNewLabel_1_4_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
	        lblNewLabel_1_4_1.setBounds(964, 88, 93, 31);
	        contentPane.add(lblNewLabel_1_4_1);
	        
	        JLabel lblNewLabel_2 = new JLabel("");
	        lblNewLabel_2.setForeground(Color.WHITE);
	        lblNewLabel_2.setBounds(10, 0, 457, 29);
	        contentPane.add(lblNewLabel_2);
	        
	        JLabel lblNewLabel_4 = new JLabel("");
	        lblNewLabel_4.setIcon(new ImageIcon(Coti_Viaje.class.getResource("/Vistas/img/viajar.png")));
	        lblNewLabel_4.setBounds(0, 237, 632, 484);
	        contentPane.add(lblNewLabel_4);
	}
	 public void guardar_Uinicial() {
	        try {
	            String nomCalle = txt1.getText();
	            int noInt = Integer.parseInt(txt2.getText());
	            int noExt = Integer.parseInt(txt3.getText()); 
	            String nomSect = txt4.getText();
	            int cp = Integer.parseInt(txt5.getText());    
	            String nomEstado = txt6.getText();
	            boolean ecofriend=uno.isSelected();
	            B_Datos bd = new B_Datos();
	            boolean conf =bd.coti_viaje(nomCalle, noInt, noExt, nomSect, cp, nomEstado, ecofriend);
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
	            B_Datos bd = new B_Datos();
	            boolean conf =bd.dest_viaje(nomCalle2, noInt2, noExt2, nomSect2, cp2, nomEstado2);
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
	    	coti();
	    	JOptionPane.showMessageDialog(null, "Tu viaje esta en camino");
	                Final_Pedido pf = new Final_Pedido();
	                pf.setVisible(true);
	                dispose();
	    }
	    public void coti() {
	    	String cllenom;
	    	
	    	String colonia;
	    	String cp;
	    	String estado;
	    	cllenom=txt1.getText();
	    	
	    	colonia=txt4.getText();
	    	cp=txt5.getText();
	    	estado=txt6.getText();
	    	
	    	String cllenom2;
	    	
	    	String colonia2;
	    	String cp2;
	    	String estado2;
	    	cllenom2=txt7.getText();
	    	
	    	colonia2=txt10.getText();
	    	cp2=txt11.getText();
	    	estado2=txt12.getText();
	    	boolean un=uno.isSelected();
	    	GoogleM gm=new GoogleM();
	    	gm.mostrarCostos(cllenom, colonia, estado, cp, cllenom2, colonia2, estado2, cp2, un);
	    	
	    	
	    }
}
