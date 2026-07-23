package tiendacarro.Vista;

import java.util.Scanner;

public class Vista_motor {
    private final Scanner teclado = new Scanner(System.in);

    public String tomar_tipo_motor() {
        System.out.print("Ingresa el tipo de motor: ");
        return teclado.nextLine().trim();
    }

    public String tomar_marca_motor() {
        System.out.print("Ingresa la marca del motor: ");
        return teclado.nextLine().trim();
    }

    public void registrar_motor() {
        System.out.println("Motor registrado: " + tomar_tipo_motor() + " | " + tomar_marca_motor());
    }
}
