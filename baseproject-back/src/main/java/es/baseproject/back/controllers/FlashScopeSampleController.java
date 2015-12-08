package es.baseproject.back.controllers;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

@ManagedBean
@ViewScoped
public class FlashScopeSampleController implements Serializable{
    
    public String save(){
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        
        String userName = (String) flash.get("username");
        Number age = (Number) flash.get("age");
        String country = (String) flash.get("country");
        
        System.out.println("recpilacion de datos");
        System.out.println("username: " +  userName);
        System.out.println("age: "+ age.toString());
        System.out.println("country: " +  country);
        System.out.println("proceda a guardar los datos en BBDD. Regresando al index.xhtml");
        
        
        return "index.xhtml?faces-redirect=true";
    }
}
