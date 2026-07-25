package tiendacarro.Vista;

import java.util.Scanner;

public class Vista_chofer {
    private final Scanner teclado = new Scanner(System.in);

    public String tomar_nombre() {
        System.out.print("Ingrese el nombre del chofer: ");
        return teclado.nextLine().trim();
    }

    public String tomar_lincencia() {
        System.out.print("Ingrese la licencia del chofer: ");
        return teclado.nextLine().trim();
    }

    public String tomar_cedula() {
        System.out.print("Ingrese la cedula del chofer: ");
        return teclado.nextLine().trim();
    }

    public void mostrarChofer(String nombre, String licencia, String cedula) {
        System.out.println("Chofer registrado: " + nombre + " | " + licencia + " | " + cedula);
    }
}
