package tiendacarro.Vista;

import java.util.Scanner;

public class Vista_chofer {
    private final Scanner teclado = new Scanner(System.in);

    public String tomar_nombre() {
        System.out.print("Ingrese el nombre del chofer: ");
        return teclado.nextLine().trim();
    }

    public String tomar_lincencia() {
        System.out.print("Ingrese la lincencia del chofer: ");
        return teclado.nextLine().trim();
    }

    public String tomar_cedula() {
        System.out.print("Ingrese la cedula del chofer: ");
        return teclado.nextLine().trim();
    }

    public void registrar_chofer() {
        String nombre = tomar_nombre();
        String licencia = tomar_lincencia();
        String cedula = tomar_cedula();
        System.out.println("Chofer registrado: " + nombre + " | " + licencia + " | " + cedula);
    }
}
