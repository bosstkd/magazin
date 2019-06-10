/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facade.beans;

import com.entities.Users;
import com.facade.abstractModel.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Amine
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "comMagazinPU")
    private EntityManager em;

   
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }
    
    public Users findByMail(String mail){
        String str = "Users.findByMail";
        Query q = em.createQuery(str);
        q.setParameter("mail", mail);
        
        return (Users) q.getSingleResult();
    }
    
}
