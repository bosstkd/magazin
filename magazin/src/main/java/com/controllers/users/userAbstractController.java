/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers.users;

import com.entities.Users;
import com.facade.abstractModel.Message;
import java.util.List;

/**
 *
 * @author administrateur
 */
public abstract class userAbstractController {
 
  protected String username;
  protected String mail;
  protected String tel;
  protected String psw;
  protected String adresse;
  
  protected List<Users> listUser;
  protected Users usr;
  
  public Message msg = new Message();

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
    
   
}
