package alexrm84.controllers;

import alexrm84.entities.Order;
import alexrm84.entities.User;
import alexrm84.repositories.OrderRepository;
import alexrm84.repositories.UserRepository;
import alexrm84.utils.Cart;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;

@Named
@SessionScoped
public class OrderController implements Serializable {

    private static final long serialVersionUID = 1406583733340258307L;

    @Inject
    private OrderRepository orderRepository;

    @Inject
    private UserRepository userRepository;

    @Inject
    private Cart cart;

    @Getter
    @Setter
    private Order order;

    public String createOrder(){
        this.order = new Order();
        this.order.setUser(new User());
        return "/order.xhtml?faces-redirect=true";
    }

    public String confirmOrder(){
        User user = userRepository.findByPhone(this.order.getUser().getPhone());
        if (user ==null){
            user = userRepository.insert(this.order.getUser());
        }
        this.order.setUser(user);
        this.order.setPrice(new BigDecimal(0));
        this.order.setPhone(user.getPhone());
        cart.getItems().values().stream().forEach(item -> order.addItem(item));
        cart.clear();
        this.order.setStatus(Order.Status.CREATED);
        orderRepository.insert(order);
        return "/shop.xhtml?faces-redirect=true";
    }
}
