package alexrm84.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "products")
@NoArgsConstructor
public class Product implements Serializable {
    private static final long serialVersionUID = -7303616358855139206L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "description")
    private String description;

    public Product(String title, String description, BigDecimal price) {
        this.title = title;
        this.price = price;
        this.description = description;
    }

    public Product(Long id, String title, String description, BigDecimal price) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
    }
}
