package tiendacarro.Vista;

import java.util.Scanner;

public class Vista_carro {
    private final Scanner teclado = new Scanner(System.in);

    public String tomar_marca() {
        System.out.println("Marcas de carro disponibles:");
        System.out.println("1. Toyota");
        System.out.println("2. Renault");
        System.out.println("3. Chevrolet");
        System.out.println("4. Volkswagen");
        System.out.println("5. Suzuki");
        System.out.println("6. Hyundai / Kia");
        System.out.println("7. BMW");
        System.out.println("8. Mercedes-Benz");
        System.out.println("9. Audi");
        System.out.println("10. Otros");

        while (true) {
            System.out.print("Selecciona la marca del carro (1-9): ");
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
                case "10":
                    return "Otros";    
                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
            }
        }
    }

    public String tomar_color() {
        System.out.print("Ingresa el color del carro: ");
        return teclado.nextLine().trim();
    }

    public String tomar_num_puestos() {
        System.out.print("Ingresa el número de puestos del carro: ");
        return teclado.nextLine().trim();
    }

    public void mostrarCarro(String marca, String color, String puestos) {
        System.out.println("Carro registrado: " + marca + " | " + color + " | " + puestos);
    }
}