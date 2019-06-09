/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author administrateur
 */
 @Embeddable
public class prodSuiv2PK {
    


    @ManyToOne
    @JoinColumn(name = "idpub")
    private Publication idpub;

    public Publication getIdpub() {
        return idpub;
    }

    public void setIdpub(Publication idpub) {
        this.idpub = idpub;
    }

    
    

}
