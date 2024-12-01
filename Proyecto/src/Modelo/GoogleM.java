package Modelo;

import java.awt.Desktop;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class GoogleM {
    private static final String API_KEY = "7462f3a5bad74085a39c4016411b612c"; // Clave de Geoapify
    private static final double COSTO_KM_PESOS = 10.0; // Costo por kilómetro en pesos
    private static final double COSTO_KM_DOLARES = 0.5; // Costo por kilómetro en dólares

    // Método para obtener las coordenadas de una dirección
    public double[] getCoordinates(String address) {
        try {
            // Codificar la dirección antes de agregarla a la URL
            String encodedAddress = URLEncoder.encode(address, "UTF-8");

            String urlString = "https://api.geoapify.com/v1/geocode/search?text=" + encodedAddress + "&apiKey=" + API_KEY;
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String responseStr = response.toString();
            int latIndex = responseStr.indexOf("\"lat\":");
            int lngIndex = responseStr.indexOf("\"lon\":");

            if (latIndex != -1 && lngIndex != -1) {
                double lat = Double.parseDouble(responseStr.substring(latIndex + 6, responseStr.indexOf(",", latIndex)));
                double lon = Double.parseDouble(responseStr.substring(lngIndex + 6, responseStr.indexOf(",", lngIndex)));
                return new double[]{lat, lon};
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Método para calcular la distancia entre dos ubicaciones usando la fórmula de Haversine
    public double obtenerDistancia(String direccionOrigen, String direccionDestino) {
        // Obtener las coordenadas de origen y destino
        double[] coordsOrigen = getCoordinates(direccionOrigen);
        double[] coordsDestino = getCoordinates(direccionDestino);

        if (coordsOrigen != null && coordsDestino != null) {
            double latOrigen = Math.toRadians(coordsOrigen[0]);
            double lonOrigen = Math.toRadians(coordsOrigen[1]);
            double latDestino = Math.toRadians(coordsDestino[0]);
            double lonDestino = Math.toRadians(coordsDestino[1]);

            // Radio de la Tierra en kilómetros
            final double RADIO_TIERRA = 6371.0;

            // Calcular la diferencia de latitudes y longitudes
            double deltaLat = latDestino - latOrigen;
            double deltaLon = lonDestino - lonOrigen;

            // Aplicar la fórmula de Haversine
            double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) +
                    Math.cos(latOrigen) * Math.cos(latDestino) *
                    Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

            // Calcular la distancia
            return RADIO_TIERRA * c;  // Distancia en kilómetros
        }

        return -1; // Si no se pueden obtener las coordenadas
    }

    // Método para calcular el costo en pesos y dólares
    public void mostrarCostos(String direccionOrigen, String direccionDestino) {
        double distancia = obtenerDistancia(direccionOrigen, direccionDestino);

        if (distancia != -1) {
            double costoPesos = distancia * COSTO_KM_PESOS;
            double costoDolares = distancia * COSTO_KM_DOLARES;

            // Mostrar las direcciones, distancia y costos
            JOptionPane.showMessageDialog(null,
                    "Dirección Origen: " + direccionOrigen + "\n" +
                    "Dirección Destino: " + direccionDestino + "\n" +
                    "Distancia: " + distancia + " km\n" +
                    "Costo Estimado (Pesos): " + costoPesos + " MXN\n" +
                    "Costo Estimado (Dólares): " + costoDolares + " USD");

            // Codificar las direcciones para la URL de Google Maps
            try {
                String encodedOrigen = URLEncoder.encode(direccionOrigen, "UTF-8");
                String encodedDestino = URLEncoder.encode(direccionDestino, "UTF-8");

                // Abrir el mapa en el navegador
                String urlMap = "https://www.google.com/maps/dir/?api=1&origin=" + encodedOrigen +
                        "&destination=" + encodedDestino;
                URI uri = new URI(urlMap);
                
                // Verificar si el sistema soporta abrir el navegador
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().browse(uri); // Abre el navegador con el mapa
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede abrir el navegador.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo obtener la distancia.");
        }
    }
}
