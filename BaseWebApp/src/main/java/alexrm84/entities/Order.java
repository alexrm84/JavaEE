package alexrm84.entities;

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

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order implements Serializable {
    private static final long serialVersionUID = -4330813651525003249L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(/*mappedBy = "order",*/ cascade = CascadeType.ALL)
    private List<OrderItem> items;

    public Order(User user, String phone, String address) {
        this.user = user;
        this.phone = phone;
        this.address = address;
        this.items = new ArrayList<>();
        this.price = new BigDecimal(0);
    }

    public Order(User user, BigDecimal price, String phone, String address, OrderStatus status, List<OrderItem> items) {
        this.user = user;
        this.price = price;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.items = items;
    }
}

