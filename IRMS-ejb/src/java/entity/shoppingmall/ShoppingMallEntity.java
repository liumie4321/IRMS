/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.shoppingmall;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author liuyang
 */

@Entity
public class ShoppingMallEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shoppingMallId;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "shoppingMall")
    private Collection<OutletEntity> outlets = new ArrayList<OutletEntity>();

    public ShoppingMallEntity() {
        setShoppingMallId(System.nanoTime());
    }
    
    

    public Long getShoppingMallId() {
        return shoppingMallId;
    }

    public void setShoppingMallId(Long shoppingMallId) {
        this.shoppingMallId = shoppingMallId;
    }

    public Collection<OutletEntity> getOutlets() {
        return outlets;
    }

    public void setOutlets(Collection<OutletEntity> outlets) {
        this.outlets = outlets;
    }
    
}
