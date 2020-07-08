package shop.business;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import shop.business.model.User;

@Stateless
public class RegisterSessionBean implements RegisterSessionBeanLocal {

    @PersistenceContext(unitName = "WebShopGrupa3FinalVersionPU")
    private EntityManager entityManager;

    @Override
    public boolean register(String username, String password, String name, String surname) {
        try {
            Query query = entityManager.createNamedQuery("User.findByUsername").setParameter("username", username);
            List<User> users = (List<User>) query.getResultList();
            if(!users.isEmpty()){
                return false;
            }
            User user = new User();
            user.setName(name);
            user.setSurname(surname);
            user.setPassword(password);
            user.setUsername(username);
            entityManager.persist(user);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        } 
    }
}
