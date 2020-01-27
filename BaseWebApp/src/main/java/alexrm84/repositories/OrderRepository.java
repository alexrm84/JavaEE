package alexrm84.repositories;

import alexrm84.entities.Order;

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
public class OrderRepository {

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    public void insert(Order order){
        em.persist(order);
    }

    public void update(Order order){
        em.merge(order);
    }

    public void delete(Long id){
        Order order = em.find(Order.class, id);
        if (order != null) {
            em.remove(order);
        }
    }

    public Order findById(Long id){
        return em.find(Order.class, id);
    }

    public List<Order> findByUserId(Long user_id){
        return em.createQuery("FROM Order where user_id = :user_id")
                .setParameter("user_id", user_id)
                .getResultList();
    }
}
