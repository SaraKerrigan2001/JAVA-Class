package tiendacarro.Vista;

import java.io.BufferedReader;
import java.io.IOException;

public class VistaApi {
    private final BufferedReader lector;

    public VistaApi(BufferedReader lector) {
        this.lector = lector;
    }

    public String tomarUrl() {
        return leer("Ingresa la URL de la API: ");
    }

    public String tomarUsuario() {
        return leer("Ingresa el usuario de la API: ");
    }

    public String tomarClave() {
        return leer("Ingresa la clave de la API: ");
    }

    public void mostrarApi(String url, String usuario) {
        System.out.println("API registrada: " + url + " | Usuario: " + usuario);
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
