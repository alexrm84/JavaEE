package alexrm84.entities.DAO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProductDAO implements Serializable {
    private static final long serialVersionUID = 1706662367938822126L;

    private Long id;
    private String title;
    private BigDecimal price;
    private String description;

    public ProductDAO(String title, String description, BigDecimal price) {
        this.title = title;
        this.price = price;
        this.description = description;
    }

    public ProductDAO(Long id, String title, String description, BigDecimal price) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
    }
}
