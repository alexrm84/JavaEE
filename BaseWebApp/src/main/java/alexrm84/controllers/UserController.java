package alexrm84.controllers;

import alexrm84.entities.DAO.RoleDAO;
import alexrm84.entities.DAO.UserDAO;
import alexrm84.services.RoleService;
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
//@ServletSecurity(@HttpConstraint(rolesAllowed = {"ROLE_ADMIN"}))
public class UserController implements Serializable {

    private static final long serialVersionUID = -937745244661108420L;

    @Getter
    @Setter
    private UserDAO user;

    @Getter
    @Setter
    private List<UserDAO> users;

    @Getter
    @Setter
    private List<RoleDAO> roles;

    @Inject
    private UserService userService;

    @Inject
    private RoleService roleService;

    public void preloadVariables() {
        this.users = userService.findAll();
        this.roles = roleService.findAll();
    }

    @Interceptors({Logger.class})
    public String showUserPage(){
        return "/protected/user.xhtml?faces-redirect=true";
    }

    @Interceptors({Logger.class})
    public String addUser(){
        this.user = new UserDAO();
        return "/protected/newUser.xhtml?faces-redirect=true";
    }

    @Interceptors({Logger.class})
    public String saveUser(){
        userService.insert(this.user);
        return "/protected/user.xhtml?faces-redirect=true";
    }
}
