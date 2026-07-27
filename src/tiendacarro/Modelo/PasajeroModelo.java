package tiendacarro.Modelo;

public class PasajeroModelo {
    private String nombre = "";
    private String cedula = "";

    public PasajeroModelo(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public boolean validar() {
        return validarMensaje() == null;
    }

    public String validarMensaje() {
        if (!ValidacionesModelo.esSoloLetras(nombre)) {
            return "Nombre de pasajero inválido: solo se permiten letras.";
        }
        if (!ValidacionesModelo.esCedulaValida(cedula)) {
            return "Cédula de pasajero inválida: debe tener entre 6 y 10 dígitos.";
        }
        return null;
    }

    public String toString() {
        return "Nombre: " + nombre + " | Cédula: " + cedula;
    }
}
