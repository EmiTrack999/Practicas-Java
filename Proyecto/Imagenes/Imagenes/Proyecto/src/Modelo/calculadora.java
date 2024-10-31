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

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));

        // Componentes de la interfaz
        panel.add(new JLabel("Tipo de Viaje:"));
        tipoViajeCombo = new JComboBox<>(new String[]{"Ligero", "Pesado", "Pasajeros"});
        panel.add(tipoViajeCombo);

        panel.add(new JLabel("Distancia (km):"));
        distanciaField = new JTextField();
        panel.add(distanciaField);

        panel.add(new JLabel("Incluir IVA:"));
        incluirIvaCheckbox = new JCheckBox();
        panel.add(incluirIvaCheckbox);

        // Botón de cálculo
        JButton calcularButton = new JButton("Calcular Costo");
        calcularButton.addActionListener(new CalcularListener());
        panel.add(calcularButton);

        // Resultado
        resultadoLabel = new JLabel("Resultado:");
        panel.add(resultadoLabel);

        // Botón para mostrar el historial
        JButton historialButton = new JButton("Mostrar Historial");
        historialButton.addActionListener(e -> mostrarHistorial());
        panel.add(historialButton);

        // Área de historial
        historialArea = new JTextArea(5, 20);
        historialArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(historialArea);
        panel.add(scrollPane);

        add(panel);
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
