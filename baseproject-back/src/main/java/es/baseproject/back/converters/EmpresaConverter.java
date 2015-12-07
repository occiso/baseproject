package es.baseproject.back.converters;

import es.baseproject.ejb.service.EmpresaInterface;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import es.baseproject.ejb.entities.Empresa;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * En los converters no utilizamos @facesConverter porque no permite inyectar EJB. Soluciones:
 * 1. Declararla como ManagedBean
 * 2. Obtener el EJB a través del método lookup en el constructor de la clase
 */

//@FacesConverter(value = "empresaConverter" ) //no porque no puedes inyectar EJB indicar como managedBean
@ManagedBean
@RequestScoped
public class EmpresaConverter implements Converter{

    @EJB(name = "es.jose.service.EmpresaService")
    private EmpresaInterface empresaInterface;
    
    //De xhtml a controller
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String s) {
        System.out.println("EmpresaConverter.getAsObject()");
        return empresaInterface.findById( Long.valueOf(s));
    }

    //de  controller a xhtml
    //Implementar siempre de la misma manera 
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
     System.out.println("EmpresaConverter.getAsString()");  
     if (o==null || o.equals("")){
         return null;
     }         
     if (o instanceof Long){
         return o.toString();
     } if (o instanceof Empresa){
         return ((Empresa)o).getNombre();
     }else {
         throw new ConverterException("error de conversión");
     }
     
    }
}