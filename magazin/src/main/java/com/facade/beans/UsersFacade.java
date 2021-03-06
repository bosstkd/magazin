/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facade.beans;

import com.controllers.Util;
import com.entities.Users;
import com.facade.abstractModel.AbstractFacadeMag;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Amine
 */
@Stateless
public class UsersFacade extends AbstractFacadeMag<Users> {

    @PersistenceContext(unitName = "comMagazinPU")
    private EntityManager em;


    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }
    
    public Users findByMail(String mail){
        System.out.println(mail);
        String str = "SELECT u FROM Users u WHERE u.mail = :mail";
        Query q = em.createQuery(str);
        q.setParameter("mail", mail);
        try {
            if(q.getSingleResult() != null) return (Users) q.getSingleResult();
        } catch (Exception e) { }
         return null;
    }
    
    
    public Users usrs(){
        HttpSession hs = Util.getSession();
        String mail = (String) hs.getAttribute("mail");
        return findByMail(mail);
    }
    
}
