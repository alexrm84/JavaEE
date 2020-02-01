package alexrm84.controllers;

import alexrm84.entities.DAO.UserDAO;
import alexrm84.services.UserService;
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
    private UserDAO user;

    @Inject
    private UserService userService;

    public String showUserPage(){
        return "/user.xhtml?faces-redirect=true";
    }

    public String addUser(){
        this.user = new UserDAO();
        return "/newUser.xhtml?faces-redirect=true";
    }

    public String saveUser(){
        userService.insert(this.user);
        return "/user.xhtml?faces-redirect=true";
    }

    public List<UserDAO> getUsers(){
        return userService.findAll();
    }
}
