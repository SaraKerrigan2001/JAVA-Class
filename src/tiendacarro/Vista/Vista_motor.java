package tiendacarro.Vista;

import java.util.Scanner;

public class Vista_motor {
    private final Scanner teclado = new Scanner(System.in);

    public String tomar_tipo_motor() {
        System.out.println("Tipos de motor disponibles:");
        System.out.println("1. Gasolina");
        System.out.println("2. Diesel");
        System.out.println("3. Hibrido");
        System.out.println("4. Electrico");
        System.out.println("5. Gas Natural");

        while (true) {
            System.out.print("Selecciona el tipo de motor (1-5): ");
            String opcion = teclado.nextLine().trim();

            switch (opcion) {
                case "1":
                    return "Gasolina";
                case "2":
                    return "Diesel";
                case "3":
                    return "Hibrido";
                case "4":
                    return "Electrico";
                case "5":
                    return "Gas Natural";
                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
            }
        }
    }

    public String tomar_marca_motor() {
        System.out.print("Ingresa la marca del motor: ");
        return teclado.nextLine().trim();
    }

    public String tomar_cilindraje(String tipoMotor) {
        if ("Gasolina".equalsIgnoreCase(tipoMotor)) {
            System.out.println("Calibres disponibles para motores de gasolina World Engine:");
            System.out.println("1. 1.8L (1800cc)");
            System.out.println("2. 2.0L (2000cc)");
            System.out.println("3. 2.4L (2400cc)");

            while (true) {
                System.out.print("Selecciona el calibre (1-3): ");
                String opcion = teclado.nextLine().trim();

                switch (opcion) {
                    case "1":
                        return "1800";
                    case "2":
                        return "2000";
                    case "3":
                        return "2400";
                    default:
                        System.out.println("Opción inválida. Intenta nuevamente.");
                }
            }
        }

        System.out.print("Ingresa el cilindraje del motor: ");
        return teclado.nextLine().trim();
    }

    public void mostrarMotor(int cilindraje, String tipoMotor, String marcaMotor) {
        System.out.println("Motor registrado: " + cilindraje + "cc | " + tipoMotor + " | " + marcaMotor);
    }
}
