package tiendacarro.Controlador;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import tiendacarro.Modelo.CarroModelo;
import tiendacarro.Modelo.ChoferModelo;
import tiendacarro.Modelo.MotorModelo;
import tiendacarro.Modelo.PasajeroModelo;
import tiendacarro.Servicio.RegistroServicio;
import tiendacarro.Vista.VistaCarro;
import tiendacarro.Vista.VistaChofer;
import tiendacarro.Vista.VistaMenu;
import tiendacarro.Vista.VistaMotor;
import tiendacarro.Vista.VistaPasajero;

public class GeneralController {

    private final VistaChofer     vistaChofer;
    private final VistaCarro      vistaCarro;
    private final VistaMotor      vistaMotor;
    private final VistaPasajero   vistaPasajero;
    private final VistaMenu       vistaMenu;
    private final RegistroServicio registro;

    public GeneralController() {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        this.vistaChofer   = new VistaChofer(lector);
        this.vistaCarro    = new VistaCarro(lector);
        this.vistaMotor    = new VistaMotor(lector);
        this.vistaPasajero = new VistaPasajero(lector);
        this.vistaMenu     = new VistaMenu(lector);
        this.registro      = new RegistroServicio();
    }


    public void iniciar() {
        boolean ejecutando = true;

        while (ejecutando) {
            int opcion = vistaMenu.mostrarMenuPrincipal();

            switch (opcion) {
                case 1:  procesarChofer();                                        break;
                case 2:  procesarPasajero();                                      break;
                case 3:  procesarCarro();                                         break;
                case 4:  procesarMotor();                                         break;
                case 5:  mostrarChoferes();                                       break;
                case 6:  mostrarPasajeros();                                      break;
                case 7:  vistaMenu.mostrarDespedida(); ejecutando = false;        break;
                default: vistaMenu.mostrarOpcionInvalida();
            }
        }
    }


    private void mostrarChoferes() {
        List<String> lineas = new ArrayList<>();
        for (ChoferModelo c : registro.getChoferes()) {
            lineas.add(c.toString());
        }
        vistaMenu.mostrarLista("Choferes registrados", lineas);
    }

    private void mostrarPasajeros() {
        List<String> lineas = new ArrayList<>();
        for (PasajeroModelo p : registro.getPasajeros()) {
            lineas.add(p.toString());
        }
        vistaMenu.mostrarLista("Pasajeros registrados", lineas);
    }


    private void procesarChofer() {
        String nombre   = vistaChofer.tomarNombre();
        String licencia = vistaChofer.tomarLicencia();
        String cedula   = vistaChofer.tomarCedula();

        ChoferModelo chofer = new ChoferModelo(nombre, licencia, cedula);
        String error = chofer.validarMensaje();

        if (error == null) {
            registro.agregarChofer(chofer);
            vistaMenu.mostrarMensaje("Chofer válido. Registrado correctamente.");
            vistaChofer.mostrarChofer(nombre, licencia, cedula);
        } else {
            vistaMenu.mostrarMensaje("Chofer inválido: " + error);
        }
    }

    private void procesarPasajero() {
        String nombre = vistaPasajero.tomarNombre();
        String cedula = vistaPasajero.tomarCedula();

        PasajeroModelo pasajero = new PasajeroModelo(nombre, cedula);
        String error = pasajero.validarMensaje();

        if (error == null) {
            registro.agregarPasajero(pasajero);
            vistaMenu.mostrarMensaje("Pasajero válido. Registrado correctamente.");
            vistaPasajero.mostrarPasajero(nombre, cedula);
        } else {
            vistaMenu.mostrarMensaje("Pasajero inválido: " + error);
        }
    }

    private void procesarCarro() {
        String marca   = vistaCarro.tomarMarca();
        String color   = vistaCarro.tomarColor();
        String puestos = vistaCarro.tomarNumPuestos();

        CarroModelo carro = new CarroModelo(marca, color, puestos);
        String error = carro.validarMensaje();
        imprimirResultado("Carro", error, () -> vistaCarro.mostrarCarro(marca, color, puestos));
    }

    private void procesarMotor() {
        String marcaCarro      = vistaCarro.tomarMarca();
        String tipoMotor       = vistaMotor.tomarTipoMotor();
        String marcaMotor      = vistaMotor.tomarMarcaMotor();
        String cilindrajeTexto = vistaMotor.tomarCilindraje(marcaCarro);

        if (!cilindrajeTexto.matches("^[0-9]+$")) {
            imprimirResultado("Motor", "El cilindraje debe ser un valor numérico.", () -> {});
            return;
        }

        int cilindraje = Integer.parseInt(cilindrajeTexto);
        MotorModelo motor = new MotorModelo(cilindraje, tipoMotor, marcaMotor);
        String error = motor.validarMensaje();
        imprimirResultado("Motor", error, () -> vistaMotor.mostrarMotor(cilindraje, tipoMotor, marcaMotor));
    }


    private void imprimirResultado(String tipo, String error, Runnable mostrarExito) {
        if (error == null) {
            vistaMenu.mostrarMensaje(tipo + " válido.");
            mostrarExito.run();
        } else {
            vistaMenu.mostrarMensaje(tipo + " inválido: " + error);
        }
    }
}
