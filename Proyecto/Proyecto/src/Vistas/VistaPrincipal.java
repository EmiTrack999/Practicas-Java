package Vistas;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class VistaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCorreo;
	private JTextField txtContra;
	private JTextField txtConfir;
	JLabel lbCorreo, lbContraseña, lbConfirmarContraseña, lblNewLabel_2;
	private JButton btRegis, btIniciar;
	private ImageIcon originalImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				VistaPrincipal frame = new VistaPrincipal();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaPrincipal() {
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(true);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Opciones");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Ayuda");
		mntmNewMenuItem.addActionListener(e -> {
			String url = "https://ayudaacliente.netlify.app/";
			if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
				try {
					Desktop.getDesktop().browse(new URI(url));
				} catch (IOException | URISyntaxException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());

		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);

		// Cargar la imagen original
		originalImage = new ImageIcon("C:/Users/Alumno.SC3PC34.000/Desktop/PRACTICAS%202.0/Practicas-Java/Proyecto/Proyecto/Imagenes/Imagenes/fondo-diseno-presentacion-abstracto-azul-moderno_181182-27413.jpg");
		lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setBackground(new Color(0, 0, 0));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBounds(0, 0, 784, 600);
		layeredPane.add(lblNewLabel_2, Integer.valueOf(0));

		// Crear y añadir botones
		btRegis = createButton("Registrar");
		btIniciar = createButton("Iniciar");

		// Crear y añadir campos de texto y etiquetas
		txtCorreo = createTextField();
		txtContra = createTextField();
		txtConfir = createTextField();

		lbCorreo = createLabel("Correo/Telefono:");
		lbContraseña = createLabel("Contraseña:");
		lbConfirmarContraseña = createLabel("Confirmar Contraseña:");

		// Agregar los componentes al panel
		layeredPane.add(lbCorreo, Integer.valueOf(1));
		layeredPane.add(txtCorreo, Integer.valueOf(1));
		layeredPane.add(lbContraseña, Integer.valueOf(1));
		layeredPane.add(txtContra, Integer.valueOf(1));
		layeredPane.add(lbConfirmarContraseña, Integer.valueOf(1));
		layeredPane.add(txtConfir, Integer.valueOf(1));
		layeredPane.add(btRegis, Integer.valueOf(1));
		layeredPane.add(btIniciar, Integer.valueOf(1));

		// Listener para manejar el redimensionamiento de la ventana
		this.addComponentListener(new java.awt.event.ComponentAdapter() {
			public void componentResized(java.awt.event.ComponentEvent evt) {
				Dimension size = getSize();
				adjustComponents(size.width, size.height);
			}
		});
	}

	// Método para crear botones con ActionListener
	private JButton createButton(String text) {
		JButton button = new JButton(text);
		button.addActionListener(e -> {
			// Aquí puedes agregar la lógica específica para cada botón
		});
		return button;
	}

	// Método para crear campos de texto
	private JTextField createTextField() {
		JTextField textField = new JTextField();
		textField.setColumns(10);
		return textField;
	}

	// Método para crear etiquetas
	private JLabel createLabel(String text) {
		JLabel label = new JLabel(text);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		return label;
	}

	// Método para ajustar los componentes
	private void adjustComponents(int width, int height) {
		lblNewLabel_2.setBounds(0, 0, width, height); 
		resizeImage(width, height);

		int labelWidth = width / 4;
		int labelHeight = height / 15;
		int textFieldWidth = width / 3;
		int buttonWidth = width / 6;
		int buttonHeight = height / 15;
		int spacing = 15;

		// Posiciones de las etiquetas y campos de texto centrados
		int centerX = width / 2;
		int startY = height / 4;

		// Ajustar etiquetas un poco más a la izquierda
		lbCorreo.setBounds(centerX - labelWidth - 50, startY, labelWidth, labelHeight);
		txtCorreo.setBounds(centerX - textFieldWidth / 2, startY, textFieldWidth, labelHeight);

		lbContraseña.setBounds(centerX - labelWidth - 25, startY + labelHeight + spacing, labelWidth, labelHeight);
		txtContra.setBounds(centerX - textFieldWidth / 2, startY + labelHeight + spacing, textFieldWidth, labelHeight);

		lbConfirmarContraseña.setBounds(centerX - labelWidth - 90, startY + 2 * (labelHeight + spacing), labelWidth, labelHeight);
		txtConfir.setBounds(centerX - textFieldWidth / 2, startY + 2 * (labelHeight + spacing), textFieldWidth, labelHeight);

		// Posicionar botones centrados
		btRegis.setBounds(centerX - buttonWidth - spacing, startY + 3 * (labelHeight + spacing), buttonWidth, buttonHeight);
		btIniciar.setBounds(centerX + spacing, startY + 3 * (labelHeight + spacing), buttonWidth, buttonHeight);
	}

	// Método para redimensionar la imagen
	private void resizeImage(int width, int height) {
		Image img = originalImage.getImage();
		Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		lblNewLabel_2.setIcon(new ImageIcon(newImg));
		lblNewLabel_2.repaint();
	}
}
