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
@Table(name="pub_suiv1") 
public class pubSuiv1 {
    
    @EmbeddedId
    private prodSuiv1PK id;

    
    @Column(name = "comment")
    private String comment;
    
    
    @Column(name = "comment")
    private Users idu;

    public prodSuiv1PK getId() {
        return id;
    }

    public void setId(prodSuiv1PK id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Users getIdu() {
        return idu;
    }

    public void setIdu(Users idu) {
        this.idu = idu;
    }
    
    
    
    
    
}
