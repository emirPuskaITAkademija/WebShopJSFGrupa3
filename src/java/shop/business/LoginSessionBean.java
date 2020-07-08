
package shop.business;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import shop.business.model.User;

@Stateless
public class LoginSessionBean implements LoginSessionBeanLocal {
    
    @PersistenceContext(unitName = "WebShopGrupa3FinalVersionPU")
    private EntityManager entityManager;

    @Override
    public User login(String username, String password) {
        try{
            return (User) entityManager.createNamedQuery("User.findByUsernamePassword")
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
        }catch(Exception exception){
            exception.printStackTrace();
            return null;
        }
    }

   
}
