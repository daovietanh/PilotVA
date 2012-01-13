/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.hkt.generic.jpas.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author khangphamngoc
 */
public class jpaUtils {
    
    private EntityManagerFactory emf;
    private EntityManager em;
 
    public  EntityManagerFactory getEmf() {
        if(emf==null){
            emf = Persistence.createEntityManagerFactory("EnterpriseManagerService");
        }
        return emf;
    }

    /**
     * @return the em
     */
    public EntityManager getEm() {
        return this.em=getEmf().createEntityManager();
    }

    
}
