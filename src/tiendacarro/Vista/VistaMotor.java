package tiendacarro.Vista;

import java.io.BufferedReader;
import java.io.IOException;

public class VistaMotor {
    private final BufferedReader lector;

    public VistaMotor(BufferedReader lector) {
        this.lector = lector;
    }

    public String tomarTipoMotor() {
        System.out.println("Tipos de motor disponibles:");
        System.out.println("1. Gasolina");
        System.out.println("2. Diesel");
        System.out.println("3. Hibrido");
        System.out.println("4. Electrico");
        System.out.println("5. Gas Natural");

        while (true) {
            String opcion = leer("Selecciona el tipo de motor (1-5): ");
            switch (opcion) {
                case "1": return "Gasolina";
                case "2": return "Diesel";
                case "3": return "Hibrido";
                case "4": return "Electrico";
                case "5": return "Gas Natural";
                default: System.out.println("Opción inválida. Intenta nuevamente.");
            }
        }
    }

    public String tomarMarcaMotor() {
        return leer("Ingresa la marca del motor: ");
    }

    public String tomarCilindraje(String marcaCarro) {

        switch (marcaCarro) {

            case "Chevrolet":
            case "Renault": {
                System.out.println("Cilindrajes disponibles para " + marcaCarro + ":");
                System.out.println("1. 1000cc (1.0L)");
                System.out.println("2. 2000cc (2.0L)");
                System.out.println("3. 3000cc (3.0L)");
                System.out.println("4. 4000cc (4.0L)");
                while (true) {
                    String op = leer("Selecciona el cilindraje (1-4): ");
                    switch (op) {
                        case "1": return "1000";
                        case "2": return "2000";
                        case "3": return "3000";
                        case "4": return "4000";
                        default: System.out.println("Opción inválida. Intenta nuevamente.");
                    }
                }
            }

            case "Volkswagen":
            case "Suzuki":
            case "Hyundai / Kia": {
                System.out.println("Cilindrajes disponibles para " + marcaCarro + ":");
                System.out.println("1. 1000cc (1.0L)");
                System.out.println("2. 2000cc (2.0L)");
                while (true) {
                    String op = leer("Selecciona el cilindraje (1-2): ");
                    switch (op) {
                        case "1": return "1000";
                        case "2": return "2000";
                        default: System.out.println("Opción inválida. Intenta nuevamente.");
                    }
                }
            }

            case "BMW":
            case "Mercedes-Benz":
            case "Audi": {
                System.out.println("Cilindrajes disponibles para " + marcaCarro + ":");
                System.out.println("1. 1500cc (1.5L)");
                System.out.println("2. 3000cc (3.0L)");
                while (true) {
                    String op = leer("Selecciona el cilindraje (1-2): ");
                    switch (op) {
                        case "1": return "1500";
                        case "2": return "3000";
                        default: System.out.println("Opción inválida. Intenta nuevamente.");
                    }
                }
            }

            default:
                return leer("Ingresa el cilindraje del motor (cc): ");
        }
    }

    public void mostrarMotor(int cilindraje, String tipoMotor, String marcaMotor) {
        System.out.println("Motor registrado: " + cilindraje + "cc | " + tipoMotor + " | " + marcaMotor);
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
