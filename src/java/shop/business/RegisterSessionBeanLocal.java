
package shop.business;

import javax.ejb.Local;

@Local
public interface RegisterSessionBeanLocal {
    
    public boolean register(String username, String password, String name, String surname);
}
