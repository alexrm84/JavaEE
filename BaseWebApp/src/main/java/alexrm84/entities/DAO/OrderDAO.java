package alexrm84.entities.DAO;

import alexrm84.entities.OrderItem;
import alexrm84.entities.User;
import alexrm84.utils.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderDAO implements Serializable {
    private static final long serialVersionUID = -943400650549398242L;

    private Long id;
    private UserDAO userDAO;
    private BigDecimal price;
    private String phone;
    private String address;
    private OrderStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<OrderItemDAO> items;

    public OrderDAO(UserDAO userDAO, String phone, String address) {
        this.userDAO = userDAO;
        this.phone = phone;
        this.address = address;
        this.items = new ArrayList<>();
        this.price = new BigDecimal(0);
    }

    public void addItem(OrderItemDAO item){
        items.add(item);
//        item.setOrderDAO(this);
        price = price.add(item.getTotalPrice());
    }

    public OrderDAO(Long id, UserDAO userDAO, BigDecimal price, String phone, String address, OrderStatus status, LocalDateTime createdAt, LocalDateTime updatedAt, List<OrderItemDAO> items) {
        this.id = id;
        this.userDAO = userDAO;
        this.price = price;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.items = items;
    }
}

