package tiendacarro.Vista;

import java.util.Scanner;

public class Vista_carro {
    private final Scanner teclado = new Scanner(System.in);

    public String tomar_marca() {
        System.out.print("Ingresa la marca del carro: ");
        return teclado.nextLine().trim();
    }

    public String tomar_color() {
        System.out.print("Ingresa el color del carro: ");
        return teclado.nextLine().trim();
    }

    public String tomar_num_puestos() {
        System.out.print("Ingresa el número de puestos del carro: ");
        return teclado.nextLine().trim();
    }

    public void registrar_carro() {
        System.out.println("Carro registrado: " + tomar_marca() + " | " + tomar_color() + " | " + tomar_num_puestos());
    }
}