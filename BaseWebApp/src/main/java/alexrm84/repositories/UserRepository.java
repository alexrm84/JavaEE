package alexrm84.repositories;

import alexrm84.entities.User;
import alexrm84.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ApplicationScoped
public class UserRepository {
    private Session session;

    public User insert(User user){
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        user = (User) session.save(user);
        tx.commit();
        session.close();
        return user;
    }

    public void update(User user){
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();
        session.close();
    }

    public void delete(Long id){
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(session.load(User.class, id));
        tx.commit();
        session.close();
    }

    public User findById(Long id){
        User user;
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        user = session.get(User.class, id);
        tx.commit();
        session.close();
        return user;
    }

    public List<User> findAll(){
        List<User> users;
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
        users = session.createQuery("FROM User", User.class).getResultList();
        tx.commit();
        session.close();
        return users;
    }

    public User findByPhone(String phone){
        User user;
        session = HibernateUtil.getInstance().getSf().openSession();
        Transaction tx = session.beginTransaction();
//        Query query = session.createQuery("FROM User WHERE phone=:phone", User.class);
//        query.setParameter("phone", phone);
//        user = (User) query.getSingleResult();
        user = session.createQuery("FROM User", User.class).getSingleResult();
        tx.commit();
        session.close();
        return user;
    }
}
