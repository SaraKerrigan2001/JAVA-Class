package tiendacarro.Servicio;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import tiendacarro.Modelo.ChoferModelo;
import tiendacarro.Modelo.PasajeroModelo;


public class RegistroServicio {

    private static final String ARCHIVO_CHOFERES  = "choferes.csv";
    private static final String ARCHIVO_PASAJEROS = "pasajeros.csv";
    private static final String SEPARADOR         = ";";

    private final List<ChoferModelo>   choferes   = new ArrayList<>();
    private final List<PasajeroModelo> pasajeros  = new ArrayList<>();

    public RegistroServicio() {
        cargarChoferes();
        cargarPasajeros();
    }
   
    public void agregarChofer(ChoferModelo chofer) {
        choferes.add(chofer);
        guardarChofer(chofer);
    }

    public void agregarPasajero(PasajeroModelo pasajero) {
        pasajeros.add(pasajero);
        guardarPasajero(pasajero);
    }

    public List<ChoferModelo> getChoferes() {
        return choferes;
    }

    public List<PasajeroModelo> getPasajeros() {
        return pasajeros;
    }
  
    private void guardarChofer(ChoferModelo chofer) {
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(ARCHIVO_CHOFERES, true))) {

            // Si el archivo está vacío escribe la cabecera
            File archivo = new File(ARCHIVO_CHOFERES);
            if (archivo.length() == 0) {
                bw.write("Nombre;Licencia;Cedula");
                bw.newLine();
            }

            bw.write(escapar(chofer.getNombreChofer())
                    + SEPARADOR + escapar(chofer.getLicenciaChofer())
                    + SEPARADOR + escapar(chofer.getCedulaChofer()));
            bw.newLine();

        } catch (IOException e) {
            System.out.println("[Advertencia] No se pudo guardar el chofer en disco: " + e.getMessage());
        }
    }

    private void guardarPasajero(PasajeroModelo pasajero) {
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(ARCHIVO_PASAJEROS, true))) {

            File archivo = new File(ARCHIVO_PASAJEROS);
            if (archivo.length() == 0) {
                bw.write("Nombre;Cedula");
                bw.newLine();
            }

            bw.write(escapar(pasajero.getNombre())
                    + SEPARADOR + escapar(pasajero.getCedula()));
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
                if (primeraLinea) { primeraLinea = false; continue; } // salta cabecera
                String[] partes = linea.split(SEPARADOR, -1);
                if (partes.length == 3) {
                    choferes.add(new ChoferModelo(partes[0], partes[1], partes[2]));
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
                if (primeraLinea) { primeraLinea = false; continue; }
                String[] partes = linea.split(SEPARADOR, -1);
                if (partes.length == 2) {
                    pasajeros.add(new PasajeroModelo(partes[0], partes[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("[Advertencia] No se pudo leer " + ARCHIVO_PASAJEROS + ": " + e.getMessage());
        }
    }

    private String escapar(String valor) {
        if (valor == null) return "";
        // Si el valor contiene el separador o saltos de línea, lo envuelve en comillas
        if (valor.contains(SEPARADOR) || valor.contains("\n") || valor.contains("\"")) {
            return "\"" + valor.replace("\"", "\"\"") + "\"";
        }
        return valor;
    }
}
