package jmacedo.a.cortatebien.Entidades;

public class Usuarios {

    private int id_Usuario;
    private String nombre_usuario;
    private String correo;
    private String contraseña;

    public Usuarios() {
    }

    public Usuarios(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
