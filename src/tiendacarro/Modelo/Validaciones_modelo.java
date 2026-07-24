package tiendacarro.Modelo;

import java.util.Scanner;

public class Validaciones_modelo {

    private static final String LETRAS = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$";
    private static final String NUMEROS = "^[0-9]+$";
    private static final String CEDULA = "^[0-9]{6,10}$";
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

    public static String leerCedula(Scanner sc, String prompt) {
        return leer(sc, prompt, CEDULA, "Debe tener entre 6 y 10 dígitos.");
    }

    public static String leerLicencia(Scanner sc, String prompt) {
        return leer(sc, prompt, LICENCIA, "Debe tener entre 6 y 10 dígitos.");
    }

    public static boolean validarChofer(chofer_modelo chofer) {
        return validarChoferMensaje(chofer) == null;
    }

    public static String validarChoferMensaje(chofer_modelo chofer) {
        if (chofer == null) {
            return "El chofer no puede ser nulo.";
        }
        if (!esSoloLetras(chofer.getNombre_chofer())) {
            return "Nombre inválido: solo se permiten letras.";
        }
        if (!esCedulaValida(chofer.getCedula_chofer())) {
            return "Cédula inválida: debe tener entre 6 y 10 dígitos.";
        }
        if (!esLicenciaValida(chofer.getLincencia_chofer())) {
            return "Licencia inválida: debe tener entre 6 y 10 dígitos.";
        }
        return null;
    }

    public static boolean validarCarro(carro_modelo carro) {
        return validarCarroMensaje(carro) == null;
    }

    public static String validarCarroMensaje(carro_modelo carro) {
        if (carro == null) {
            return "El carro no puede ser nulo.";
        }
        if (!esSoloLetras(carro.getMarca())) {
            return "Marca inválida: solo se permiten letras.";
        }
        if (!esTexto(carro.getColor())) {
            return "Color inválido: no puede estar vacío.";
        }
        if (!esSoloNumeros(carro.getPuestos())) {
            return "Puestos inválidos: solo se permiten números.";
        }
        return null;
    }

    public static boolean validarMotor(motor_modelo motor) {
        return validarMotorMensaje(motor) == null;
    }

    public static String validarMotorMensaje(motor_modelo motor) {
        if (motor == null) {
            return "El motor no puede ser nulo.";
        }
        if (motor.getCilindraje() <= 0) {
            return "Cilindraje inválido: debe ser un número mayor que cero.";
        }
        if (!esTexto(motor.getTipo_motor())) {
            return "Tipo de motor inválido: no puede estar vacío.";
        }
        if (!esTexto(motor.getMarca_motor())) {
            return "Marca de motor inválida: no puede estar vacía.";
        }
        return null;
    }

    public static boolean validarPasajero(Pasajero_modelo pasajero) {
        return validarPasajeroMensaje(pasajero) == null;
    }

    public static String validarPasajeroMensaje(Pasajero_modelo pasajero) {
        if (pasajero == null) {
            return "El pasajero no puede ser nulo.";
        }
        if (!esSoloLetras(pasajero.getNombre())) {
            return "Nombre de pasajero inválido: solo se permiten letras.";
        }
        if (!esCedulaValida(pasajero.getCedula())) {
            return "Cédula de pasajero inválida: debe tener entre 6 y 10 dígitos.";
        }
        return null;
    }

    public static boolean validarApi(Api_modelo api) {
        return api != null
                && esTexto(api.getClave())
                && esTexto(api.getRoot())
                && esTexto(api.getUrl());
    }

    public static String leer(Scanner sc, String prompt, String regex, String error) {
        while (true) {
            System.out.print(prompt);
            String entrada = sc.nextLine().trim();
            if (!esTexto(entrada)) {
                System.out.println("[Error] El campo no puede estar vacío.");
            } else if (regex != null && !entrada.matches(regex)) {
                System.out.println("[Error] " + error);
            } else {
                return entrada;
            }
        }
    }

    public static String leerTexto(Scanner sc, String prompt) {
        return leer(sc, prompt, null, "");
    }

    public static String leerSoloLetras(Scanner sc, String prompt) {
        return leer(sc, prompt, LETRAS, "Solo se permiten letras.");
    }

    public static String leerSoloNumeros(Scanner sc, String prompt) {
        return leer(sc, prompt, NUMEROS, "Solo se permiten números.");
    }
}
