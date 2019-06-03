/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application;



import com.controllers.UsersJpaController;
import com.entities.Users;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author administrateur
 */
public class test {
    
    private static final EntityManagerFactory emFactory;
	static {
		   emFactory = Persistence.createEntityManagerFactory("hb_wout_error_PU");
	}
	public static EntityManager getEntityManager(){
		return emFactory.createEntityManager();
	}
    
    public static void main(String[] args) throws Exception {
		
        
                UsersJpaController uJPA = new UsersJpaController(emFactory);
		   
                Users u = new Users();
                
                u.setId(1);
                u.setName("Amine");
                u.setUsername("bossTkd");
                
                
                uJPA.create(u);
				
		System.out.println("Done");
	}
}