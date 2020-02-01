package alexrm84.controllers;

import alexrm84.entities.DAO.OrderItemDAO;
import alexrm84.entities.DAO.ProductDAO;
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

    public List<OrderItemDAO> getItems(){
        return this.cart.getItems();
    }

    public void add(ProductDAO product){
        this.cart.addProduct(product);
    }

    public void reduce(ProductDAO product){
        this.cart.reduceProduct(product);
    }
}
