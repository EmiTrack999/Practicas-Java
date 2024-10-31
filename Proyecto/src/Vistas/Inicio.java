package Vistas;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Desktop;

public class Inicio extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblNewLabel_2;
    private ImageIcon originalImage; 
    private JLabel lblNewLabel; 

    /*******************************************
     * Launch the application.
     *******************************************/
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Inicio frame = new Inicio();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public Inicio() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 389, 368);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setMargin(new Insets(10, 10, 0, 0));
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

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Cerrar sesión");
        mnNewMenu.add(mntmNewMenuItem_1);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        JDesktopPane desktopPane = new JDesktopPane();
        contentPane.add(desktopPane, BorderLayout.CENTER);

        // Cargar la imagen original
        originalImage = new ImageIcon("E:\\hola_pancho\\Proyecto\\Imagenes\\Camion3.png");
        lblNewLabel_2 = new JLabel();
        lblNewLabel_2.setLayout(new BorderLayout());
        desktopPane.add(lblNewLabel_2);

        // Crear y añadir botones
        JButton btnNewButton = createButton("Iniciar nuevo viaje");
        desktopPane.add(btnNewButton);

        JButton btnNewButton_1 = createButton("Iniciar transporte");
        desktopPane.add(btnNewButton_1);

        JButton btnNewButton_1_1 = createButton("Iniciar pedido");
        desktopPane.add(btnNewButton_1_1);

        // Añadir JLabel para el mensaje
        lblNewLabel = new JLabel("Selecciona el servicio que necesites...");
        lblNewLabel.setForeground(new Color(128, 255, 255));
        lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
        desktopPane.add(lblNewLabel, BorderLayout.NORTH);

        // Listener para manejar el redimensionamiento de la ventana
        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                Dimension size = getSize();
                adjustComponents(size.width, size.height);
            }
        });

        // Ajustar tamaño inicial
        this.pack();
        resizeImage(getWidth(), getHeight()); // Asegurarse de que la imagen se redimensione inicialmente
    }

    // Método para crear botones
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(200, 30)); // Ajustar el tamaño preferido
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para cada botón
                switch (text) {
                    case "Iniciar nuevo viaje":
                        new Viaje().setVisible(true);
                        break;
                    case "Iniciar transporte":
                        new Transporte().setVisible(true);
                        break;
                    case "Iniciar pedido":
                        new Entrega_P().setVisible(true);
                        break;
                }
            }
        });
        return button;
    }

    // Método para ajustar los componentes
    private void adjustComponents(int width, int height) {
        // Ajustar botones
        int buttonWidth = width / 4; // Establecer el ancho de los botones
        int buttonHeight = 30; // Altura fija para los botones
        int padding = 10; // Espacio entre botones

        Component[] components = contentPane.getComponents();
        
        // Ajustar botones
        int yPosition = height / 4; // posición inicial
        for (Component comp : components) {
            if (comp instanceof JButton) {
                comp.setBounds((width - buttonWidth) / 2, yPosition, buttonWidth, buttonHeight);
                yPosition += buttonHeight + padding; // incrementar la posición y
            }
        }

        // Ajustar JLabel para el mensaje
        lblNewLabel.setBounds((width - 250) / 2, (height / 4) - 50, 250, 30);

        // Ajustar imagen
        resizeImage(width, height);
    }

    // Método para redimensionar la imagen
    private void resizeImage(int width, int height) {
        Image img = originalImage.getImage();
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        lblNewLabel_2.setIcon(new ImageIcon(newImg));
        lblNewLabel_2.setBounds(0, 0, width, height); // Ajustar bounds de la imagen
        lblNewLabel_2.repaint(); // Repintar el JLabel para mostrar los cambios
    }
}
