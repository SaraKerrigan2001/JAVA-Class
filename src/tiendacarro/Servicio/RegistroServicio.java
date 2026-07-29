package tiendacarro.Servicio;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import tiendacarro.Modelo.chofer_modelo;
import tiendacarro.Modelo.pasajero_modelo;

public class RegistroServicio {

    private static final String ARCHIVO_CHOFERES  = "choferes.csv";
    private static final String ARCHIVO_PASAJEROS = "pasajeros.csv";
    private static final String SEPARADOR = ";";

    private final List<chofer_modelo>   choferes  = new ArrayList<>();
    private final List<pasajero_modelo> pasajeros = new ArrayList<>();

    public RegistroServicio() {
        cargarChoferes();
        cargarPasajeros();
    }

    public void agregarChofer(chofer_modelo chofer) {
        choferes.add(chofer); 
        guardarChofer(chofer); 
    }

    public void agregarPasajero(pasajero_modelo pasajero) {
        pasajeros.add(pasajero); 
        guardarPasajero(pasajero); 
    }

    public List<chofer_modelo> getChoferes() {
        return choferes;
    }

    public List<pasajero_modelo> getPasajeros() {
        return pasajeros;
    }

    private void guardarChofer(chofer_modelo chofer) {

        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(ARCHIVO_CHOFERES, true))) {

            File archivo = new File(ARCHIVO_CHOFERES);
            if (archivo.length() == 0) {
                bw.write("Nombre;Licencia;Cedula");
                bw.newLine();
            }

            bw.write(escapar(chofer.getNombre_chofer())
                    + SEPARADOR + escapar(chofer.getLicencia())
                    + SEPARADOR + escapar(chofer.getCedula_chofer()));
            bw.newLine(); 

        } catch (IOException e) {
            System.out.println("[Advertencia] No se pudo guardar el chofer en disco: " + e.getMessage());
        }
    }

    private void guardarPasajero(pasajero_modelo pasajero) {

        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(ARCHIVO_PASAJEROS, true))) {

            File archivo = new File(ARCHIVO_PASAJEROS);
            if (archivo.length() == 0) {
                bw.write("Nombre;Cedula"); 
                bw.newLine();
            }

            bw.write(escapar(pasajero.getNombre_pasajero())
                    + SEPARADOR + escapar(pasajero.getCedula_pasajero()));
            bw.newLine();

        } catch (IOException e) {
            System.out.println("[Advertencia] No se pudo guardar el pasajero en disco: " + e.getMessage());
        }
    }

    private void cargarChoferes() {

        File archivo = new File(ARCHIVO_CHOFERES);

        if (!archivo.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            boolean primeraLinea = true;

            while ((linea = br.readLine()) != null) {

                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }

                String[] partes = linea.split(SEPARADOR, -1);

                if (partes.length == 3) {
                    choferes.add(new chofer_modelo(partes[0], partes[2], partes[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("[Advertencia] No se pudo leer " + ARCHIVO_CHOFERES + ": " + e.getMessage());
        }
    }

    private void cargarPasajeros() {

        File archivo = new File(ARCHIVO_PASAJEROS);

        if (!archivo.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            boolean primeraLinea = true;

            while ((linea = br.readLine()) != null) {

                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }

                String[] partes = linea.split(SEPARADOR, -1);

                if (partes.length == 2) {
                    pasajeros.add(new pasajero_modelo(partes[0], "", partes[1], ""));
                }
            }
        } catch (IOException e) {
            System.out.println("[Advertencia] No se pudo leer " + ARCHIVO_PASAJEROS + ": " + e.getMessage());
        }
    }

    private String escapar(String valor) {
        if (valor == null) return "";

        if (valor.contains(SEPARADOR) || valor.contains("\n") || valor.contains("\"")) {
            return "\"" + valor.replace("\"", "\"\"") + "\"";
        }

        return valor;
    }
}
