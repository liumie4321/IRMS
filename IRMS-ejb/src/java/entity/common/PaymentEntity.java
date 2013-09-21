/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.common;

import entity.common.CustomerEntity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author lenovo
 */
@Entity
public class PaymentEntity implements Serializable {

    @Id
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date payDate;
    private double amt;

    @OneToOne(cascade={CascadeType.PERSIST})
    private TransactionEntity transaction;
  
  
    
    public PaymentEntity() {
        setId(System.nanoTime());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }



    public TransactionEntity getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionEntity transaction) {
        this.transaction = transaction;
    }
    
    

    
    
    
}
