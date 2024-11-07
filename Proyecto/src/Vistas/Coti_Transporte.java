package Vistas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Coti_Transporte extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_5;

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 878, 587);
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
        lblNewLabel_1_1_1.setBounds(57, 176, 224, 31);
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

        textField = new JTextField();
        textField.setBounds(424, 111, 295, 19);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(424, 184, 295, 19);
        contentPane.add(textField_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(424, 254, 295, 19);
        contentPane.add(textField_3);

        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(559, 405, 295, 19);
        contentPane.add(textField_5);

        JButton btnNewButton = new JButton("Cotizar Transporte");
        btnNewButton.setBackground(Color.DARK_GRAY);
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton.setBounds(288, 487, 224, 53);
        contentPane.add(btnNewButton);

        // Crear los botones de radio
        JRadioButton rdbtnNewRadioButton = new JRadioButton("Privado");
        rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnNewRadioButton.setBounds(424, 330, 103, 21);
        contentPane.add(rdbtnNewRadioButton);

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Publico");
        rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnNewRadioButton_1.setBounds(559, 330, 103, 21);
        contentPane.add(rdbtnNewRadioButton_1);

        // Agrupar los botones de radio para que solo se pueda elegir uno
        ButtonGroup group = new ButtonGroup();
        group.add(rdbtnNewRadioButton);
        group.add(rdbtnNewRadioButton_1);
    }
}
