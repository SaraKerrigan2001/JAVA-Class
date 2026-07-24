package tiendacarro.Vista;

import java.util.Scanner;
import tiendacarro.Modelo.Validaciones_modelo;

public class Vista_chofer {
    private final Scanner teclado = new Scanner(System.in);

    public String tomar_nombre() {
        System.out.print("Ingrese el nombre del chofer: ");
        return teclado.nextLine().trim();
    }

    public String tomar_lincencia() {
        return Validaciones_modelo.leerLicencia(teclado, "Ingrese la licencia del chofer: ");
    }

    public String tomar_cedula() {
        return Validaciones_modelo.leerCedula(teclado, "Ingrese la cedula del chofer: ");
    }

    public void registrar_chofer() {
        String nombre = tomar_nombre();
        String licencia = tomar_lincencia();
        String cedula = tomar_cedula();
        System.out.println("Chofer registrado: " + nombre + " | " + licencia + " | " + cedula);
    }
}
