package alexrm84.repositories;

import alexrm84.entities.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserRepository {
    void insert(User user);
    void update(User user);
    void delete(Long id);
    User findById(Long id);
    List<User> findAll();
    User findByLogin(String login);
}
