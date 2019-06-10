/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers.users;

import com.controllers.Util;
import com.entities.Users;
import com.facade.beans.UsersFacade;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author administrateur
 */
@ManagedBean
@SessionScoped
public class userUpdate extends userAbstractController{

       
    
    
  @EJB
    UsersFacade beanU;
    
    @PostConstruct
    public void init() {
        beanU = new UsersFacade();
         // System.out.println("on userUpdate : "+(String)Util.getSession().getAttribute("mail"));
        String mailAdresse = (String)Util.getSession().getAttribute("mail");
        Users u = beanU.findByMail(mailAdresse);
        username = u.getUsername();
    }

   
    

    public void update(String ancMail) {

        String idu = beanU.findByMail((String) Util.getSession().getAttribute("mail")).getIdu();

        Users u = new Users();
        
        u.setIdu(idu);
        u.setUsername(username);
        u.setMail(mail);
        u.setPsw(psw);
        u.setTel(tel);
        u.setAdresse(adresse);
      
        
        
        try {
            beanU.edit(u);
            msg.message(0, "Mise à jour effectuée avec succé.", "");
        } catch (Exception e) {
            msg.message(2, "Erreur mise à jour.", e.getMessage());
        }
    }
    
 

    
}
