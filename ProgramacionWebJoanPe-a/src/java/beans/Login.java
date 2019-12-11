/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

/**
 *
 * @author usuario
 */
@Named(value = "login")
@RequestScoped
public class Login implements Serializable{

    private String usuario;
    private String contrasena;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public void addMessage() {
        FacesMessage message;
        boolean login =false;
        if(usuario.equals("Joan") && contrasena.equals("1234")){
            login=true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", usuario);        
        }else{
            login=false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Datos Incorrectos","");  
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        PrimeFaces.current().ajax().addCallbackParam("login", login);
        
    }
}

