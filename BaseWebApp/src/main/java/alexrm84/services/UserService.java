package alexrm84.services;

import alexrm84.entities.DAO.ProductDAO;
import alexrm84.entities.DAO.UserDAO;
import alexrm84.entities.Product;
import alexrm84.entities.User;
import alexrm84.repositories.ProductRepository;
import alexrm84.repositories.UserRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class UserService {

    @Inject
    private OrderService orderService;

    @Inject
    private UserRepository userRepository;

    public UserDAO insert(UserDAO userDAO){
        return convertToDao(userRepository.insert(convertFromDao(userDAO)));
    }

    public void update(UserDAO userDAO){
        userRepository.update(convertFromDao(userDAO));
    }

    public void delete(Long id){
        userRepository.delete(id);
    }

    public UserDAO findById(Long id){
        return convertToDao(userRepository.findById(id));
    }

    public List<UserDAO> findAll(){
        return userRepository.findAll().stream().map(u -> convertToDao(u)).collect(Collectors.toList());
    }

    public UserDAO findByPhone(String phone){
        return convertToDao(userRepository.findByPhone(phone));
    }

    public UserDAO convertToDao(User user){
        return new UserDAO(user.getId(),
                user.getPhone(),
                user.getPassword(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                null);
    }

    public User convertFromDao(UserDAO userDAO) {
        return new User(userDAO.getId(),
                userDAO.getPhone(),
                userDAO.getPassword(),
                userDAO.getEmail(),
                userDAO.getFirstName(),
                userDAO.getLastName(),
                null);
    }
}
