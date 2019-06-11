package com.exceptions.detector;


import com.controllers.Util;
import com.entities.Users;
import com.facade.beans.UsersFacade;
import javax.ejb.EJB;
import javax.ejb.Init;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpSession;


@ManagedBean
public class sessionInfoMag {

 

//-------------------------------------

 @EJB
 UsersFacade beanU;
 
 @Init
    public void init() {
        beanU = new UsersFacade();
    }
 
  protected boolean existClt(){
   Users usr = new Users();
        try {
               usr = beanU.usrs();
            } catch (Exception e) {
                return false;
            }
             return usr != null;
 }
  
   public String returnToConnexion() {
     System.out.println("session exist : "+existClt());
     boolean ss = existClt();
     if(!ss){
          System.out.println("etat 1");
          return "/users/connexion.xhtml?faces-redirect=true";
     }else{
          System.out.println("etat 2");
          return "";
     }
}
   
   public void doLogout(){
            HttpSession hs = Util.getSession();
            hs.invalidate();
      }
    
}
