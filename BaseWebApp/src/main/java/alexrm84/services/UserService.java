package alexrm84.services;

import alexrm84.entities.DAO.UserDAO;
import alexrm84.entities.User;
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
    private RoleService roleService;

    @Inject
    private UserRepository userRepository;

    public void insert(UserDAO userDAO){
        userRepository.insert(convertFromDao(userDAO));
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

    public UserDAO findByLogin(String login){
        return convertToDao(userRepository.findByLogin(login));
    }

    public UserDAO convertToDao(User user){
        return new UserDAO(user.getId(),
                user.getLogin(),
                user.getPassword(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                null,
                null);
    }

    public User convertFromDao(UserDAO userDAO) {
        return new User(userDAO.getId(),
                userDAO.getLogin(),
                userDAO.getPassword(),
                userDAO.getEmail(),
                userDAO.getFirstName(),
                userDAO.getLastName(),
                null,
                userDAO.getRoleDAOS().stream().map(r -> roleService.convertFromDao(r)).collect(Collectors.toList()));
    }
}
