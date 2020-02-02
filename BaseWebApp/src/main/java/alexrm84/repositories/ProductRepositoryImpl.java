package alexrm84.repositories;

import alexrm84.entities.Product;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@TransactionAttribute
public class ProductRepositoryImpl implements ProductRepository {

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @Override
    public void insert(Product product){
        em.persist(product);
    }

    @Override
    public void update(Product product){
        em.merge(product);
    }

    @Override
    public void delete(Long id){
        Product product = em.find(Product.class, id);
        if (product != null) {
            em.remove(product);
        }
    }

    @Override
    public Product findById(Long id){
        return em.find(Product.class, id);
    }

    @Override
    public List<Product> findAll(){
        return em.createQuery("FROM Product", Product.class).getResultList();
    }
}
