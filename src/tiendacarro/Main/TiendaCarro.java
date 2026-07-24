package tiendacarro.Main;

import tiendacarro.Controlador.general_controller;
import tiendacarro.Vista.Vista_carro;
import tiendacarro.Vista.Vista_chofer;
import tiendacarro.Vista.Vista_motor;
import tiendacarro.Vista.Vista_pasajero;

public class TiendaCarro {
    public static void main(String[] args) {
        Vista_chofer vistaChofer = new Vista_chofer();
        Vista_carro vistaCarro = new Vista_carro();
        Vista_motor vistaMotor = new Vista_motor();
        Vista_pasajero vistaPasajero = new Vista_pasajero();

        general_controller controller = new general_controller(vistaChofer, vistaCarro, vistaMotor, vistaPasajero);
        controller.procesar_datos();
    }
}
