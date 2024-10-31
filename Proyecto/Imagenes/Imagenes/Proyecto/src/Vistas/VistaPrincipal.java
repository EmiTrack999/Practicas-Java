package Vistas;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Controlador.Modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class VistaPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtCorreo;
    private JTextField txtContra;
    private JTextField txtConfir;
    private JLabel lbContraseña;
    
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

    public VistaPrincipal() {
        setTitle("Vista Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Proyecto\\Imagenes\\goku.jpg"));
        setBounds(100, 100, 631, 494);
        setResizable(false);

        initMenuBar();
        initContentPane();
        initComponents();
    }

    private void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnOptions = new JMenu("Opciones");
        menuBar.add(mnOptions);

        JMenuItem menuHelp = new JMenuItem("Ayuda");
        menuHelp.addActionListener(e -> openHelpURL("https://ayudaacliente.netlify.app/"));
        mnOptions.add(menuHelp);

        JMenuItem menuInfo = new JMenuItem("Informacion");
        mnOptions.add(menuInfo);

        JMenu mnWebPage = new JMenu("Pagina Web");
        menuBar.add(mnWebPage);

        JMenuItem menuQR = new JMenuItem("QR");
        menuQR.setIcon(new ImageIcon("E:\\Proyecto\\Imagenes\\QR3.png"));
        menuQR.addActionListener(e -> openQRWindow());
        mnWebPage.add(menuQR);

        JMenuItem menuLink = new JMenuItem("Enlace");
        menuLink.addActionListener(e -> openHelpURL("https://cargofleetsolutionsempresa.netlify.app"));
        mnWebPage.add(menuLink);
    }

    private void initContentPane() {
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);
    }

    private void initComponents() {
        JLabel lblCorreo = new JLabel("CORREO/TELEFONO");
        lblCorreo.setFont(new Font("Wide Latin", Font.PLAIN, 14));
        lblCorreo.setBounds(185, 54, 321, 31);
        contentPane.add(lblCorreo);

        txtCorreo = new JTextField();
        txtCorreo.setBounds(208, 96, 203, 31);
        txtCorreo.setColumns(10);
        contentPane.add(txtCorreo);

        lbContraseña = new JLabel("CONTRASEÑA");
        lbContraseña.setFont(new Font("Wide Latin", Font.PLAIN, 14));
        lbContraseña.setBounds(208, 126, 224, 26);
        contentPane.add(lbContraseña);

        txtContra = new JTextField();
        txtContra.setBounds(208, 163, 203, 31);
        txtContra.setColumns(10);
        contentPane.add(txtContra);

        JLabel lblConfirmPass = new JLabel("Confirmar contraseña");
        lblConfirmPass.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 11));
        lblConfirmPass.setBounds(218, 204, 168, 20);
        contentPane.add(lblConfirmPass);

        txtConfir = new JTextField();
        txtConfir.setBounds(208, 235, 203, 20);
        txtConfir.setColumns(10);
        contentPane.add(txtConfir);

        JButton btRegis = new JButton("Registrar");
        btRegis.setBounds(265, 329, 89, 14);
        btRegis.addActionListener(e -> openRegisterWindow());
        contentPane.add(btRegis);

        JButton btIniciar = new JButton("Iniciar");
        btIniciar.setBounds(265, 287, 89, 14);
        btIniciar.addActionListener(e -> iniciarSesion());
        contentPane.add(btIniciar);

        JLabel lblBackground = new JLabel();
        lblBackground.setIcon(new ImageIcon("E:\\hola_pancho\\Proyecto\\Imagenes\\fondo-diseno-presentacion-abstracto-azul-moderno_181182-27413.jpg"));
        lblBackground.setBounds(0, -23, 621, 491);
        contentPane.add(lblBackground);
    }

    private void openHelpURL(String url) {
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private void openQRWindow() {
        // Lógica para abrir la ventana QR
        qr qrWindow = new qr();
        qrWindow.setVisible(true);
    }

    private void openRegisterWindow() {
        SegundaVista registerWindow = new SegundaVista();
        registerWindow.setVisible(true);
    }

    private void iniciarSesion() {
        String correo = txtCorreo.getText();
        String contraseña = txtContra.getText();
        String confirmarContraseña = txtConfir.getText();
        Modelo db = new Modelo();

        if (correo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresa tu correo");
        } else if (!db.validarCorreo(correo)) {
            JOptionPane.showMessageDialog(null, "Correo inválido");
        } else if (contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingresa tu contraseña");
        } else if (confirmarContraseña.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Confirma tu contraseña");
        } else if (!contraseña.equals(confirmarContraseña)) {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
        } else {
            // Lógica para iniciar sesión
        }
    }
}
