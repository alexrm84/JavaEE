package alexrm84.services;

import alexrm84.entities.DAO.OrderItemDAO;
import alexrm84.entities.OrderItem;
import alexrm84.repositories.OrderItemRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class OrderItemService {

    @Inject
    private OrderService orderService;

    @Inject
    private ProductService productService;

    @Inject
    private OrderItemRepository orderItemRepository;

    public void insert(OrderItemDAO orderItemDAO){
        orderItemRepository.insert(convertFromDao(orderItemDAO));
    }

    public void update(OrderItemDAO orderItemDAO) {
        orderItemRepository.update(convertFromDao(orderItemDAO));
    }

    public void delete(Long id) {
        orderItemRepository.delete(id);
    }

    public OrderItemDAO findById(Long id) {
        return convertToDao(orderItemRepository.findById(id));
    }

    public List<OrderItemDAO> findByOrderId(Long order_id) {
        List<OrderItem> list = orderItemRepository.findByOrderId(order_id);
        return list.stream().map(oi -> convertToDao(oi)).collect(Collectors.toList());
    }

    public OrderItemDAO convertToDao(OrderItem orderItem){
        return new OrderItemDAO(orderItem.getId(),
                productService.convertToDao(orderItem.getProduct()),
//                orderService.convertToDAO(orderItem.getOrder()),
                orderItem.getQuantity(),
                orderItem.getItemPrice(),
                orderItem.getTotalPrice());
    }

    public OrderItem convertFromDao(OrderItemDAO orderItemDAO) {
        OrderItem orderItem = new OrderItem(productService.convertFromDao(orderItemDAO.getProductDAO()),
//                orderService.convertFromDAO(orderItemDAO.getOrderDAO()),
                orderItemDAO.getQuantity(),
                orderItemDAO.getItemPrice(),
                orderItemDAO.getTotalPrice());
        orderItem.setId(orderItemDAO.getId());
        return orderItem;
    }
}
