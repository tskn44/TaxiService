/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.taxiservice.api.dao;

import edu.taxiservice.api.service.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Lasitha
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer>{

    @PersistenceUnit(unitName = "TaxiServiceAPIPU")
    private EntityManagerFactory emf;

    public CustomerFacade() {
        super(Customer.class);
    }
        
    @Override
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
}
