package alexrm84.controllers;

import alexrm84.entities.DAO.OrderDAO;
import alexrm84.entities.DAO.UserDAO;
import alexrm84.services.OrderService;
import alexrm84.services.UserService;
import alexrm84.utils.Cart;
import alexrm84.utils.Logger;
import alexrm84.utils.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;
import java.io.Serializable;
import java.math.BigDecimal;

@Named
@SessionScoped
public class OrderController implements Serializable {

    private static final long serialVersionUID = 1406583733340258307L;

    @Inject
    private OrderService orderService;

    @Inject
    private UserService userService;

    @Inject
    private Cart cart;

    @Getter
    @Setter
    private OrderDAO order;

    @Interceptors({Logger.class})
    public String createOrder() {
        this.order = new OrderDAO();
        this.order.setUserDAO(new UserDAO());
        return "/order.xhtml?faces-redirect=true";
    }

    @Interceptors({Logger.class})
    public String confirmOrder() {
        UserDAO user = userService.findByLogin(this.order.getUserDAO().getLogin());
        if (user == null) {
            userService.insert(this.order.getUserDAO());
            user = userService.findByLogin(this.order.getUserDAO().getLogin());
        }
        this.order.setUserDAO(user);
        this.order.setPrice(new BigDecimal(0));
        this.order.setPhone(user.getLogin());
        cart.getItems().stream().forEach(item -> order.addItem(item));
        cart.clear();
        this.order.setStatus(OrderStatus.CREATED);
        orderService.insert(order);
        return "/shop.xhtml?faces-redirect=true";
    }
}
