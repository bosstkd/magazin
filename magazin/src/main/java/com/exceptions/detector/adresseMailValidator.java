package com.exceptions.detector;

import com.facade.beans.UsersFacade;
import com.fonctions.mailValidator;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@ManagedBean
@RequestScoped
public class adresseMailValidator implements Validator {

    private static final String EMAIL_EXISTE_DEJA = "Cette adresse email est déjà utilisée";

    @EJB
    private UsersFacade beanU;

    @Override
    public void validate( FacesContext context, UIComponent component, Object value ) throws ValidatorException {
        /* Récupération de la valeur à traiter depuis le paramètre value */
        String email = (String) value;
        mailValidator mv = new mailValidator();
        if(mv.isValidEmailAddress(email)){
            try {
            if ( beanU.findByMail(email).getMail() != null ) {
                    
                    throw new ValidatorException(
                            new FacesMessage( FacesMessage.SEVERITY_ERROR, EMAIL_EXISTE_DEJA, null ) );
                }
            } catch ( DAOException e ) {
               
                FacesMessage message = new FacesMessage( FacesMessage.SEVERITY_ERROR, e.getMessage(), null );
                FacesContext facesContext = FacesContext.getCurrentInstance();
                facesContext.addMessage( component.getClientId( facesContext ), message );
            }
        }else{
            FacesMessage message = new FacesMessage( FacesMessage.SEVERITY_ERROR, "adresse mail non valide", null );
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage( component.getClientId(facesContext ), message );
        }
        
       
    }
}