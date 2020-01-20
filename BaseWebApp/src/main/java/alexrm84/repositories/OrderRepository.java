package alexrm84.repositories;

import alexrm84.entities.Order;
import alexrm84.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.Query;
import java.util.List;

@Named
@ApplicationScoped
public class OrderRepository {
    private Session session;

    public void insert(Order order){
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        session.save(order);
        tx.commit();
        session.close();
    }

    public void update(Order order){
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        session.update(order);
        tx.commit();
        session.close();
    }

    public void delete(Long id){
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(session.load(Order.class, id));
        tx.commit();
        session.close();
    }

    public Order findById(Long id){
        Order order;
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        order = session.get(Order.class, id);
        tx.commit();
        session.close();
        return order;
    }

    public List<Order> findByUserId(Long user_id){
        List<Order> orders;
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("FROM Order where user_id = :user_id");
        query.setParameter("user_id", user_id);
        orders = query.getResultList();
        tx.commit();
        session.close();
        return orders;
    }
}
