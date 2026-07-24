package tiendacarro.Modelo;

public class chofer_modelo {
    private String nombre_chofer = "";
    private String lincencia_chofer = "";
    private String cedula_chofer = "";

    public chofer_modelo(String dato_nombre, String dato_lincencia, String dato_cedula) {
        this.nombre_chofer = dato_nombre;
        this.lincencia_chofer = dato_lincencia;
        this.cedula_chofer = dato_cedula;
    }

    public String getNombre_chofer() {
        return nombre_chofer;
    }

    public String getLincencia_chofer() {
        return lincencia_chofer;
    }

    public String getCedula_chofer() {
        return cedula_chofer;
    }

    public void setNombre_chofer(String nombre_chofer) {
        this.nombre_chofer = nombre_chofer;
    }

    public void setLincencia_chofer(String lincencia_chofer) {
        this.lincencia_chofer = lincencia_chofer;
    }

    public void setCedula_chofer(String cedula_chofer) {
        this.cedula_chofer = cedula_chofer;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre_chofer + " Lincencia: " + lincencia_chofer + " Cedula: " + cedula_chofer;
    }

    public void imprimir() {
        System.out.println(this.toString());
    }
}
