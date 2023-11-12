package clinica.mensagem;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


/**
 *
 * @author F70Ed
 */
public class Mensagem {

    public static void msm(String mensagem) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", mensagem));
    }

   
}
