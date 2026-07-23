package tiendacarro.Controlador;

import tiendacarro.Modelo.Validaciones_modelo;
import tiendacarro.Modelo.chofer_modelo;
import tiendacarro.Vista.Vista_chofer;

public class general_controller {
    private final Vista_chofer vista;

    public general_controller(Vista_chofer vista) {
        this.vista = vista;
    }

    public void procesar_datos() {
        String nombre = vista.tomar_nombre();
        String licencia = vista.tomar_lincencia();
        String cedula = vista.tomar_cedula();

        chofer_modelo obj_chofer = new chofer_modelo(nombre, licencia, cedula);

        if (Validaciones_modelo.validarChofer(obj_chofer)) {
            System.out.println("Chofer válido.");
        } else {
            System.out.println("Chofer inválido.");
        }
    }
}
