package tiendacarro.Vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class VistaMenu {
    private final BufferedReader lector;

    public VistaMenu(BufferedReader lector) {
        this.lector = lector;
    }

    public int mostrarMenuPrincipal() {
        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("║        TIENDA CARRO          ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║  1. Registrar chofer         ║");
        System.out.println("║  2. Registrar pasajero       ║");
        System.out.println("║  3. Registrar carro          ║");
        System.out.println("║  4. Registrar motor          ║");
        System.out.println("║  5. Ver choferes registrados ║");
        System.out.println("║  6. Ver pasajeros registrados║");
        System.out.println("║  7. Salir                    ║");
        System.out.println("╚══════════════════════════════╝");
        System.out.print("Selecciona una opción: ");
        System.out.flush();

        try {
            String entrada = lector.readLine();
            if (entrada == null) return 0;
            return Integer.parseInt(entrada.trim());
        } catch (IOException | NumberFormatException e) {
            return -1;
        }
    }

    public void mostrarLista(String titulo, List<String> items) {
        System.out.println("\n--- " + titulo + " (" + items.size() + ") ---");
        if (items.isEmpty()) {
            System.out.println("  No hay registros aún.");
        } else {
            for (int i = 0; i < items.size(); i++) {
                System.out.printf("  %d. %s%n", i + 1, items.get(i));
            }
        }
        System.out.println("--------------------------------------");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarOpcionInvalida() {
        System.out.println("[Error] Opción inválida. Intenta nuevamente.");
    }

    public void mostrarDespedida() {
        System.out.println("\nCerrando TiendaCarro. ¡Hasta luego!");
    }
}
