/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facade.beans;

import com.entities.Users;
import com.facade.abstractModel.AbstractFacadeMag;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
        String str = "SELECT u FROM Users u WHERE u.mail = :mail";
        Query q = em.createQuery(str);
        q.setParameter("mail", mail);
        try {
             return (Users) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
       
    }
    
}
