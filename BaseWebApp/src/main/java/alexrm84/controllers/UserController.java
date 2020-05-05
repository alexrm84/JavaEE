package alexrm84.controllers;

import alexrm84.entities.DAO.UserDAO;
import alexrm84.services.UserService;
import alexrm84.utils.Logger;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;
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

    @Interceptors({Logger.class})
    public String showUserPage(){
        return "/user.xhtml?faces-redirect=true";
    }

    @Interceptors({Logger.class})
    public String addUser(){
        this.user = new UserDAO();
        return "/newUser.xhtml?faces-redirect=true";
    }

    @Interceptors({Logger.class})
    public String saveUser(){
        userService.insert(this.user);
        return "/user.xhtml?faces-redirect=true";
    }

    @Interceptors({Logger.class})
    public List<UserDAO> getUsers(){
        return userService.findAll();
    }
}
