package tiendacarro.Vista;

import java.io.BufferedReader;
import java.io.IOException;

public class VistaPasajero {
    private final BufferedReader lector;

    public VistaPasajero(BufferedReader lector) {
        this.lector = lector;
    }

    public String tomarNombre() {
        return leer("Ingresa el nombre del pasajero: ");
    }

    public String tomarCedula() {
        return leer("Ingresa la cedula del pasajero: ");
    }

    public void mostrarPasajero(String nombre, String cedula) {
        System.out.println("Pasajero registrado: " + nombre + " | " + cedula);
    }

    private String leer(String prompt) {
        System.out.print(prompt);
        System.out.flush();
        try {
            String linea = lector.readLine();
            return linea != null ? linea.trim() : "";
        } catch (IOException e) {
            return "";
        }
    }
}
