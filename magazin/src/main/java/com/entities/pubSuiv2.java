/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author administrateur
 */
@Entity 
@Table(name="pub_suiv2") 
public class pubSuiv2 {
    
    @EmbeddedId
    private prodSuiv2PK id;

    
    @Column(name = "jaime")
    private Boolean jaime;
    
    @Column(name = "idu")
    private Users idu;

    public prodSuiv2PK getId() {
        return id;
    }

    public void setId(prodSuiv2PK id) {
        this.id = id;
    }

    public Boolean getJaime() {
        return jaime;
    }

    public void setJaime(Boolean jaime) {
        this.jaime = jaime;
    }

    public Users getIdu() {
        return idu;
    }

    public void setIdu(Users idu) {
        this.idu = idu;
    }
    
    
    
}
