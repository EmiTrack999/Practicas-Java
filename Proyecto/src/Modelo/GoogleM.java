package Modelo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class GoogleM {

    // Mapa de algunas ciudades principales de México y sus coordenadas (latitud, longitud)
    private static final Map<String, double[]> ubicaciones = new HashMap<>();

    static {
        // Ciudades importantes de México
        ubicaciones.put("Ciudad de México", new double[]{19.432608, -99.133209});
        ubicaciones.put("Guadalajara", new double[]{20.659698, -103.349609});
        ubicaciones.put("Monterrey", new double[]{25.676722, -100.318236});
        ubicaciones.put("Cancún", new double[]{21.174285, -86.846558});
        ubicaciones.put("Mérida", new double[]{21.161908, -89.1658});
        ubicaciones.put("Puebla", new double[]{19.041963, -98.206413});
        ubicaciones.put("León", new double[]{21.1619, -101.6880});
        ubicaciones.put("Tijuana", new double[]{32.5149, -117.0382});
        ubicaciones.put("Mazatlán", new double[]{23.2494, -106.4110});
        ubicaciones.put("Culiacán", new double[]{24.7992, -107.3841});
        // Agrega más ciudades si lo deseas
    }

    public static void main(String[] args) {
        // Crear el marco
        JFrame frame = new JFrame("Calculadora de Distancia con Google Maps");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Etiquetas y campos de texto para las ubicaciones
        JLabel labelUbicacion1 = new JLabel("Seleccionar Ubicación 1:");
        labelUbicacion1.setBounds(30, 30, 150, 30);
        frame.add(labelUbicacion1);

        // Crear un JComboBox con las ciudades de México
        JComboBox<String> comboUbicacion1 = new JComboBox<>(ubicaciones.keySet().toArray(new String[0]));
        comboUbicacion1.setBounds(180, 30, 200, 30);
        frame.add(comboUbicacion1);

        JLabel labelUbicacion2 = new JLabel("Seleccionar Ubicación 2:");
        labelUbicacion2.setBounds(30, 80, 150, 30);
        frame.add(labelUbicacion2);

        // Crear un JComboBox con las ciudades de México
        JComboBox<String> comboUbicacion2 = new JComboBox<>(ubicaciones.keySet().toArray(new String[0]));
        comboUbicacion2.setBounds(180, 80, 200, 30);
        frame.add(comboUbicacion2);

        // Botón para calcular distancia
        JButton calcularButton = new JButton("Calcular Distancia");
        calcularButton.setBounds(150, 130, 200, 30);
        frame.add(calcularButton);

        // Acción del botón
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obtener las ubicaciones seleccionadas
                    String ubicacion1 = (String) comboUbicacion1.getSelectedItem();
                    String ubicacion2 = (String) comboUbicacion2.getSelectedItem();

                    // Obtener las coordenadas de las ubicaciones
                    double[] coords1 = ubicaciones.get(ubicacion1);
                    double[] coords2 = ubicaciones.get(ubicacion2);

                    // Calcular la distancia usando la fórmula Haversine
                    double distance = haversine(coords1[0], coords1[1], coords2[0], coords2[1]);

                    // Calcular el costo (ejemplo: 5 unidades monetarias por km)
                    double cost = distance * 5; // Tarifa de 5 unidades monetarias por kilómetro

                    // Mostrar los resultados en un JOptionPane
                    String message = String.format("Distancia entre %s y %s: %.2f km\nCosto estimado: %.2f unidades monetarias", ubicacion1, ubicacion2, distance, cost);
                    JOptionPane.showMessageDialog(frame, message, "Distancia y Costo", JOptionPane.INFORMATION_MESSAGE);

                    // Formar la URL de Google Maps
                    String url = String.format("https://www.google.com/maps/dir/%s,%s/%s,%s", coords1[0], coords1[1], coords2[0], coords2[1]);

                    // Abrir el navegador con la URL
                    Runtime.getRuntime().exec(new String[]{"cmd", "/c", "start", url});

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error al intentar calcular la distancia.", "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });

        // Hacer visible el marco
        frame.setVisible(true);
    }

    // Método para calcular la distancia usando la fórmula Haversine
    private static double haversine(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radio de la Tierra en kilómetros
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c; // Resultado en kilómetros
    }
}
