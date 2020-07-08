package shop.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import shop.beans.model.ShoppingCartItem;
import shop.business.ProductSessionBeanLocal;
import shop.business.model.Product;

@ManagedBean(name = "productManagedBean", eager = true)
@SessionScoped//on će čuvati korpu->ShoppingCart
public class ProductManagedBean implements Serializable{

    @EJB
    private ProductSessionBeanLocal productSessionBeanLocal;
    
    private Integer quantity;
    private List<ShoppingCartItem> shoppingCartItems = new ArrayList<>();
    
    public ProductManagedBean() {
    }
    
    public void addProductToShoppingCart(Product product){
        for (ShoppingCartItem shoppingCartItem : shoppingCartItems) {
            if (shoppingCartItem.getProduct().getId() == product.getId()) {
                int newQuantity = shoppingCartItem.getQuantity() + quantity;
                shoppingCartItem.setQuantity(newQuantity);
                return;
            }
        }
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem(product, quantity);
        shoppingCartItems.add(shoppingCartItem);
    }

    public List<ShoppingCartItem> getShoppingCartItems() {
        return shoppingCartItems;
    }
    
    

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    
    
    public List<Product> getAllProducts(){
        return productSessionBeanLocal.getAllProducts();
    }
}
