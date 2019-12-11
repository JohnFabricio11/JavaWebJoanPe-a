/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author usuario
 */
@Named(value = "firma")
@RequestScoped
public class Firma implements Serializable{
 private String value;

    public String getValue() {
        System.out.println(value);
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    public Firma() {
    }
    
}
