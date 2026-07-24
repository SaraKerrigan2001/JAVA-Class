package tiendacarro.Modelo;

import java.util.Scanner;

public class Validaciones_modelo {

    private static final String LETRAS = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$";
    private static final String NUMEROS = "^[0-9]+$";
    private static final String CEDULA = "^[0-9]{6,10}$";

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
        return esTexto(licencia) && licencia.trim().length() >= 3;
    }

    public static boolean validarChofer(chofer_modelo chofer) {
        return chofer != null
                && esSoloLetras(chofer.getNombre_chofer())
                && esCedulaValida(chofer.getCedula_chofer())
                && esLicenciaValida(chofer.getLincencia_chofer());
    }

    public static boolean validarCarro(carro_modelo carro) {
        return carro != null
                && esSoloLetras(carro.getMarca())
                && esTexto(carro.getColor())
                && esSoloNumeros(carro.getPuestos());
    }

    public static boolean validarMotor(motor_modelo motor) {
        return motor != null
                && motor.getCilindraje() > 0
                && esTexto(motor.getTipo_motor())
                && esTexto(motor.getMarca_motor());
    }

    public static boolean validarPasajero(Pasajero_modelo pasajero) {
        return pasajero != null
                && esSoloLetras(pasajero.getNombre())
                && esCedulaValida(pasajero.getCedula());
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
