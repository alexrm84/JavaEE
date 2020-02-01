package alexrm84.repositories;

import alexrm84.entities.OrderItem;

import javax.ejb.Local;
import java.util.List;

@Local
public interface OrderItemRepository {
    void insert(OrderItem orderItem);
    void update(OrderItem orderItem);
    void delete(Long id);
    OrderItem findById(Long id);
    List<OrderItem> findByOrderId(Long order_id);
}
