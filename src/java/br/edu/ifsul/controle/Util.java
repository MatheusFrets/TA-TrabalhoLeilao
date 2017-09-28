
package br.edu.ifsul.controle;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Util {
    
    
    public static String getMensagemInternacionaliza(String messageID){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String msg = "";
        Locale locale;
        
        if(facesContext != null){
            locale = facesContext.getViewRoot().getLocale();
        }else{
            locale = new Locale("pt","BR");
        }
        
        ResourceBundle bundle = ResourceBundle.getBundle("messages",locale);
        
        try {
            msg = bundle.getString(messageID);
        } catch (Exception e) {
            msg = messageID;
        }
        return msg;
    }
}
