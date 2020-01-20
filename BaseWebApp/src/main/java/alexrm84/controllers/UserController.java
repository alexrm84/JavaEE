package alexrm84.controllers;

import alexrm84.entities.User;
import alexrm84.repositories.UserRepository;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class UserController implements Serializable {

    private static final long serialVersionUID = -937745244661108420L;

    @Getter
    @Setter
    private User user;

    @Inject
    private UserRepository userRepository;

    public String showUserPage(){
        return "/user.xhtml?faces-redirect=true";
    }

    public String addUser(){
        this.user = new User();
        return "/newUser.xhtml?faces-redirect=true";
    }

    public String saveUser(){
        userRepository.insert(this.user);
        return "/user.xhtml?faces-redirect=true";
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }
}
