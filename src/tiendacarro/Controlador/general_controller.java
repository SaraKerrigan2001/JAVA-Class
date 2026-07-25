package tiendacarro.Controlador;

import tiendacarro.Modelo.Validaciones_modelo;
import tiendacarro.Modelo.carro_modelo;
import tiendacarro.Modelo.chofer_modelo;
import tiendacarro.Modelo.motor_modelo;
import tiendacarro.Modelo.Pasajero_modelo;
import tiendacarro.Vista.Vista_carro;
import tiendacarro.Vista.Vista_chofer;
import tiendacarro.Vista.Vista_motor;
import tiendacarro.Vista.Vista_pasajero;

public class general_controller {
    private final Vista_chofer vistaChofer;
    private final Vista_carro vistaCarro;
    private final Vista_motor vistaMotor;
    private final Vista_pasajero vistaPasajero;

    public general_controller(Vista_chofer vistaChofer, Vista_carro vistaCarro, Vista_motor vistaMotor, Vista_pasajero vistaPasajero) {
        this.vistaChofer = vistaChofer;
        this.vistaCarro = vistaCarro;
        this.vistaMotor = vistaMotor;
        this.vistaPasajero = vistaPasajero;
    }

    public void procesar_datos() {
        procesarChofer();
        procesarCarro();
        procesarMotor();
        procesarPasajero();
    }

    private void procesarChofer() {
        String nombre = vistaChofer.tomar_nombre();
        String licencia = vistaChofer.tomar_lincencia();
        String cedula = vistaChofer.tomar_cedula();

        chofer_modelo obj_chofer = new chofer_modelo(nombre, licencia, cedula);
        String errorChofer = obj_chofer.validarMensaje();
        imprimirResultado("Chofer", errorChofer, () -> vistaChofer.mostrarChofer(nombre, licencia, cedula));
    }

    private void procesarCarro() {
        String marca = vistaCarro.tomar_marca();
        String color = vistaCarro.tomar_color();
        String puestos = vistaCarro.tomar_num_puestos();

        String errorValidacion = validarEntero(puestos, "número de puestos");
        if (errorValidacion != null) {
            imprimirResultado("Carro", errorValidacion, () -> {});
            return;
        }

        carro_modelo obj_carro = new carro_modelo(marca, color, puestos);
        String errorCarro = obj_carro.validarMensaje();
        imprimirResultado("Carro", errorCarro, () -> vistaCarro.mostrarCarro(marca, color, puestos));
    }

    private void procesarMotor() {
        String tipoMotor = vistaMotor.tomar_tipo_motor();
        String marcaMotor = vistaMotor.tomar_marca_motor();
        String cilindrajeTexto = vistaMotor.tomar_cilindraje(tipoMotor);

        String errorValidacion = validarEntero(cilindrajeTexto, "cilindraje");
        if (errorValidacion != null) {
            imprimirResultado("Motor", errorValidacion, () -> {});
            return;
        }

        int cilindraje = Integer.parseInt(cilindrajeTexto);
        motor_modelo obj_motor = new motor_modelo(cilindraje, tipoMotor, marcaMotor);
        String errorMotor = obj_motor.validarMensaje();
        imprimirResultado("Motor", errorMotor, () -> vistaMotor.mostrarMotor(cilindraje, tipoMotor, marcaMotor));
    }

    private void procesarPasajero() {
        String nombre = vistaPasajero.tomar_nombre();
        String cedula = vistaPasajero.tomar_cedula();

        Pasajero_modelo obj_pasajero = new Pasajero_modelo(nombre, cedula);
        String errorPasajero = obj_pasajero.validarMensaje();
        imprimirResultado("Pasajero", errorPasajero, () -> vistaPasajero.mostrarPasajero(nombre, cedula));
    }

    private void imprimirResultado(String tipo, String error, Runnable mostrarExito) {
        if (error == null) {
            System.out.println(tipo + " válido.");
            mostrarExito.run();
        } else {
            System.out.println(tipo + " inválido: " + error);
        }
    }

    private String validarEntero(String texto, String campo) {
        if (!Validaciones_modelo.esSoloNumeros(texto)) {
            return "El " + campo + " debe ser un valor numérico.";
        }
        return null;
    }
}
