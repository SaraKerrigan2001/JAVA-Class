package tiendacarro.Main;

import tiendacarro.Controlador.general_controller;
import tiendacarro.Vista.Vista_chofer;

public class TiendaCarro {
    public static void main(String[] args) {
        Vista_chofer vista = new Vista_chofer();
        general_controller controller = new general_controller(vista);
        controller.procesar_datos();
    }
}
