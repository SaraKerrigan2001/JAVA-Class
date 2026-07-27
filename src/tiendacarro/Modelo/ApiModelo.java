package tiendacarro.Modelo;

public class ApiModelo {
    private String url = "";
    private String usuario = "";
    private String clave = "";

    public ApiModelo(String url, String usuario, String clave) {
        this.url = url;
        this.usuario = usuario;
        this.clave = clave;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRoot() {
        return usuario;
    }

    public void setRoot(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean validar() {
        return validarMensaje() == null;
    }

    public String validarMensaje() {
        if (!ValidacionesModelo.esTexto(url)) {
            return "URL de la API inválida: no puede estar vacía.";
        }
        if (!ValidacionesModelo.esTexto(usuario)) {
            return "Usuario de la API inválido: no puede estar vacío.";
        }
        if (!ValidacionesModelo.esTexto(clave)) {
            return "Clave de la API inválida: no puede estar vacía.";
        }
        return null;
    }

    public void desconexion() {
        System.out.println("Desconexión realizada.");
    }

    public void buscarChofer(String cedula) {
        System.out.println("Buscando chofer con cédula: " + cedula);
    }

    public String toString() {
        return "API URL: " + url + " | Usuario: " + usuario;
    }
}
