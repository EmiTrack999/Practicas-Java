package Modelo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class GoogleM {

    private static final Map<String, double[]> ubicaciones = new HashMap<>();

    static {
    	 // Ciudad de México y municipios
        ubicaciones.put("Ciudad de México", new double[]{19.432608, -99.133209});
        ubicaciones.put("Álvaro Obregón", new double[]{19.358076, -99.213394});
        ubicaciones.put("Coyoacán", new double[]{19.355026, -99.162267});
        ubicaciones.put("Iztapalapa", new double[]{19.350554, -99.070080});
        ubicaciones.put("Benito Juárez", new double[]{19.359960, -99.168904});
        ubicaciones.put("Magdalena Contreras", new double[]{19.261842, -99.284254});
        ubicaciones.put("Xochimilco", new double[]{19.242611, -99.073241});
        ubicaciones.put("Tlalpan", new double[]{19.295564, -99.178046});
        ubicaciones.put("Azcapotzalco", new double[]{19.245265, -99.232437});

        // Estado de México y municipios adicionales
        ubicaciones.put("Tecámac", new double[]{19.713510, -98.937303});
        ubicaciones.put("Toluca", new double[]{19.282601, -99.659591});
        ubicaciones.put("Nezahualcóyotl", new double[]{19.407556, -99.938476});
        ubicaciones.put("Ecatepec", new double[]{19.604339, -98.974037});
        ubicaciones.put("Naucalpan", new double[]{19.470118, -99.206599});
        ubicaciones.put("Tlalnepantla", new double[]{19.577282, -99.216115});
        ubicaciones.put("Cuautitlán Izcalli", new double[]{19.692579, -99.232106});
        ubicaciones.put("Atizapán de Zaragoza", new double[]{19.555041, -99.367981});
        ubicaciones.put("Chimalhuacán", new double[]{19.423508, -98.997319});
        ubicaciones.put("San Mateo Atenco", new double[]{19.395227, -99.982090});
        ubicaciones.put("La Paz", new double[]{19.407555, -98.926789});
        ubicaciones.put("Ixtapaluca", new double[]{19.270842, -98.804477});
        ubicaciones.put("Coacalco", new double[]{19.651462, -99.068487});
        ubicaciones.put("Valle de Chalco", new double[]{19.291478, -98.870743});
        ubicaciones.put("Melchor Múzquiz", new double[]{19.365417, -99.532622});
        ubicaciones.put("Zinacantepec", new double[]{19.267792, -99.976280});

        // Guadalajara y municipios
        ubicaciones.put("Guadalajara", new double[]{20.659698, -103.349609});
        ubicaciones.put("Zapopan", new double[]{20.711507, -103.419477});
        ubicaciones.put("Tlaquepaque", new double[]{20.616284, -103.183708});
        ubicaciones.put("Tonala", new double[]{20.586809, -103.231087});
        ubicaciones.put("Tlajomulco de Zúñiga", new double[]{20.500073, -103.566482});
        ubicaciones.put("Ixtlahuacán de los Membrillos", new double[]{20.370987, -103.286257});
        ubicaciones.put("El Salto", new double[]{20.377323, -103.258651});
        ubicaciones.put("Juanacatlán", new double[]{20.348622, -103.204006});

        // Monterrey y municipios
        ubicaciones.put("Monterrey", new double[]{25.676722, -100.318236});
        ubicaciones.put("San Nicolás", new double[]{25.748230, -100.319274});
        ubicaciones.put("San Pedro Garza García", new double[]{25.663226, -100.420126});
        ubicaciones.put("Escobedo", new double[]{25.733819, -100.275452});
        ubicaciones.put("Santa Catarina", new double[]{25.623802, -100.399445});
        ubicaciones.put("General Escobedo", new double[]{25.737056, -100.311525});
        ubicaciones.put("Guadalupe", new double[]{25.671064, -100.262925});
        ubicaciones.put("Apodaca", new double[]{25.774453, -100.249358});

        // Cancún y municipios
        ubicaciones.put("Cancún", new double[]{21.174285, -86.846558});
        ubicaciones.put("Isla Mujeres", new double[]{21.230485, -86.734310});
        ubicaciones.put("Puerto Morelos", new double[]{20.843121, -87.349231});
        ubicaciones.put("Playa del Carmen", new double[]{20.629557, -87.073547});
        ubicaciones.put("Tulum", new double[]{20.211889, -87.465535});
        ubicaciones.put("Cozumel", new double[]{20.512089, -86.945406});

        // Mérida y municipios
        ubicaciones.put("Mérida", new double[]{21.161908, -89.1658});
        ubicaciones.put("Progreso", new double[]{21.285586, -89.664738});
        ubicaciones.put("Conkal", new double[]{21.103426, -89.504745});
        ubicaciones.put("Baca", new double[]{21.033251, -89.619444});
        ubicaciones.put("Kanasín", new double[]{20.961163, -89.637283});

        // Puebla y municipios
        ubicaciones.put("Puebla", new double[]{19.041963, -98.206413});
        ubicaciones.put("Atlixco", new double[]{18.953564, -98.464256});
        ubicaciones.put("Cholula", new double[]{19.051043, -98.306557});
        ubicaciones.put("San Andrés Cholula", new double[]{19.078132, -98.266243});
        ubicaciones.put("Tehuacán", new double[]{18.461301, -97.373007});
        ubicaciones.put("Amozoc", new double[]{19.070648, -98.169127});
        ubicaciones.put("Huejotzingo", new double[]{19.167209, -98.459953});
        ubicaciones.put("Tecamachalco", new double[]{18.957210, -97.758850});

        // León y municipios
        ubicaciones.put("León", new double[]{21.1619, -101.6880});
        ubicaciones.put("Silao", new double[]{20.565732, -101.476518});
        ubicaciones.put("Irapuato", new double[]{20.674443, -101.369084});
        ubicaciones.put("Guanajuato", new double[]{21.019014, -101.257623});
        ubicaciones.put("Celaya", new double[]{20.521763, -100.819904});
        ubicaciones.put("Salamanca", new double[]{20.573771, -101.192537});
        ubicaciones.put("San Francisco del Rincón", new double[]{21.032308, -101.780072});

        // Tijuana y municipios
        ubicaciones.put("Tijuana", new double[]{32.5149, -117.0382});
        ubicaciones.put("Playas de Rosarito", new double[]{32.348589, -116.900407});
        ubicaciones.put("Ensenada", new double[]{31.865387, -116.596945});
        ubicaciones.put("Tecate", new double[]{32.572285, -116.749932});
        ubicaciones.put("Mexicali", new double[]{32.664413, -115.468154});

        // Mazatlán y municipios
        ubicaciones.put("Mazatlán", new double[]{23.2494, -106.4110});
        ubicaciones.put("El Rosario", new double[]{22.5427, -105.9452});
        ubicaciones.put("Escuinapa", new double[]{23.1803, -105.9507});
        ubicaciones.put("Culiacán", new double[]{24.7992, -107.3841});
        ubicaciones.put("Navolato", new double[]{24.534181, -107.585263});
        ubicaciones.put("Guasave", new double[]{25.568833, -108.444129});

        // Querétaro y municipios
        ubicaciones.put("Querétaro", new double[]{20.5888, -100.3899});
        ubicaciones.put("San Juan del Río", new double[]{20.394377, -99.982407});
        ubicaciones.put("El Marqués", new double[]{20.6303, -100.2972});
        ubicaciones.put("Colón", new double[]{20.621738, -100.658647});
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora de Distancia con Google Maps");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel labelUbicacion1 = new JLabel("Ingresar ciudad 1:");
        labelUbicacion1.setBounds(30, 30, 250, 30);
        frame.add(labelUbicacion1);

        JTextField inputUbicacion1 = new JTextField();
        inputUbicacion1.setBounds(30, 60, 200, 30);
        frame.add(inputUbicacion1);

        JLabel labelUbicacion2 = new JLabel("Ingresar ciudad 2:");
        labelUbicacion2.setBounds(30, 120, 250, 30);
        frame.add(labelUbicacion2);

        JTextField inputUbicacion2 = new JTextField();
        inputUbicacion2.setBounds(30, 150, 200, 30);
        frame.add(inputUbicacion2);

        JButton calcularButton = new JButton("Calcular Distancia");
        calcularButton.setBounds(200, 220, 200, 30);
        frame.add(calcularButton);

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String ciudad1 = inputUbicacion1.getText().trim();
                    String ciudad2 = inputUbicacion2.getText().trim();

                    double[] coords1 = ubicaciones.get(ciudad1);
                    double[] coords2 = ubicaciones.get(ciudad2);

                    // Verificar si las ciudades ingresadas existen en el mapa
                    if (coords1 == null) {
                        JOptionPane.showMessageDialog(frame, "Ciudad 1 no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (coords2 == null) {
                        JOptionPane.showMessageDialog(frame, "Ciudad 2 no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Calcular la distancia
                    double distance = haversine(coords1[0], coords1[1], coords2[0], coords2[1]);
                    double costMXN = distance * 5;
                    double conversionRate = 18.0;
                    double costUSD = costMXN / conversionRate;

                    String message = String.format("Distancia entre puntos: %.2f km\nCosto estimado: %.2f MXN (%.2f USD)",
                            distance, costMXN, costUSD);
                    JOptionPane.showMessageDialog(frame, message, "Distancia y Costo", JOptionPane.INFORMATION_MESSAGE);

                    String url = String.format("https://www.google.com/maps/dir/%s,%s/%s,%s",
                            coords1[0], coords1[1], coords2[0], coords2[1]);
                    Runtime.getRuntime().exec(new String[]{"cmd", "/c", "start", url});

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error al intentar calcular la distancia.", "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });

        frame.setVisible(true);
    }

    private static double haversine(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radio de la Tierra en km
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c; // Resultado en kilómetros
    }
}
