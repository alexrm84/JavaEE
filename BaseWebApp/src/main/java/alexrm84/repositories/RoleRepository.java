package alexrm84.repositories;

import alexrm84.entities.Role;

import javax.ejb.Local;
import java.util.List;

@Local
public interface RoleRepository {
    void insert(Role role);
    void update(Role role);
    void delete(Long id);
    Role findById(Long id);
    List<Role> findAll();
    Role findByName(String name);
}
