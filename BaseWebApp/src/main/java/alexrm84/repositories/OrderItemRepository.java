package alexrm84.repositories;

import alexrm84.entities.OrderItem;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Named
@ApplicationScoped
@Transactional
public class OrderItemRepository {

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    public void insert(OrderItem orderItem){
        em.persist(orderItem);
    }

    public void update(OrderItem orderItem){
        em.merge(orderItem);
    }

    public void delete(Long id){
        OrderItem orderItem = em.find(OrderItem.class, id);
        if (orderItem != null) {
            em.remove(orderItem);
        }
    }

    public OrderItem findById(Long id){
        return em.find(OrderItem.class, id);
    }

    public List<OrderItem> findByOrderId(Long order_id){
        return em.createQuery("FROM OrderItem where order_id = :order_id")
                .setParameter("order_id", order_id)
                .getResultList();
    }

}
