package shop.business;

import javax.ejb.Local;
import shop.business.model.User;

@Local
public interface LoginSessionBeanLocal {
    public User login(String username, String password);
}
