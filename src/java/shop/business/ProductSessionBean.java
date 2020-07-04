package shop.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import shop.business.model.Product;

@Stateless
public class ProductSessionBean implements ProductSessionBeanLocal {

    @PersistenceContext(name = "WebShopGrupa3FinalVersionPU")
    private EntityManager entityManager;

    @Override
    public List<Product> getAllProducts() {
        try {
            Query query = entityManager.createNamedQuery("Product.findAll");
            return query.getResultList();
        } catch (Exception exception) {
            exception.printStackTrace();
            return Collections.emptyList();
        }
    }
}
