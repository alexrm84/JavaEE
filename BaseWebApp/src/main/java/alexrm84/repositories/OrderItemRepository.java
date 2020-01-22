package alexrm84.repositories;

import alexrm84.entities.Order;
import alexrm84.entities.OrderItem;
import alexrm84.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.Query;
import java.util.List;

@Named
@ApplicationScoped
public class OrderItemRepository {
    private Session session;

    public void insert(OrderItem orderItem){
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        session.save(orderItem);
        tx.commit();
        session.close();
    }

    public void update(OrderItem orderItem){
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        session.update(orderItem);
        tx.commit();
        session.close();
    }

    public void delete(Long id){
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(session.load(OrderItem.class, id));
        tx.commit();
        session.close();
    }

    public OrderItem findById(Long id){
        OrderItem orderItem;
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        orderItem = session.get(OrderItem.class, id);
        tx.commit();
        session.close();
        return orderItem;
    }

    public List<OrderItem> findByOrderId(Long order_id){
        List<OrderItem> orderItems;
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("FROM OrderItem where order_id = :order_id");
        query.setParameter("order_id", order_id);
        orderItems = query.getResultList();
        tx.commit();
        session.close();
        return orderItems;
    }

}
