package tiendacarro.Vista;

import java.util.Scanner;

public class Vista_pasajero {
    private final Scanner teclado = new Scanner(System.in);

    public String tomar_nombre() {
        System.out.print("Ingresa el nombre del pasajero: ");
        return teclado.nextLine().trim();
    }

    public String tomar_cedula() {
        System.out.print("Ingresa la cedula del pasajero: ");
        return teclado.nextLine().trim();
    }

    public void mostrarPasajero(String nombre, String cedula) {
        System.out.println("Pasajero registrado: " + nombre + " | " + cedula);
    }
}
