package jmacedo.a.cortatebien.Entidades;

public class Servicios {

    private int idServicio;
    private String nombreServicio;
    private String descripcionServicio;
    private int precio;
    private String urlImagenServicio;


    public Servicios() {
    }

    public Servicios(String nombreServicio,String descripcionServicio) {
        this.nombreServicio = nombreServicio;
        this.descripcionServicio = descripcionServicio;

    }


    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getUrlImagenServicio() {
        return urlImagenServicio;
    }

    public void setUrlImagenServicio(String urlImagenServicio) {
        this.urlImagenServicio = urlImagenServicio;
    }
}
