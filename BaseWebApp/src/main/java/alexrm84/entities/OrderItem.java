package alexrm84.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
@Getter
@Setter
@NoArgsConstructor
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 5278951391888291133L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;

//    @ManyToOne()
//    @JoinColumn(name = "order_id")
//    private Order order;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "item_price")
    private BigDecimal itemPrice;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    public OrderItem(Product product, int quantity, BigDecimal itemPrice) {
        this.product = product;
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public OrderItem(Product product, /*Order order,*/ int quantity, BigDecimal itemPrice, BigDecimal totalPrice) {
        this.product = product;
//        this.order = order;
        this.quantity = quantity;
        this.itemPrice = itemPrice;
        this.totalPrice = totalPrice;
    }
}
