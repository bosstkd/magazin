/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers.users;

import com.controllers.Util;
import com.entities.Users;
import com.facade.beans.UsersFacade;
import javax.ejb.EJB;
import javax.servlet.http.HttpSession;

/**
 *
 * @author administrateur
 */
public class userConnexion extends userAbstractController{
    
    
    public boolean isUserExist(Users usr){
        if(usr == null) return false;
        if(psw.equals(usr.getPsw())) return true;
        return false;
    }
    
    @EJB
    UsersFacade beanU;
    
   
    
     public String doLogin(){

         if(!isUserExist(beanU.findByMail(mail))){
             msg.message(1, "Veuillez vérifier l'adresse mail et le mot de passe svp !!", "");
             return "";
        }else{
            HttpSession hs = Util.getSession();
            hs.setAttribute("mail", mail);
            
            return "/application/userApp.xhtml";
        }

    }
    
    public String doLogout(){
            HttpSession hs = Util.getSession();
            hs.invalidate();

            return "/users/connexion.xhtml?faces-redirect=true";
      }
}
