package es.baseproject.back.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.text.MessageFormat;
import java.util.ResourceBundle;

public class MessageUtil {

    public static void addInfoMessage(String str) {
            FacesContext context = FacesContext.getCurrentInstance();
            ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
            String message = bundle.getString(str);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, ""));
    }

    public static void addInfoMessage(String summary, String detail) {
            FacesContext context = FacesContext.getCurrentInstance();
            //ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
            //String message = bundle.getString(summary);
            //context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, detail));
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "archivo subido", detail));
    }

    public static void addInfoMessage(String str, Object... args) {
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
        String message = bundle.getString(str);
        if (args != null) {
            message = MessageFormat.format(message, args);
        }
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, ""));
    }

    public static void addInfoMessageWithoutKey(String summary, String detail) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail));
    }
}

