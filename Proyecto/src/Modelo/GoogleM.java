package Modelo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import javax.swing.JOptionPane;
import java.awt.Desktop;
import javax.swing.SwingUtilities;

public class GoogleM {
    private static final String API_KEY = "7462f3a5bad74085a39c4016411b612c"; // Clave de Geoapify
    private static final double COSTO_KM_PESOS = 10.0; // Costo por kilómetro en pesos
    private static final double COSTO_KM_DOLARES = 0.5; // Costo por kilómetro en dólares

    // Método para obtener las coordenadas a partir de los elementos de la dirección
    public double[] getCoordinates(String calle, String municipio, String estado, String codigoPostal) {
        try {
            // Concatenar los elementos de la dirección
            String address = calle + ", " + municipio + ", " + estado + ", " + codigoPostal;

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

    // Método para calcular la distancia usando los elementos de las direcciones
    public double obtenerDistancia(String calleOrigen, String municipioOrigen, String estadoOrigen, String codigoPostalOrigen,
                                    String calleDestino, String municipioDestino, String estadoDestino, String codigoPostalDestino) {
        double[] coordsOrigen = getCoordinates(calleOrigen, municipioOrigen, estadoOrigen, codigoPostalOrigen);
        double[] coordsDestino = getCoordinates(calleDestino, municipioDestino, estadoDestino, codigoPostalDestino);

        if (coordsOrigen != null && coordsDestino != null) {
            double latOrigen = Math.toRadians(coordsOrigen[0]);
            double lonOrigen = Math.toRadians(coordsOrigen[1]);
            double latDestino = Math.toRadians(coordsDestino[0]);
            double lonDestino = Math.toRadians(coordsDestino[1]);

            final double RADIO_TIERRA = 6371.0;

            double deltaLat = latDestino - latOrigen;
            double deltaLon = lonDestino - lonOrigen;

            double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) +
                    Math.cos(latOrigen) * Math.cos(latDestino) *
                    Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

            return RADIO_TIERRA * c;
        }

        return -1;
    }

    // Método para mostrar los costos con incremento del 10% si el parámetro es true
    public void mostrarCostos(String calleOrigen, String municipioOrigen, String estadoOrigen, String codigoPostalOrigen,
                               String calleDestino, String municipioDestino, String estadoDestino, String codigoPostalDestino,
                               boolean conIncremento) {
        double distancia = obtenerDistancia(calleOrigen, municipioOrigen, estadoOrigen, codigoPostalOrigen,
                                            calleDestino, municipioDestino, estadoDestino, codigoPostalDestino);

        if (distancia != -1) {
            double costoPesos = distancia * COSTO_KM_PESOS;
            double costoDolares = distancia * COSTO_KM_DOLARES;

            // Aplicar incremento del 10% si el parámetro conIncremento es true
            if (conIncremento) {
                costoPesos *= 1.1;
                costoDolares *= 1.1;
            }

            // Mostrar los costos y distancia en un mensaje
            String mensaje = "Dirección Origen: " + calleOrigen + ", " + municipioOrigen + ", " + estadoOrigen + ", " + codigoPostalOrigen + "\n" +
                             "Dirección Destino: " + calleDestino + ", " + municipioDestino + ", " + estadoDestino + ", " + codigoPostalDestino + "\n" +
                             "Distancia: " + distancia + " km\n" +
                             "Costo Estimado (Pesos): " + costoPesos + " MXN\n" +
                             "Costo Estimado (Dólares): " + costoDolares + " USD";

            // Usar JOptionPane para mostrar los costos y la distancia con las opciones de Aceptar o Cancelar
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    int respuesta = JOptionPane.showConfirmDialog(null, mensaje + "\n¿Deseas ver la ruta en Google Maps?", "Información de la Ruta", JOptionPane.YES_NO_OPTION);

                    if (respuesta == JOptionPane.YES_OPTION) {
                        // Codificar las direcciones para abrir Google Maps
                        try {
                            String encodedOrigen = URLEncoder.encode(calleOrigen + ", " + municipioOrigen + ", " + estadoOrigen + ", " + codigoPostalOrigen, "UTF-8");
                            String encodedDestino = URLEncoder.encode(calleDestino + ", " + municipioDestino + ", " + estadoDestino + ", " + codigoPostalDestino, "UTF-8");

                            // URL de Google Maps para mostrar la ruta
                            String urlMap = "https://www.google.com/maps/dir/?api=1&origin=" + encodedOrigen +
                                    "&destination=" + encodedDestino;
                            URI uri = new URI(urlMap);

                            // Abrir la URL en el navegador
                            if (Desktop.isDesktopSupported()) {
                                Desktop.getDesktop().browse(uri);
                            } else {
                                JOptionPane.showMessageDialog(null, "No se puede abrir el navegador.");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar abrir el mapa.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Operación cancelada.");
                    }
                }
            });
        } else {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JOptionPane.showMessageDialog(null, "No se pudo obtener la distancia.");
                }
            });
        }
    }

    // Método para mostrar los costos y la ruta con tipo de carga y si se desea un incremento del 10%
    public void mostrarCostosYRutaConTipoCarga(String calleOrigen, String municipioOrigen, String estadoOrigen, String codigoPostalOrigen,
                                               String calleDestino, String municipioDestino, String estadoDestino, String codigoPostalDestino,
                                               String tipoCarga, boolean conIncremento) {
        double distancia = obtenerDistancia(calleOrigen, municipioOrigen, estadoOrigen, codigoPostalOrigen,
                                            calleDestino, municipioDestino, estadoDestino, codigoPostalDestino);

        if (distancia != -1) {
            // Ajustar el costo por tipo de carga
            double factorCarga = tipoCarga.equalsIgnoreCase("Pesado") ? 1.5 : 1.0;
            double costoPesos = distancia * COSTO_KM_PESOS * factorCarga;
            double costoDolares = distancia * COSTO_KM_DOLARES * factorCarga;

            // Aplicar incremento del 10% si el parámetro conIncremento es true
            if (conIncremento) {
                costoPesos *= 1.1;
                costoDolares *= 1.1;
            }

            // Mostrar los costos y la distancia en un mensaje
            String mensaje = "Dirección Origen: " + calleOrigen + ", " + municipioOrigen + ", " + estadoOrigen + ", " + codigoPostalOrigen + "\n" +
                             "Dirección Destino: " + calleDestino + ", " + municipioDestino + ", " + estadoDestino + ", " + codigoPostalDestino + "\n" +
                             "Tipo de Carga: " + tipoCarga + "\n" +
                             "Distancia: " + distancia + " km\n" +
                             "Costo Estimado (Pesos): " + costoPesos + " MXN\n" +
                             "Costo Estimado (Dólares): " + costoDolares + " USD";

            // Usar JOptionPane para mostrar los costos y la distancia con las opciones de Aceptar o Cancelar
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    int respuesta = JOptionPane.showConfirmDialog(null, mensaje + "\n¿Deseas ver la ruta en Google Maps?", "Información de la Ruta", JOptionPane.YES_NO_OPTION);

                    if (respuesta == JOptionPane.YES_OPTION) {
                        // Codificar las direcciones para abrir Google Maps
                        try {
                            String encodedOrigen = URLEncoder.encode(calleOrigen + ", " + municipioOrigen + ", " + estadoOrigen + ", " + codigoPostalOrigen, "UTF-8");
                            String encodedDestino = URLEncoder.encode(calleDestino + ", " + municipioDestino + ", " + estadoDestino + ", " + codigoPostalDestino, "UTF-8");

                            // URL de Google Maps para mostrar la ruta
                            String urlMap = "https://www.google.com/maps/dir/?api=1&origin=" + encodedOrigen +
                                    "&destination=" + encodedDestino;
                            URI uri = new URI(urlMap);

                            // Abrir la URL en el navegador
                            if (Desktop.isDesktopSupported()) {
                                Desktop.getDesktop().browse(uri);
                            } else {
                                JOptionPane.showMessageDialog(null, "No se puede abrir el navegador.");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar abrir el mapa.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Operación cancelada.");
                    }
                }
            });
        } else {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JOptionPane.showMessageDialog(null, "No se pudo obtener la distancia.");
                }
            });
        }
    }
}
