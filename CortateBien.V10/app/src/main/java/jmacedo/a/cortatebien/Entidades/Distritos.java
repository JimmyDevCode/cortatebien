package jmacedo.a.cortatebien.Entidades;

public class Distritos {

    private int idLocal;
    private int idDistrito;
    private String nombreDistrito;

    public Distritos() {
    }

    public Distritos(int idLocal, int idDistrito, String nombreDistrito) {
        this.idLocal = idLocal;
        this.idDistrito = idDistrito;
        this.nombreDistrito = nombreDistrito;
    }


    public int getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getMombreDistrito() {
        return nombreDistrito;
    }

    public void setMombreDistrito(String mombreDistrito) {
        this.nombreDistrito = mombreDistrito;
    }
}
