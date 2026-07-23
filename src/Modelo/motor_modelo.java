package tiendacarro.Modelo;

public class motor_modelo {
    private int cilindraje = 0;
    private String tipo_motor = "";
    private String marca_motor = "";

    // Constructor
    public motor_modelo(int cilindraje, String tipo_motor, String marca_motor) {
        this.cilindraje = cilindraje;
        this.tipo_motor = tipo_motor;
        this.marca_motor = marca_motor;
    }

    // Getters

    public int getCilindraje() {
        return cilindraje;
    }

    public String getTipo_motor() {
        return tipo_motor;
    }

    public String getMarca_motor() {
        return marca_motor;
    }

    // Setters

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public void setTipo_motor(String tipo_motor) {
        this.tipo_motor = tipo_motor;
    }

    public void setMarca_motor(String marca_motor) {
        this.marca_motor = marca_motor;
    }

    public String toString() {
        return "Cilindraje: " + cilindraje + " tipo_motor: " + tipo_motor + "Marca_motor: " + marca_motor;
    }

}
