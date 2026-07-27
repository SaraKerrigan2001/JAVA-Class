package tiendacarro.Modelo;

public class CarroModelo {

    private String marca = "";
    private String color = "";
    private String puestos = "";

    public CarroModelo(String marca, String color, String numPuestos) {
        this.marca = marca;
        this.color = color;
        this.puestos = numPuestos;
    }

    public String getMarca() {
        return marca;
    }

    public String getColor() {
        return color;
    }

    public String getPuestos() {
        return puestos;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPuestos(String puestos) {
        this.puestos = puestos;
    }

    public boolean validar() {
        return validarMensaje() == null;
    }

    public String validarMensaje() {
        if (!ValidacionesModelo.esSoloLetras(marca)) {
            return "Marca inválida: solo se permiten letras.";
        }
        if (!ValidacionesModelo.esTexto(color)) {
            return "Color inválido: no puede estar vacío.";
        }
        if (!ValidacionesModelo.esSoloNumeros(puestos)) {
            return "Puestos inválidos: solo se permiten números.";
        }
        if (Integer.parseInt(puestos) <= 0) {
            return "Puestos inválidos: debe ser mayor que cero.";
        }
        return null;
    }

    public String toString() {
        return "Marca: " + marca + " | Color: " + color + " | Puestos: " + puestos;
    }
}
