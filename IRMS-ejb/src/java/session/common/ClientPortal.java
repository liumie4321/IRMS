/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session.common;

import entity.common.CustomerEntity;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author surfer
 */
@Stateful
public class ClientPortal implements ClientPortalLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager em;
    
    public void update(Long cusID, String firstName, String lastName){
        CustomerEntity cus = em.find(CustomerEntity.class, cusID);
        cus.setFirstName(firstName);
        cus.setLastName(lastName);
    }
    
    public String displayUserFirstName(Long cusID){
        CustomerEntity cus = em.find(CustomerEntity.class, cusID);
        return cus.getFirstName();
    }
    
    public String displayUserLastName(Long cusID){
        CustomerEntity cus = em.find(CustomerEntity.class, cusID);
        return cus.getLastName();
    }
    
    public String displayEmail(Long cusID){
        CustomerEntity cus = em.find(CustomerEntity.class, cusID);
        return cus.getEmail();
    }

}
