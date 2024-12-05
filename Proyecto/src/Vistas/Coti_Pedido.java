package Vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.B_Datos;
import Modelo.GoogleM;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Coti_Pedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;
	private JTextField txt6;
	JRadioButton uno;
	JRadioButton dos;
	private JTextField txt7;
	private JTextField txt8;
	private JTextField txt9;
	private JTextField txt10;
	private JTextField txt11;
	private JTextField txt12;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Coti_Pedido frame = new Coti_Pedido();
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
	public Coti_Pedido() {
		setTitle("Cargo Fleets Solitions");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Coti_Pedido.class.getResource("/Vistas/img/cargofleets2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1302, 732);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Opciones");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Regresar al menu");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaPrincipal vp=new VistaPrincipal();
				vp.setVisible(true);
				dispose();
				}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Ayuda");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
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
		mnNewMenu.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 138, 138));
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("Nombre de La Calle donde se Entregara");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_3.setBounds(10, 81, 301, 31);
		contentPane.add(lblNewLabel_1_3);
		
		txt1 = new JTextField();
		txt1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txt1.getText().length()>30) {
					JOptionPane.showMessageDialog(null, "no mas de 30 digitos");
					
				}
			}
		});
		txt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txt1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		txt1.setColumns(10);
		txt1.setBounds(283, 93, 295, 19);
		contentPane.add(txt1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("NO.Exterior");
		lblNewLabel_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_1_2.setBounds(10, 177, 301, 31);
		contentPane.add(lblNewLabel_1_1_2);
		
		txt2 = new JTextField();
		txt2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txt2.getText().length()>3) {
					JOptionPane.showMessageDialog(null, "no mas de 3 digitos");
				}
			}
		});
		txt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txt2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		txt2.setColumns(10);
		txt2.setBounds(283, 140, 295, 19);
		contentPane.add(txt2);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Nombre del Municipio,Sector o Cuidad");
		lblNewLabel_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_1_1_2.setBounds(10, 230, 301, 31);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("NO.Interior ");
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_2_1.setBounds(10, 136, 301, 31);
		contentPane.add(lblNewLabel_1_2_1);
		
		txt3 = new JTextField();
		txt3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txt3.getText().length()>1) {
					JOptionPane.showMessageDialog(null, "no mas de 1 digitos");

				}
			}
		});
		txt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txt3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		txt3.setColumns(10);
		txt3.setBounds(283, 189, 295, 19);
		contentPane.add(txt3);
		
		txt4 = new JTextField();
		txt4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {if(txt4.getText().length()>30) {
					JOptionPane.showMessageDialog(null, "no mas de 30 digitos");

				}
			}
		});
		txt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txt4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		txt4.setColumns(10);
		txt4.setBounds(283, 242, 295, 19);
		contentPane.add(txt4);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Codigo Postal");
		lblNewLabel_1_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_1_1_1_2.setBounds(10, 284, 301, 31);
		contentPane.add(lblNewLabel_1_1_1_1_2);
		
		txt5 = new JTextField();
		txt5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {if(txt5.getText().length()>4) {
					JOptionPane.showMessageDialog(null, "no mas de 4 digitos");

				}
			}
		});
		txt5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txt5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		txt5.setColumns(10);
		txt5.setBounds(283, 296, 295, 19);
		contentPane.add(txt5);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Nombre del Estado o Pais ");
		lblNewLabel_1_1_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_1_1_1_1_1.setBounds(10, 330, 301, 31);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
		
		txt6 = new JTextField();
		txt6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {if(txt6.getText().length()>30) {
					JOptionPane.showMessageDialog(null, "no mas de 30 digitos");
				}
			}
		});
		txt6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		txt6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		txt6.setColumns(10);
		txt6.setBounds(283, 342, 295, 19);
		contentPane.add(txt6);
		
		JLabel lblNewLabel = new JLabel("Coticemos tu pedido");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(518, 11, 257, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3_1 = new JLabel("Deseas aportar  para el programa ecofrend del 10% de tu costo    :");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_3_1.setBounds(173, 383, 477, 14);
		contentPane.add(lblNewLabel_3_1);
		
		uno = new JRadioButton("SI");
		uno.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		uno.setBackground(new Color(0, 0, 0));
		uno.setForeground(new Color(255, 255, 255));
		uno.setBounds(682, 379, 48, 23);
		contentPane.add(uno);
		
		dos = new JRadioButton("NO");
		dos.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		dos.setBackground(new Color(0, 0, 0));
		dos.setForeground(new Color(255, 255, 255));
		dos.setBounds(764, 379, 57, 23);
		contentPane.add(dos);
		
		JButton btnNewButton = new JButton("Cotizar");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coti();
		        if (txt1.getText().isEmpty() || txt2.getText().isEmpty() ||
		            txt3.getText().isEmpty() || txt4.getText().isEmpty() ||
		            txt5.getText().isEmpty() || txt6.getText().isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        try { 	
		            String noCalle = txt1.getText().trim();
		            int noInterior = Integer.parseInt(txt2.getText().trim());
		            int noExterior = Integer.parseInt(txt3.getText().trim());
		            String sector = txt4.getText().trim();
		            int codigoPostal = Integer.parseInt(txt5.getText().trim());
		            String estadoPais = txt6.getText().trim();
		            boolean ecoFriendly = uno.isSelected(); 
		            B_Datos bd = new B_Datos();
		            bd.coti_pedido(noCalle, noInterior, noExterior, sector, codigoPostal, estadoPais, ecoFriendly);
		              coti();
		              JOptionPane.showMessageDialog(null, "tu pedido fue cotizado"); 
		          
		            Final_Pedido fp=new Final_Pedido();
		            fp.setVisible(true);
		            dispose();
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Por favor, ingresa valores válidos en los campos numéricos.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Ocurrió un error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }
		       
		        
			}
			
		});
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setIcon(new ImageIcon(Coti_Pedido.class.getResource("/Vistas/img/bolsa-de-valores.png")));
		btnNewButton.setBounds(566, 524, 168, 45);
		contentPane.add(btnNewButton);
		ButtonGroup group = new ButtonGroup();
        group.add(uno);
        group.add(dos);
        
        JLabel lblNewLabel_1_3_1 = new JLabel("Nombre de La Calle");
        lblNewLabel_1_3_1.setForeground(Color.WHITE);
        lblNewLabel_1_3_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        lblNewLabel_1_3_1.setBounds(588, 72, 301, 31);
        contentPane.add(lblNewLabel_1_3_1);
        
        txt7 = new JTextField();
        txt7.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {if(txt7.getText().length()>30) {
					JOptionPane.showMessageDialog(null, "no mas de 30 digitos");

        		}
        	}
        });
        txt7.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        txt7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        txt7.setColumns(10);
        txt7.setBounds(934, 80, 295, 19);
        contentPane.add(txt7);
        
        JLabel lblNewLabel_1_1_4 = new JLabel("NO.Exterior");
        lblNewLabel_1_1_4.setForeground(Color.WHITE);
        lblNewLabel_1_1_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        lblNewLabel_1_1_4.setBounds(588, 168, 301, 31);
        contentPane.add(lblNewLabel_1_1_4);
        
        txt8 = new JTextField();
        txt8.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {if(txt8.getText().length()>3) {
					JOptionPane.showMessageDialog(null, "no mas de 3 digitos");

        		}
        	}
        });
        txt8.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        txt8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        txt8.setColumns(10);
        txt8.setBounds(934, 127, 295, 19);
        contentPane.add(txt8);
        
        JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Nombre del Municipio,Sector o Cuidad");
        lblNewLabel_1_1_1_2_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1_2_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        lblNewLabel_1_1_1_2_1.setBounds(588, 221, 301, 31);
        contentPane.add(lblNewLabel_1_1_1_2_1);
        
        JLabel lblNewLabel_1_2_1_1 = new JLabel("NO.Interior ");
        lblNewLabel_1_2_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_2_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        lblNewLabel_1_2_1_1.setBounds(588, 127, 301, 31);
        contentPane.add(lblNewLabel_1_2_1_1);
        
        txt9 = new JTextField();
        txt9.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {if(txt9.getText().length()>1) {
					JOptionPane.showMessageDialog(null, "no mas de 1 digitos");

        		}
        	}
        });
        txt9.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        txt9.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        txt9.setColumns(10);
        txt9.setBounds(934, 176, 295, 19);
        contentPane.add(txt9);
        
        txt10 = new JTextField();
        txt10.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {if(txt10.getText().length()>30) {
					JOptionPane.showMessageDialog(null, "no mas de 30 digitos");

        		}
        	}
        });
        txt10.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        txt10.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        txt10.setColumns(10);
        txt10.setBounds(934, 229, 295, 19);
        contentPane.add(txt10);
        
        JLabel lblNewLabel_1_1_1_1_2_1 = new JLabel("Codigo Postal");
        lblNewLabel_1_1_1_1_2_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1_1_2_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        lblNewLabel_1_1_1_1_2_1.setBounds(588, 275, 301, 31);
        contentPane.add(lblNewLabel_1_1_1_1_2_1);
        
        txt11 = new JTextField();
        txt11.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {if(txt11.getText().length()>4) {
					JOptionPane.showMessageDialog(null, "no mas de 4 digitos");

        		}
        	}
        });
        txt11.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        txt11.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        txt11.setColumns(10);
        txt11.setBounds(934, 283, 295, 19);
        contentPane.add(txt11);
        
        JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Nombre del Estado o Pais ");
        lblNewLabel_1_1_1_1_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        lblNewLabel_1_1_1_1_1_1_1.setBounds(588, 342, 301, 31);
        contentPane.add(lblNewLabel_1_1_1_1_1_1_1);
        
        txt12 = new JTextField();
        txt12.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {if(txt12.getText().length()>30) {
					JOptionPane.showMessageDialog(null, "no mas de 30 digitos");

        		}
        	}
        });
        txt12.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        txt12.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        txt12.setColumns(10);
        txt12.setBounds(934, 354, 295, 19);
        contentPane.add(txt12);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1.setIcon(new ImageIcon(Coti_Pedido.class.getResource("/Vistas/img/grafico-de-barras.png")));
        lblNewLabel_1.setBounds(165, 218, 391, 599);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(Coti_Pedido.class.getResource("/Vistas/img/portapapeles.png")));
        lblNewLabel_2.setBounds(1018, 0, 330, 381);
        contentPane.add(lblNewLabel_2);
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
    	gm.mostrarCostos(cllenom, colonia, estado, cp, colonia2, colonia2, estado2, cp2, un);
    	
    	
    	
    	
    }
	}
	
	
	

