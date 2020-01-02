package Utilidades;

public class Roles {

    String nombre, password;

    int rol;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public Roles(String nombre, String password, int rol) {
        this.nombre = nombre;
        this.password = password;
        this.rol = rol;
    }

    

}
