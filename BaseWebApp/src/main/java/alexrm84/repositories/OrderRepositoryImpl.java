package alexrm84.repositories;

import alexrm84.entities.Order;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

//@Stateless
//@TransactionAttribute
@Named
@ApplicationScoped
@Transactional
public class OrderRepositoryImpl implements OrderRepository {

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @Override
    public void insert(Order order){
        em.persist(order);
    }

    @Override
    public void update(Order order){
        em.merge(order);
    }

    @Override
    public void delete(Long id){
        Order order = em.find(Order.class, id);
        if (order != null) {
            em.remove(order);
        }
    }

    @Override
    public Order findById(Long id){
        return em.find(Order.class, id);
    }

    @Override
    public List<Order> findByUserId(Long user_id){
        return em.createQuery("FROM Order where user_id = :user_id")
                .setParameter("user_id", user_id)
                .getResultList();
    }
}
