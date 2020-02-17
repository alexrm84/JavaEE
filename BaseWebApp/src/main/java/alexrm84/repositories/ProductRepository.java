package alexrm84.repositories;

import alexrm84.entities.Product;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ProductRepository {
    Product insert(Product product);
    Product update(Product product);
    void delete(Long id);
    Product findById(Long id);
    List<Product> findAll();
}
