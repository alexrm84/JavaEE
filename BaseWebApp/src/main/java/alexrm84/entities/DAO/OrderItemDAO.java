package alexrm84.entities.DAO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class OrderItemDAO implements Serializable {
    private static final long serialVersionUID = 8012209393082989998L;

    private Long id;
    private ProductDAO productDAO;
    private OrderDAO orderDAO;
    private int quantity;
    private BigDecimal itemPrice;
    private BigDecimal totalPrice;

    public OrderItemDAO(ProductDAO productDAO, int quantity, BigDecimal itemPrice) {
        this.productDAO = productDAO;
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public OrderItemDAO(Long id, ProductDAO productDAO, OrderDAO orderDAO, int quantity, BigDecimal itemPrice, BigDecimal totalPrice) {
        this.id = id;
        this.productDAO = productDAO;
        this.orderDAO = orderDAO;
        this.quantity = quantity;
        this.itemPrice = itemPrice;
        this.totalPrice = totalPrice;
    }
}
