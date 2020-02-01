package alexrm84.services;

import alexrm84.entities.DAO.OrderDAO;
import alexrm84.entities.Order;
import alexrm84.repositories.OrderRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class OrderService {

    @Inject
    private OrderRepository orderRepository;

    @Inject
    private UserService userService;

    @Inject
    private OrderItemService orderItemService;

    public void insert(OrderDAO orderDAO){
        orderRepository.insert(convertFromDAO(orderDAO));
    }

    public void update(OrderDAO orderDAO){
        orderRepository.update(convertFromDAO(orderDAO));
    }

    public void delete(Long id){
        orderRepository.delete(id);
    }

    public OrderDAO findById(Long id){
        return convertToDAO(orderRepository.findById(id));
    }

    public List<OrderDAO> findByUserId(Long user_id){
        List<Order> list = orderRepository.findByUserId(user_id);
        return list.stream().map(o -> convertToDAO(o)).collect(Collectors.toList());
    }

    public Order convertFromDAO(OrderDAO orderDAO) {
        Order order = new Order(userService.convertFromDao(orderDAO.getUserDAO()),
                orderDAO.getPrice(),
                orderDAO.getPhone(),
                orderDAO.getAddress(),
                orderDAO.getStatus(),
                orderDAO.getItems().stream().map(i -> orderItemService.convertFromDao(i)).collect(Collectors.toList()));
        order.setId(orderDAO.getId());
        return order;
    }

    public OrderDAO convertToDAO(Order order) {
        return new OrderDAO(order.getId(),
                userService.convertToDao(order.getUser()),
                order.getPrice(),
                order.getPhone(),
                order.getAddress(),
                order.getStatus(),
                order.getCreatedAt(),
                order.getUpdatedAt(),
                order.getItems().stream().map(i -> orderItemService.convertToDao(i)).collect(Collectors.toList()));
    }
}
