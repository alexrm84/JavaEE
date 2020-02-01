package alexrm84.repositories;

import alexrm84.entities.Order;

import javax.ejb.Local;
import java.util.List;

@Local
public interface OrderRepository {
    void insert(Order order);
    void update(Order order);
    void delete(Long id);
    Order findById(Long id);
    List<Order> findByUserId(Long user_id);
}
