package alexrm84.controllers;

import alexrm84.entities.OrderItem;
import alexrm84.entities.Product;
import alexrm84.utils.Cart;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CartController implements Serializable {

    private static final long serialVersionUID = 2387689879639022921L;

    @Inject
    private Cart cart;

    public String showCartPage(){
        return "/cart.xhtml?faces-redirect=true";
    }

    public List<OrderItem> getItems(){
        return this.cart.getItems();
    }

    public void add(Product product){
        this.cart.addProduct(product);
    }

    public void reduce(Product product){
        this.cart.reduceProduct(product);
    }
}
