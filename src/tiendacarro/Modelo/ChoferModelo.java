package tiendacarro.Modelo;

public class ChoferModelo {
    private String nombreChofer = "";
    private String licenciaChofer = "";
    private String cedulaChofer = "";

    public ChoferModelo(String nombre, String licencia, String cedula) {
        this.nombreChofer = nombre;
        this.licenciaChofer = licencia;
        this.cedulaChofer = cedula;
    }

    public String getNombreChofer() {
        return nombreChofer;
    }

    public String getLicenciaChofer() {
        return licenciaChofer;
    }

    public String getCedulaChofer() {
        return cedulaChofer;
    }

    public void setNombreChofer(String nombreChofer) {
        this.nombreChofer = nombreChofer;
    }

    public void setLicenciaChofer(String licenciaChofer) {
        this.licenciaChofer = licenciaChofer;
    }

    public void setCedulaChofer(String cedulaChofer) {
        this.cedulaChofer = cedulaChofer;
    }

    public boolean validar() {
        return validarMensaje() == null;
    }

    public String validarMensaje() {
        if (!ValidacionesModelo.esSoloLetras(nombreChofer)) {
            return "Nombre inválido: solo se permiten letras.";
        }
        if (!ValidacionesModelo.esCedulaValida(cedulaChofer)) {
            return "Cédula inválida: debe tener entre 6 y 10 dígitos.";
        }
        if (!ValidacionesModelo.esLicenciaValida(licenciaChofer)) {
            return "Licencia inválida: debe tener entre 6 y 10 dígitos.";
        }
        return null;
    }

    public String toString() {
        return "Nombre: " + nombreChofer + " | Licencia: " + licenciaChofer + " | Cédula: " + cedulaChofer;
    }
}
