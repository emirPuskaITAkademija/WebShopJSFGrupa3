package shop.beans;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import shop.business.ProductSessionBean;
import shop.business.ProductSessionBeanLocal;
import shop.business.model.Product;

@ManagedBean(name = "productManagedBean", eager = true)
@SessionScoped
public class ProductManagedBean implements Serializable{

    @EJB
    private ProductSessionBeanLocal productSessionBeanLocal;
    
    public ProductManagedBean() {
    }
    
    public List<Product> getAllProducts(){
        return productSessionBeanLocal.getAllProducts();
    }
}
