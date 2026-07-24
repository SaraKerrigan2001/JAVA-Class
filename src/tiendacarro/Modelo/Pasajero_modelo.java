package tiendacarro.Modelo;

public class Pasajero_modelo {
    String nombre = "";
    String cedula = "";
    
   public Pasajero_modelo(String nombre, String cedula) {
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
        if (!Validaciones_modelo.esSoloLetras(nombre)) {
            return "Nombre de pasajero inválido: solo se permiten letras.";
        }
        if (!Validaciones_modelo.esCedulaValida(cedula)) {
            return "Cédula de pasajero inválida: debe tener entre 6 y 10 dígitos.";
        }
        return null;
    }

    public String toString() {
        return "nombre: " + nombre + " cedula: " + cedula;
    }

}

