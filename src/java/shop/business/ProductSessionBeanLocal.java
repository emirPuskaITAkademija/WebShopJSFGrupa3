package shop.business;

import java.util.List;
import javax.ejb.Local;
import shop.business.model.Product;

@Local
public interface ProductSessionBeanLocal {

    public List<Product> getAllProducts();
}
