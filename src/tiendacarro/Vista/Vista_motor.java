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
        System.out.println("Marcas de motor disponibles:");
        System.out.println("1. Toyota");
        System.out.println("2. Renault");
        System.out.println("3. Chevrolet");
        System.out.println("4. Volkswagen");
        System.out.println("5. Suzuki");
        System.out.println("6. Hyundai / Kia");
        System.out.println("7. BMW");
        System.out.println("8. Mercedes-Benz");
        System.out.println("9. Audi");

        while (true) {
            System.out.print("Selecciona la marca del motor (1-9): ");
            String opcion = teclado.nextLine().trim();

            switch (opcion) {
                case "1":
                    return "Toyota";
                case "2":
                    return "Renault";
                case "3":
                    return "Chevrolet";
                case "4":
                    return "Volkswagen";
                case "5":
                    return "Suzuki";
                case "6":
                    return "Hyundai / Kia";
                case "7":
                    return "BMW";
                case "8":
                    return "Mercedes-Benz";
                case "9":
                    return "Audi";
                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
            }
        }
    }

    public String tomar_cilindraje() {
        System.out.println("Guía de cilindrajes comunes por marca:");
        System.out.println("Toyota / Chevrolet / Renault: 1000 cc (1.0L) - 4000 cc");
        System.out.println("Volkswagen / Suzuki / Hyundai / Kia: 1000 cc y 2000 cc");
        System.out.println("BMW / Mercedes-Benz / Audi: 1500 cc y 3000 cc");
        System.out.print("Ingresa el cilindraje del motor: ");
        return teclado.nextLine().trim();
    }

    public void registrar_motor() {
        System.out.println("Motor registrado: " + tomar_tipo_motor() + " | " + tomar_marca_motor());
    }
}
