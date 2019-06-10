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
        if(tel == null) tel = "";
        u.setTel(tel);
        if(adresse == null) adresse = "";
        u.setAdresse(adresse);
        
        codification COD = new codification();
        u.setIdu(COD.cd_prs(mail));
        
        try {
            beanU.create(u);
            msg.message(0, "Insertion effectuée avec succé.", "");
        } catch (Exception e) {
            msg.message(2, "Erreur d'insertion.", "Veillez vérifier votre connexion");
        }
        
    }

}
