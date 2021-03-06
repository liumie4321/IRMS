package session.common;

import entity.common.CustomerEntity;
import java.security.MessageDigest;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class MemberSessionBean implements MemberSessionBeanLocal {

    @PersistenceContext
    private EntityManager em;

    public boolean verifyMember(String email, String password) {
        System.out.println("email is " + email + " password is " + password);
        try {
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(password.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            }
            System.out.println(hexString.toString() + "    hahaha48");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Query q = em.createQuery("SELECT c FROM Customer c");
        for (Object o : q.getResultList()) {
            System.out.println("omg omg");
            CustomerEntity cus = (CustomerEntity) o;
            if (cus.getEmail().equals(email)) {
                if (cus.getPassword().equals(password)){
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("MEMID", cus.getCustomerId());
                    return true;
                }
                else
                    return false;
            }
        }
        return false;
    }

    public boolean registerMember(String email, String password, String userName) {
System.out.println("member session bean 49");
        Query q = em.createQuery("SELECT c FROM Customer c");
        System.out.println("member session bean 51");
        for (Object o : q.getResultList()) {
            System.out.println("select from customer");
            CustomerEntity cus = (CustomerEntity) o;
            if (cus.getEmail().equals(email)) {
                return false;
            }
        }
        System.out.println("member session bean 59");
        CustomerEntity customer = new CustomerEntity();
        customer.setEmail(email);
        customer.setPassword(password);
        customer.setFirstName(userName);
        System.out.println("member session bean 64");
        em.persist(customer);
        System.out.println("member session bean 66");
        return true;
    }
    
    public boolean check(String mID, String email){
//        boolean flag = true;
        System.out.println("msb check 69");
        Query q = em.createQuery("SELECT c FROM Customer c");
        for (Object o : q.getResultList()) {
            System.out.println("omg omg");
            CustomerEntity cus = (CustomerEntity) o;
            if (cus.getEmail().equals(email)) {
                if (cus.getCustomerId().toString().equals(mID)){
                    return true;
                }
            }
        }
        
        System.out.println("msb check 72");
        System.out.println(mID);
        System.out.println(email);

        return false;
    }
    
    public void resetPassword(String password, String email){
        Query q = em.createQuery("SELECT c FROM Customer c");
        for (Object o : q.getResultList()) {
            System.out.println("reset reset");
            CustomerEntity cus = (CustomerEntity) o;
            if (cus.getEmail().equals(email)) {
                cus.setPassword(password);
            }
        }
    }
}