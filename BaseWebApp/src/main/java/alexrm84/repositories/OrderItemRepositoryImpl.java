package alexrm84.repositories;

import alexrm84.entities.OrderItem;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@TransactionAttribute
public class OrderItemRepositoryImpl implements OrderItemRepository {

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @Override
    public void insert(OrderItem orderItem){
        em.persist(orderItem);
    }

    @Override
    public void update(OrderItem orderItem){
        em.merge(orderItem);
    }

    @Override
    public void delete(Long id){
        OrderItem orderItem = em.find(OrderItem.class, id);
        if (orderItem != null) {
            em.remove(orderItem);
        }
    }

    @Override
    public OrderItem findById(Long id){
        return em.find(OrderItem.class, id);
    }

    @Override
    public List<OrderItem> findByOrderId(Long order_id){
        return em.createQuery("FROM OrderItem where order_id = :order_id")
                .setParameter("order_id", order_id)
                .getResultList();
    }
}
