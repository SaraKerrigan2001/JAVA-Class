package tiendacarro.Modelo;

public class carro_modelo {

    String marca = "";
    String color = "";
    String puestos = "";
    
    
    public carro_modelo(String marca, String color, String num_puestos) {
        this.marca = marca;
        this.color = color;
        this.puestos = num_puestos;
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
        if (!Validaciones_modelo.esSoloLetras(marca)) {
            return "Marca inválida: solo se permiten letras.";
        }
        if (!Validaciones_modelo.esTexto(color)) {
            return "Color inválido: no puede estar vacío.";
        }
        if (!Validaciones_modelo.esSoloNumeros(puestos)) {
            return "Puestos inválidos: solo se permiten números.";
        }
        if (Integer.parseInt(puestos) <= 0) {
            return "Puestos inválidos: debe ser mayor que cero.";
        }
        return null;
    }

    public String toString() {
        return "marca: " + marca + " color: " + color + " Puestos: " + puestos;
    }

}
