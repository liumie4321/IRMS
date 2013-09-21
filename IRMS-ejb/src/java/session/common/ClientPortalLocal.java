/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session.common;

import javax.ejb.Local;

/**
 *
 * @author surfer
 */
@Local
public interface ClientPortalLocal {
    public void update(Long memId, String firstName, String lastName);
    public String displayUserFirstName(Long cusID);
    public String displayUserLastName(Long cusID);
    public String displayEmail(Long cusID);
    
}
