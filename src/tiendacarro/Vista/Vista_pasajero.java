package tiendacarro.Vista;

import java.util.Scanner;
import tiendacarro.Modelo.Validaciones_modelo;

public class Vista_pasajero {
    private final Scanner teclado = new Scanner(System.in);

    public String tomar_nombre() {
        System.out.print("Ingresa el nombre del pasajero: ");
        return teclado.nextLine().trim();
    }

    public String tomar_cedula() {
        return Validaciones_modelo.leerCedula(teclado, "Ingresa la cedula del pasajero: ");
    }

    public void registrar_pasajero() {
        System.out.println("Pasajero registrado: " + tomar_nombre() + " | " + tomar_cedula());
    }
}
