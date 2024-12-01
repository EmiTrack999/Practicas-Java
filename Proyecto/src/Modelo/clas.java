package Modelo;
public class clas {
    public static void main(String[] args) {
        // Crear una instancia de GoogleM
        GoogleM googleM = new GoogleM();
        
        // Direcciones de ejemplo
        String direccionOrigen = "Av. Paseo de la Reforma 222, Juárez, 06600 Ciudad de México, CDMX, México";
        String direccionDestino = "Zócalo, Centro Histórico, 06000 Ciudad de México, CDMX, México";
        
        // Llamar al método para mostrar los costos y abrir el mapa
        googleM.mostrarCostos(direccionOrigen, direccionDestino);
    }
}
