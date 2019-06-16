/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers.produits;

import com.entities.Produits;
import com.facade.beans.ProduitsFacade;
import com.facade.beans.UsersFacade;
import com.up.image.imageUpAPI;
import java.io.IOException;
import java.util.Date;
import javax.annotation.PostConstruct;
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
  
    
    @PostConstruct
    public void construire(){
        prix = 0f;
        qte = 1;
        dateDispo = new Date();
    }
      
      public void insert() throws IOException {
        if(file != null) {
            try {
                imageUpAPI IUA = new imageUpAPI();
               if( IUA.primeFacesImageReceiver(500, 450, file, "\\"+beanU.usrs().getIdu()+"\\", "", COD.cd_morale(beanU.usrs()+designation))){
                    Produits pr = new Produits();
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
            
               }else{
                    msg.message(1, "Erreur lors du chargement de l'image !!", "");
               }
               
               
         } catch (Exception e) {
                 msg.message(2, "Grave erreur lors de l'insertion", e.getMessage());
         }
                
        }
    }
     
}
