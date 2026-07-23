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

    public String toString() {
        return "marca: " + marca + "color: " + color + "Puestos: " + puestos;
    }

}
