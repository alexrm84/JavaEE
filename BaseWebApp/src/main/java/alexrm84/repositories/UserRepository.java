package alexrm84.repositories;

import alexrm84.entities.User;

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
public class UserRepository {

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    public User insert(User user){
        em.persist(user);
        return em.find(User.class, user);
    }

    public void update(User user){
        em.merge(user);
    }

    public void delete(Long id){
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }
    }

    public User findById(Long id){
        return em.find(User.class, id);
    }

    public List<User> findAll(){
        return em.createQuery("FROM User", User.class).getResultList();
    }

    public User findByPhone(String phone){
        return (User) em.createQuery("FROM User WHERE phone=:phone")
                .setParameter("phone", phone)
                .getSingleResult();
    }
}
