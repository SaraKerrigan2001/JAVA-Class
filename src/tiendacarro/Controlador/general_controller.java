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
        String errorChofer = Validaciones_modelo.validarChoferMensaje(obj_chofer);

        if (errorChofer == null) {
            System.out.println("Chofer válido.");
        } else {
            System.out.println("Chofer inválido: " + errorChofer);
        }
    }

    private void procesarCarro() {
        String marca = vistaCarro.tomar_marca();
        String color = vistaCarro.tomar_color();
        String puestos = vistaCarro.tomar_num_puestos();

        carro_modelo obj_carro = new carro_modelo(marca, color, puestos);
        String errorCarro = Validaciones_modelo.validarCarroMensaje(obj_carro);

        if (errorCarro == null) {
            System.out.println("Carro válido.");
        } else {
            System.out.println("Carro inválido: " + errorCarro);
        }
    }

    private void procesarMotor() {
        String tipoMotor = vistaMotor.tomar_tipo_motor();
        String marcaMotor = vistaMotor.tomar_marca_motor();
        int cilindraje = 0;
        String cilindrajeTexto = vistaMotor.tomar_cilindraje();

        try {
            cilindraje = Integer.parseInt(cilindrajeTexto);
        } catch (NumberFormatException e) {
            System.out.println("Motor inválido: el cilindraje debe ser un número entero.");
            return;
        }

        motor_modelo obj_motor = new motor_modelo(cilindraje, tipoMotor, marcaMotor);
        String errorMotor = Validaciones_modelo.validarMotorMensaje(obj_motor);

        if (errorMotor == null) {
            System.out.println("Motor válido.");
        } else {
            System.out.println("Motor inválido: " + errorMotor);
        }
    }

    private void procesarPasajero() {
        String nombre = vistaPasajero.tomar_nombre();
        String cedula = vistaPasajero.tomar_cedula();

        Pasajero_modelo obj_pasajero = new Pasajero_modelo(nombre, cedula);
        String errorPasajero = Validaciones_modelo.validarPasajeroMensaje(obj_pasajero);

        if (errorPasajero == null) {
            System.out.println("Pasajero válido.");
        } else {
            System.out.println("Pasajero inválido: " + errorPasajero);
        }
    }
}
