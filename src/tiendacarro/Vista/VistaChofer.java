package tiendacarro.Vista;

import java.io.BufferedReader;
import java.io.IOException;

public class VistaChofer {
    private final BufferedReader lector;

    public VistaChofer(BufferedReader lector) {
        this.lector = lector;
    }

    public String tomarNombre() {
        return leer("Ingrese el nombre del chofer: ");
    }

    public String tomarLicencia() {
        return leer("Ingrese la licencia del chofer: ");
    }

    public String tomarCedula() {
        return leer("Ingrese la cedula del chofer: ");
    }

    public void mostrarChofer(String nombre, String licencia, String cedula) {
        System.out.println("Chofer registrado: " + nombre + " | " + licencia + " | " + cedula);
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
