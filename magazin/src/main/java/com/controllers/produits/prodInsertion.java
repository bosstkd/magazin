/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers.produits;

import com.entities.Produits;
import com.facade.beans.ProduitsFacade;
import com.facade.beans.UsersFacade;
import com.fonctions.codification;
import javax.ejb.EJB;
import javax.ejb.Init;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Amine
 */

@ViewScoped
@ManagedBean
public class prodInsertion extends prodAbstractController{
    
    
    @EJB
    UsersFacade beanU;
    
    @EJB
    ProduitsFacade beanPr;
    
    @Init
    public void init() {
        beanPr = new ProduitsFacade();
    }
    
    public void insert(){
        Produits pr = new Produits();
        
        codification COD = new codification();
        
        pr.setIdu(beanU.usrs());
        pr.setIdprod(COD.cd_morale(beanU.usrs()+designation));
        pr.setDesignation(designation);
        pr.setDetails(details);
        pr.setLivraison(livraison);
        pr.setQte(qte);
        pr.setPrix(prix);
        pr.setDateDispo(dateDispo);
        
        if(beanPr.create(pr)){
            msg.message(0, "Insertion éffectuée.", "");
        }else{
            msg.message(1, "Erreur d'insertion.", "");
        }
        
        
    }
    
    
}
