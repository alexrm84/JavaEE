package alexrm84.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
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
