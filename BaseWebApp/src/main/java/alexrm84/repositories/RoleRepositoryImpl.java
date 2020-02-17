package alexrm84.repositories;

import alexrm84.entities.Role;
import alexrm84.entities.User;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@TransactionAttribute
public class RoleRepositoryImpl implements RoleRepository {

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @Override
    public void insert(Role role){
        em.persist(role);
    }

    @Override
    public void update(Role user){
        em.merge(user);
    }

    @Override
    public void delete(Long id){
        Role role = em.find(Role.class, id);
        if (role != null) {
            em.remove(role);
        }
    }

    @Override
    public Role findById(Long id){
        return em.find(Role.class, id);
    }

    @Override
    public List<Role> findAll(){
        return em.createQuery("FROM Role", Role.class).getResultList();
    }

    @Override
    public Role findByName(String name){
        return (Role) em.createQuery("FROM Role WHERE name=:name")
                .setParameter("phone", name)
                .getSingleResult();
    }
}
