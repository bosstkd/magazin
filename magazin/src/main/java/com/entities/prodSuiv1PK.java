/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author administrateur
 */
 @Embeddable
public class prodSuiv1PK {
    


    @ManyToOne
    @JoinColumn(name = "idpub")
    private Publication idpub;

    @ManyToOne
    @JoinColumn(name = "idu")
    private Users idu;

}
