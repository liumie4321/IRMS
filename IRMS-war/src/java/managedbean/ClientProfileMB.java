/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import entity.common.CustomerEntity;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import session.common.ClientPortalLocal;

/**
 *
 * @author surfer
 */

@RequestScoped
@ManagedBean(name="clientProfileMB")
public class ClientProfileMB {
    private String FirstName;
    private String LastName;
    @EJB
    private ClientPortalLocal cp;

    /**
     * Creates a new instance of ClientProfileMB
     */
    public ClientProfileMB() {
    }
    
    public Long getCusID(){
        Long id;
        id = (Long) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("MEMID");
        return id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }
    
    public String displayMemID(){
        return getCusID().toString();
    }
    
    public String displayUserFirstName(){
        return cp.displayUserFirstName(getCusID());
    }
    
    public String displayUserLastName(){
        return cp.displayUserLastName(getCusID());
    }
    
    public String displayEmail(){
        return cp.displayEmail(getCusID());
    }
    
    public String edit(){
        System.out.println("CMB edit 57");
        cp.update(getCusID(), FirstName, LastName);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Updated Successfully"));
        return "MemberProfile";
    }
}