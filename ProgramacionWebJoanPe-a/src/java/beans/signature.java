/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author usuario
 */
@Named
@RequestScoped
public class signature {
     
    private String value;
 
    public String getValue() {
        return value;
    }
 
    public void setValue(String value) {
        this.value = value;
    }
}