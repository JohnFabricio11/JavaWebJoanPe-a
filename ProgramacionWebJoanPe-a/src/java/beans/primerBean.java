
package beans;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value = "primerBean")
@ViewScoped
public class primerBean implements Serializable{
    
    private int valor1;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }  
    public int getValor1() {
        return valor1;
    }

    public void setValor1(int valor1) {
        this.valor1 = valor1;
    }
    public primerBean() {
        
    }
    
}
