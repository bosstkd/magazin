/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers.users;

import com.entities.Users;
import com.fonctions.codification;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author administrateur
 */
@ManagedBean
@ViewScoped
public class userInsertion extends userAbstractController{

  private String username;
  private String mail;
  private String tel;
  private String psw;
  private String adresse;
  
  public List<Users> listUser;
  public Users usr;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Users> getListUser() {
        return listUser;
    }

    public Users getUsr() {
        return usr;
    }

    public void setUsr(Users usr) {
        this.usr = usr;
    }

    
  
  
    
    public void insert() {
        Users u = new Users();
        u.setUsername(username);
        u.setMail(mail);
        u.setPsw(psw);
        u.setTel(tel);
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
