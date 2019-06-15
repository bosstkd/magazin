/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers.produits;

import com.entities.Produits;
import com.facade.abstractModel.Message;
import java.util.Date;
import java.util.List;


public abstract class prodAbstractController {
    
    protected String idProd;
    protected String idu;
    protected String designation;
    protected String details;
    protected int qte;
    protected Date dateDispo;
    protected Float prix;
    protected boolean livraison;

    protected List<Produits> allProds;
    protected Produits prod;

    public List<Produits> getAllProds() {
        return allProds;
    }

    public Produits getProd() {
        return prod;
    }

    public void setProd(Produits prod) {
        this.prod = prod;
    }
    
    
     public Message msg = new Message();
    
    
    public String getIdProd() {
        return idProd;
    }

    public void setIdProd(String idProd) {
        this.idProd = idProd;
    }

    public String getIdu() {
        return idu;
    }

    public void setIdu(String idu) {
        this.idu = idu;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public Date getDateDispo() {
        return dateDispo;
    }

    public void setDateDispo(Date dateDispo) {
        this.dateDispo = dateDispo;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public boolean isLivraison() {
        return livraison;
    }

    public void setLivraison(boolean livraison) {
        this.livraison = livraison;
    }
          
    
    
    
}
