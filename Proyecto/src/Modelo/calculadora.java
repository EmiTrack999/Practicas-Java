package Modelo;

import javax.swing.*;
import java.util.ArrayList;

public class calculadora {

    private double costoPorKilometro;
    private double distancia;
    private double iva = 0.16; 
    private ArrayList<String> historial;

    public calculadora() {
        this.costoPorKilometro = 0.0;
        this.distancia = 0.0;
        this.historial = new ArrayList<>();
    }

    public void establecerCostoPorKilometro(double costo) {
        if (costo < 0) {
            throw new IllegalArgumentException("El costo por kilómetro no puede ser negativo.");
        }
        this.costoPorKilometro = costo;
    }

    public void establecerDistancia(double distancia) {
        if (distancia < 0) {
            throw new IllegalArgumentException("La distancia no puede ser negativa.");
        }
        this.distancia = distancia;
    }

    public double calcularCostoViaje(boolean incluirIva) {
        double costoBase = costoPorKilometro * distancia;
        double costoConIva = incluirIva ? costoBase + (costoBase * iva) : costoBase;
        return costoConIva;
    }

    public void agregarHistorial(String entrada) {
        historial.add(entrada);
    }

    public void mostrarHistorial() {
        StringBuilder sb = new StringBuilder("Historial de Cálculos:\n");
        for (String entry : historial) {
            sb.append(entry).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Historial", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        calculadora calculadora = new calculadora();

        String[] opciones = {"Ligero", "Pesado", "Pasajeros"};
        String tipoViaje = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de viaje:",
                "Tipo de Viaje", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        switch (tipoViaje) {
            case "Ligero":
                calculadora.establecerCostoPorKilometro(2.0); 
                break;
            case "Pesado":
                calculadora.establecerCostoPorKilometro(5.0); 
                break;
            case "Pasajeros":
                calculadora.establecerCostoPorKilometro(3.0); 
                break;
        }

        String distanciaInput = JOptionPane.showInputDialog("Ingrese la distancia del viaje (en km):");
        double distancia = Double.parseDouble(distanciaInput);
        calculadora.establecerDistancia(distancia);

        String incluirIvaInput = (String) JOptionPane.showInputDialog(null, "¿Incluir IVA?",
                "IVA", JOptionPane.QUESTION_MESSAGE, null, new String[]{"Sí", "No"}, "Sí");
        
        boolean incluirIva = incluirIvaInput.equals("Sí");

        double costoViaje = calculadora.calcularCostoViaje(incluirIva);
        String resultado = String.format("El costo del viaje es: %.2f $pesos", costoViaje);
        JOptionPane.showMessageDialog(null, resultado);
        calculadora.agregarHistorial(resultado);

        // Opción para mostrar el historial
        if (JOptionPane.showConfirmDialog(null, "¿Desea ver el historial de cálculos?", "Historial", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            calculadora.mostrarHistorial();
        }
    }
}