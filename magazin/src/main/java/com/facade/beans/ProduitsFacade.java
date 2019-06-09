/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facade.beans;

import com.entities.Produits;
import com.entities.Users;
import com.facade.abstractModel.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author administrateur
 */
@Stateless
public class ProduitsFacade extends AbstractFacade<Produits>{

    
    @PersistenceContext(unitName = "comMagazinPU")
    private EntityManager em;

   
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public ProduitsFacade() {
        super(Produits.class);
    }

    
}
