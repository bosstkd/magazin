/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.abstractFacade.all.AbstractFacade;
import com.entities.Users;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author administrateur
 */
public class UserAbstractController extends AbstractFacade<Users>{
    
    public UserAbstractController(EntityManagerFactory emf) {
        super(emf);
    }
    
}
