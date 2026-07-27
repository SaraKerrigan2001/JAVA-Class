package tiendacarro.Modelo;

public class ValidacionesModelo {

    private static final String LETRAS   = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$";
    private static final String NUMEROS  = "^[0-9]+$";
    private static final String CEDULA   = "^[0-9]{6,10}$";
    private static final String LICENCIA = "^[0-9]{6,10}$";


    public static boolean esTexto(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    public static boolean esSoloLetras(String texto) {
        return esTexto(texto) && texto.trim().matches(LETRAS);
    }

    public static boolean esSoloNumeros(String texto) {
        return esTexto(texto) && texto.trim().matches(NUMEROS);
    }

    public static boolean esCedulaValida(String cedula) {
        return esTexto(cedula) && cedula.trim().matches(CEDULA);
    }

    public static boolean esLicenciaValida(String licencia) {
        return esTexto(licencia) && licencia.trim().matches(LICENCIA);
    }


    public static boolean validarChofer(ChoferModelo chofer) {
        return chofer != null && chofer.validar();
    }

    public static String validarChoferMensaje(ChoferModelo chofer) {
        if (chofer == null) return "El chofer no puede ser nulo.";
        return chofer.validarMensaje();
    }

    public static boolean validarCarro(CarroModelo carro) {
        return carro != null && carro.validar();
    }

    public static String validarCarroMensaje(CarroModelo carro) {
        if (carro == null) return "El carro no puede ser nulo.";
        return carro.validarMensaje();
    }

    public static boolean validarMotor(MotorModelo motor) {
        return motor != null && motor.validar();
    }

    public static String validarMotorMensaje(MotorModelo motor) {
        if (motor == null) return "El motor no puede ser nulo.";
        return motor.validarMensaje();
    }

    public static boolean validarPasajero(PasajeroModelo pasajero) {
        return pasajero != null && pasajero.validar();
    }

    public static String validarPasajeroMensaje(PasajeroModelo pasajero) {
        if (pasajero == null) return "El pasajero no puede ser nulo.";
        return pasajero.validarMensaje();
    }

    public static boolean validarApi(ApiModelo api) {
        return api != null
                && esTexto(api.getClave())
                && esTexto(api.getRoot())
                && esTexto(api.getUrl());
    }
}
