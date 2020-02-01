package alexrm84.repositories;

import alexrm84.entities.User;

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
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @Override
    public User insert(User user){
        em.persist(user);
        return em.find(User.class, user);
    }

    @Override
    public void update(User user){
        em.merge(user);
    }

    @Override
    public void delete(Long id){
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }
    }

    @Override
    public User findById(Long id){
        return em.find(User.class, id);
    }

    @Override
    public List<User> findAll(){
        return em.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public User findByPhone(String phone){
        return (User) em.createQuery("FROM User WHERE phone=:phone")
                .setParameter("phone", phone)
                .getSingleResult();
    }
}
