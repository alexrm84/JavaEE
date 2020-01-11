package alexrm84.repositories;

import alexrm84.entities.Product;
import alexrm84.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.transaction.Transactional;
import java.util.List;

public class OrderRepository {
    private Session session;

//    @Transactional
//    public void insert(Product product){
//        session = HibernateUtil.getInstance().getSf().openSession();
//        session.save(product);
//        session.close();
//    }
//
////    @Transactional
//    public void update(Product product){
//        session = HibernateUtil.getInstance().getSf().openSession();
//        Transaction tx = session.beginTransaction();
//        session.update(product);
//        tx.commit();
//        session.close();
//    }
//
////    @Transactional
//    public void delete(Long id){
//        session = HibernateUtil.getInstance().getSf().openSession();
//        Transaction tx = session.beginTransaction();
//        session.delete(session.load(Product.class, id));
//        tx.commit();
//        session.close();
//    }
//
//    @Transactional
//    public Product findById(Long id){
//        Product product;
//        session = HibernateUtil.getInstance().getSf().openSession();
//        product = session.get(Product.class, id);
//        session.close();
//        return product;
//    }
//
//    @Transactional
//    public List<Product> findAll(){
//        List<Product> products;
//        session = HibernateUtil.getInstance().getSf().openSession();
//        products = session.createQuery("FROM Product", Product.class).getResultList();
//        session.close();
//        return products;
//    }
}
