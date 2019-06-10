/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers.users;

import com.entities.Users;
import com.facade.beans.UsersFacade;
import com.fonctions.codification;
import javax.ejb.EJB;
import javax.ejb.Init;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;

/**
 *
 * @author administrateur
 */

@ViewScoped
@ManagedBean
public class userInsertion extends userAbstractController{

    @EJB
    UsersFacade beanU;
    
    @Init
    public void init() {
        beanU = new UsersFacade();
    }

    public void insert() {
        Users u = new Users();
        u.setUsername(username);
        u.setMail(mail);
        u.setPsw(psw);
        
        if(tel.equals("null") || tel == null || tel.equals("") ) tel = "Tel inconnu";
        u.setTel(tel);
       
        if(adresse.equals("null") || adresse == null || adresse.equals("") ) adresse = "Adresse inconnu";
        u.setAdresse(adresse);
        
        codification COD = new codification();
        u.setIdu(COD.cd_prs(mail));
        
        try {
            System.out.println(u.getIdu());
            if(beanU.create(u)){
                msg.message(0, "Insertion effectuée avec succé.", "");
            }else{
                msg.message(1, "Erreur d'insertion", "");
            }
            
        } catch (Exception e) {
            msg.message(2, "Erreur d'insertion.", "Veuillez vérifier votre connexion");
        }
        
    }

}
