package alexrm84.entities.DAO;

import alexrm84.entities.Order;
import alexrm84.entities.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDAO implements Serializable {
    private static final long serialVersionUID = 2707438131023882427L;

    private Long id;
    private String login;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private List<OrderDAO> orderDAOS;
    private List<RoleDAO> roleDAOS;

    public UserDAO(Long id, String login, String password, String email, String firstName, String lastName, List<OrderDAO> orderDAOS, List<RoleDAO> roleDAOS) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.orderDAOS = orderDAOS;
        this.roleDAOS = roleDAOS;
    }
}
