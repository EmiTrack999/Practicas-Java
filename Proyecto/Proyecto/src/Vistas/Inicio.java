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
    private JLabel lblNewLabel_2; // Mover la declaración a nivel de clase
    private ImageIcon originalImage; // Almacenar la imagen original
    private JLabel lblNewLabel; // Guardar la etiqueta del mensaje
    private JButton btnNewButton, btnNewButton_1, btnNewButton_1_1; // Guardar referencias a los botones

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
        setBounds(100, 100, 800, 600); // Ajustar la posición y el tamaño inicial de la ventana
        setResizable(true); // Permitir que la ventana sea redimensionable

        JMenuBar menuBar = new JMenuBar();
        menuBar.setMargin(new Insets(100, 100, 100,100));
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

        JLayeredPane layeredPane = new JLayeredPane();
        contentPane.add(layeredPane, BorderLayout.CENTER);

        // Cargar la imagen original
        originalImage = new ImageIcon("C:/Users/Alumno.SC3PC34.000/Desktop/PRACTICAS%202.0/Practicas-Java/Proyecto/Proyecto/Imagenes/Imagenes/Camion2.png");
        lblNewLabel_2 = new JLabel();
        lblNewLabel_2.setLayout(new BorderLayout());
        lblNewLabel_2.setBounds(0, 0, 800, 600); // Tamaño inicial de la imagen
        layeredPane.add(lblNewLabel_2, Integer.valueOf(0)); // Añadir la imagen en la capa inferior

        // Crear y añadir botones
        btnNewButton = createButton("Iniciar nuevo viaje");
        layeredPane.add(btnNewButton, Integer.valueOf(1)); // Asegurar que esté sobre la imagen

        btnNewButton_1 = createButton("Iniciar transporte");
        layeredPane.add(btnNewButton_1, Integer.valueOf(1)); // Asegurar que esté sobre la imagen

        btnNewButton_1_1 = createButton("Iniciar pedido");
        layeredPane.add(btnNewButton_1_1, Integer.valueOf(1)); // Asegurar que esté sobre la imagen

        // Añadir JLabel para el mensaje
        lblNewLabel = new JLabel("Selecciona el servicio que necesite");
        lblNewLabel.setForeground(new Color(128, 255, 255));
        lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
        layeredPane.add(lblNewLabel, Integer.valueOf(1)); // Asegurar que esté sobre la imagen

        // Listener para manejar el redimensionamiento de la ventana
        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                Dimension size = getSize();
                adjustComponents(size.width, size.height);
            }
        });
    }

    // Método para crear botones
    private JButton createButton(String text) {
        JButton button = new JButton(text);
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
        // Ajustar el tamaño del JLabel de la imagen al tamaño de la ventana
        lblNewLabel_2.setBounds(0, 0, width, height); 
        resizeImage(width, height);

        // Calcular nuevas posiciones y tamaños para los botones en función de la ventana
        int buttonWidth = (int) (width * 0.25); // 25% del ancho de la ventana
        int buttonHeight = (int) (height * 0.07); // 7% de la altura de la ventana
        int spacing = (int) (height * 0.02); // 2% de la altura de la ventana

        // Recalcular posiciones centradas
        int xPosition = (width - buttonWidth) / 2;
        int yPositionStart = height / 4; // Un cuarto de la altura de la ventana

        // Ajustar cada botón
        btnNewButton.setBounds(xPosition, yPositionStart, buttonWidth, buttonHeight);
        btnNewButton_1.setBounds(xPosition, yPositionStart + buttonHeight + spacing, buttonWidth, buttonHeight);
        btnNewButton_1_1.setBounds(xPosition, yPositionStart + (buttonHeight + spacing) * 2, buttonWidth, buttonHeight);

        // Ajustar la posición del JLabel del mensaje
        lblNewLabel.setBounds((width - 250) / 2, yPositionStart - 50, 250, 30);
    }

    // Método para redimensionar la imagen
    private void resizeImage(int width, int height) {
        Image img = originalImage.getImage();
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        lblNewLabel_2.setIcon(new ImageIcon(newImg));
        lblNewLabel_2.repaint(); // Repintar el JLabel para mostrar los cambios
    }
}
