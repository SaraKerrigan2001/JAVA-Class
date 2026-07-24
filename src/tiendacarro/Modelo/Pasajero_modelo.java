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

    public String toString() {
        return "nombre: " + nombre + "cedula: " + cedula ;
    }

}

