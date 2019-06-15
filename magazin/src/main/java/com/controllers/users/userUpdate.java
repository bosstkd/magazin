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
import javax.ejb.Init;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author administrateur
 */
@ManagedBean
@SessionScoped
public class userUpdate extends userAbstractController{

       
    
    private Users user;
    private String npsw;
    
    public Users getUser() {
        return beanU.usrs();
    }

    public String getNpsw() {
        return npsw;
    }

    public void setNpsw(String npsw) {
        this.npsw = npsw;
    }
    
    

    @EJB
    UsersFacade beanU;
    
    @Init
    public void init() {
        beanU = new UsersFacade();
        Users us = beanU.usrs();
        username = us.getUsername();
        mail = us.getMail();
        
        if(us.getTel().equals("Tel inconnu"))
            tel = "";
        else
            tel = us.getTel();
        
        adresse = us.getAdresse();
        
        
        
    }

    public void updateInfo() {


        Users u = new Users();
        
        u.setIdu(beanU.usrs().getIdu());
        u.setUsername(username);
        u.setMail(mail);
        u.setPsw(beanU.usrs().getIdu());
        
        if(tel == null){
            tel = "Tel inconnu";
        }else if (tel.equals("")){
            tel = "Tel inconnu";
        }else if(tel.equals("null")){
            tel = "Tel inconnu";
        }
        
        u.setTel(tel);
       
        if(adresse == null){
            adresse = "Adresse inconnu";
        }else if (adresse.equals("")){
            adresse = "Adresse inconnu";
        }else if(adresse.equals("null")){
            adresse = "Adresse inconnu";
        }
        
        u.setAdresse(adresse);

        try {
            beanU.edit(u);
            msg.message(0, "Mise à jour effectuée avec succé.", "");
        } catch (Exception e) {
            msg.message(2, "Erreur mise à jour.", e.getMessage());
        }
    }
    
    public void passUpdate(){
        
        if(psw.equals(beanU.usrs().getPsw())){
           Users u = new Users();
        
            u.setIdu(beanU.usrs().getIdu());
            u.setUsername(beanU.usrs().getUsername());
            u.setMail(beanU.usrs().getMail());
            u.setPsw(npsw);
            u.setTel(beanU.usrs().getTel());
            u.setAdresse(beanU.usrs().getAdresse());



            try {
                beanU.edit(u);
                msg.message(0, "Mot de passe mis à jour mise à jour.", "");
            } catch (Exception e) {
                msg.message(2, "Erreur mise à jour.", e.getMessage());
            } 
        }else{
            msg.message(1, "Ancien mot de passe incorrecte", "");
        }
        
         
    }
    
 

    
}
