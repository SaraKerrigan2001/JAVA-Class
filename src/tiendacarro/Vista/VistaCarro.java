package tiendacarro.Vista;

import java.io.BufferedReader;
import java.io.IOException;

public class VistaCarro {
    private final BufferedReader lector;

    public VistaCarro(BufferedReader lector) {
        this.lector = lector;
    }

    public String tomarMarca() {
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
            String opcion = leer("Selecciona la marca del carro (1-10): ");
            switch (opcion) {
                case "1": return "Toyota";
                case "2": return "Renault";
                case "3": return "Chevrolet";
                case "4": return "Volkswagen";
                case "5": return "Suzuki";
                case "6": return "Hyundai / Kia";
                case "7": return "BMW";
                case "8": return "Mercedes-Benz";
                case "9": return "Audi";
                case "10": return "Otros";
                default: System.out.println("Opción inválida. Intenta nuevamente.");
            }
        }
    }

    public String tomarColor() {
        return leer("Ingresa el color del carro: ");
    }

    public String tomarNumPuestos() {
        return leer("Ingresa el número de puestos del carro: ");
    }

    public void mostrarCarro(String marca, String color, String puestos) {
        System.out.println("Carro registrado: " + marca + " | " + color + " | " + puestos);
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
