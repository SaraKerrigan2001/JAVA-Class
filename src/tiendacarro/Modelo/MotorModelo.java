package tiendacarro.Modelo;

public class MotorModelo {
    private int cilindraje = 0;
    private String tipoMotor = "";
    private String marcaMotor = "";

    public MotorModelo(int cilindraje, String tipoMotor, String marcaMotor) {
        this.cilindraje = cilindraje;
        this.tipoMotor = tipoMotor;
        this.marcaMotor = marcaMotor;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public String getMarcaMotor() {
        return marcaMotor;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public void setMarcaMotor(String marcaMotor) {
        this.marcaMotor = marcaMotor;
    }

    public boolean validar() {
        return validarMensaje() == null;
    }

    public String validarMensaje() {
        if (cilindraje <= 0) {
            return "Cilindraje inválido: debe ser un número mayor que cero.";
        }
        if (!ValidacionesModelo.esTexto(tipoMotor)) {
            return "Tipo de motor inválido: no puede estar vacío.";
        }
        if (!ValidacionesModelo.esTexto(marcaMotor)) {
            return "Marca de motor inválida: no puede estar vacía.";
        }
        return null;
    }

    public String toString() {
        return "Cilindraje: " + cilindraje + "cc | Tipo: " + tipoMotor + " | Marca: " + marcaMotor;
    }
}
