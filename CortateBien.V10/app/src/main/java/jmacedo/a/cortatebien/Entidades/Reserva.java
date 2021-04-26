package jmacedo.a.cortatebien.Entidades;

public class Reserva {

    private int idReserva;
    private String usuarioR;
    private String empresaR;
    private String direccionR;
    private String distritoR;
    private String servicioR;
    private String descripcionR;
    private int precioR;
    private String fecha;
    private String hora;
    private int idServicio;
    private int idEmpresa;
    private int idUsuario;
    private String imagenReservaServicio;

    public Reserva() {
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getUsuarioR() {
        return usuarioR;
    }

    public void setUsuarioR(String usuarioR) {
        this.usuarioR = usuarioR;
    }

    public String getEmpresaR() {
        return empresaR;
    }

    public void setEmpresaR(String empresaR) {
        this.empresaR = empresaR;
    }

    public String getDescripcionR() {
        return descripcionR;
    }

    public void setDescripcionR(String descripcionR) {
        this.descripcionR = descripcionR;
    }

    public int getPrecioR() {
        return precioR;
    }

    public void setPrecioR(int precioR) {
        this.precioR = precioR;
    }

    public String getServicioR() {
        return servicioR;
    }

    public void setServicioR(String servicioR) {
        this.servicioR = servicioR;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public String getDireccionR() {
        return direccionR;
    }

    public void setDireccionR(String direccionR) {
        this.direccionR = direccionR;
    }

    public String getDistritoR() {
        return distritoR;
    }

    public void setDistritoR(String distritoR) {
        this.distritoR = distritoR;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getImagenReservaServicio() {
        return imagenReservaServicio;
    }

    public void setImagenReservaServicio(String imagenReservaServicio) {
        this.imagenReservaServicio = imagenReservaServicio;
    }
}
