/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers.users;

import com.controllers.Util;
import com.entities.Users;
import com.fonctions.codification;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author administrateur
 */
@ManagedBean
@SessionScoped
public class userUpdate extends userAbstractController{

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



    public void update(String ancMail) {

        String idu = (String) beanU.findByMail((String) Util.getSession().getAttribute("mail")).getIdu();

        Users u = new Users();
        
        u.setIdu(idu);
        u.setUsername(username);
        u.setMail(mail);
        u.setPsw(psw);
        u.setTel(tel);
        u.setAdresse(adresse);
      
        
        
        try {
            beanU.edit(u);
            msg.message(0, "Mise à jour effectuer avec succée.", "");
        } catch (Exception e) {
            msg.message(2, "Erreur mise à jour.", e.getMessage());
        }
    }
    
 

    
}
