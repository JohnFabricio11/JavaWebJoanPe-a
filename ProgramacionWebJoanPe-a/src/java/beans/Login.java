/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Modelos.Roles;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author usuario
 */
@Named(value = "login")
@RequestScoped
public class Login implements Serializable{
    
    //1:Admin 2:Estudiante  3:Docente
    
    private List <Roles> rol;
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
    public Login(){
        rol =new ArrayList<>();
        rol.add(new Roles("Joan","1234",1));
        rol.add(new Roles("Alexis","123",2));
        rol.add(new Roles("Cristian","12345",3));
        rol.add(new Roles("Cesar","12",1));
        rol.add(new Roles("Steven","123456",2));
        rol.add(new Roles("Guillermo","0124",3));
        rol.add(new Roles("Dario","0123",1));
        rol.add(new Roles("Yefferson","01234",3));
    }
    public String add() {
        String url=null;
        FacesMessage message;
        for (Roles roles : rol) {
            if(usuario.equals(roles.getNombre()) && contrasena.equals(roles.getPassword())){
                HttpSession sesion=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                sesion.setAttribute("JOAN", roles);
                if(roles.getRol()==1){
                    url="Administrador.xhtml?faces-redirect=true";
                }else if(roles.getRol()==2){
                    url="Libros.xhtml?faces-redirect=true";
                }else if(roles.getRol()==3){
                    url="Prestamos.xhtml?faces-redirect=true";
                }
            }else{
                System.out.println("No se Encuentra Registrado");
                 //message = new FacesMessage(FacesMessage.SEVERITY_INFO, "No se encuentra Reg","");
            }
        }
           
      return url;  
    }
    
}
