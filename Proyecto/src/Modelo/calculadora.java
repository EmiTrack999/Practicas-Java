package Modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class calculadora extends JFrame {

    private JTextField distanciaField;
    private JComboBox<String> tipoViajeCombo;
    private JCheckBox incluirIvaCheckbox;
    private JTextArea historialArea;
    private JLabel resultadoLabel;
    private ArrayList<String> historial;
    private double costoPorKilometro;
    private double iva = 0.16;

    public calculadora() {
        setTitle("Calculadora de Costo de Viaje");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        historial = new ArrayList<>();
        
        // Configuración de layout
        getContentPane().setLayout(new BorderLayout());

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);  // Layout nulo para compatibilidad con WindowBuilder
        getContentPane().add(panel, BorderLayout.CENTER);

        // Tipo de viaje
        JLabel tipoViajeLabel = new JLabel("Tipo de Viaje:");
        tipoViajeLabel.setBounds(20, 20, 100, 20);
        panel.add(tipoViajeLabel);
        
        tipoViajeCombo = new JComboBox<>(new String[]{"Ligero", "Pesado", "Pasajeros"});
        tipoViajeCombo.setBounds(130, 20, 100, 20);
        panel.add(tipoViajeCombo);

        // Distancia
        JLabel distanciaLabel = new JLabel("Distancia (km):");
        distanciaLabel.setBounds(20, 60, 100, 20);
        panel.add(distanciaLabel);
        
        distanciaField = new JTextField();
        distanciaField.setBounds(130, 60, 100, 20);
        panel.add(distanciaField);

        // Incluir IVA
        JLabel incluirIvaLabel = new JLabel("Incluir IVA:");
        incluirIvaLabel.setBounds(20, 100, 100, 20);
        panel.add(incluirIvaLabel);
        
        incluirIvaCheckbox = new JCheckBox();
        incluirIvaCheckbox.setBounds(130, 100, 20, 20);
        panel.add(incluirIvaCheckbox);

        // Botón Calcular
        JButton calcularButton = new JButton("Calcular Costo");
        calcularButton.setBounds(20, 140, 150, 30);
        calcularButton.addActionListener(new CalcularListener());
        panel.add(calcularButton);

        // Resultado
        resultadoLabel = new JLabel("Resultado:");
        resultadoLabel.setBounds(20, 180, 350, 30);
        panel.add(resultadoLabel);

        // Botón para mostrar historial
        JButton historialButton = new JButton("Mostrar Historial");
        historialButton.setBounds(20, 220, 150, 30);
        historialButton.addActionListener(e -> mostrarHistorial());
        panel.add(historialButton);

        // Área de historial
        historialArea = new JTextArea();
        historialArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(historialArea);
        scrollPane.setBounds(20, 260, 350, 80);
        panel.add(scrollPane);
    }

    private class CalcularListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Obtener valores del formulario
                String tipoViaje = (String) tipoViajeCombo.getSelectedItem();
                double distancia = Double.parseDouble(distanciaField.getText());
                boolean incluirIva = incluirIvaCheckbox.isSelected();

                // Configurar costo por kilómetro según el tipo de viaje
                switch (tipoViaje) {
                    case "Ligero":
                        costoPorKilometro = 2.0;
                        break;
                    case "Pesado":
                        costoPorKilometro = 5.0;
                        break;
                    case "Pasajeros":
                        costoPorKilometro = 3.0;
                        break;
                }

                // Calcular el costo del viaje
                double costoBase = costoPorKilometro * distancia;
                double costoConIva = incluirIva ? costoBase + (costoBase * iva) : costoBase;
                String resultado = String.format("El costo del viaje es: %.2f $pesos", costoConIva);

                // Mostrar el resultado en la etiqueta
                resultadoLabel.setText(resultado);

                // Agregar al historial
                agregarHistorial(resultado);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(calculadora.this, "Por favor ingrese un valor válido para la distancia.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void agregarHistorial(String entrada) {
        historial.add(entrada);
        historialArea.append(entrada + "\n");
    }

    private void mostrarHistorial() {
        StringBuilder sb = new StringBuilder("Historial de Cálculos:\n");
        for (String entry : historial) {
            sb.append(entry).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString(), "Historial", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            calculadora frame = new calculadora();
            frame.setVisible(true);
        });
    }
}
