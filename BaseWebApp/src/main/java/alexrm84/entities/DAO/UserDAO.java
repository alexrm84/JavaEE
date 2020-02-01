package alexrm84.entities.DAO;

import alexrm84.entities.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDAO implements Serializable {
    private static final long serialVersionUID = 2707438131023882427L;

    private Long id;
    private String phone;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private List<OrderDAO> orderDAOS;

    public UserDAO(String phone, String firstName) {
        this.phone = phone;
        this.firstName = firstName;
    }

    public UserDAO(Long id, String phone, String password, String email, String firstName, String lastName, List<OrderDAO> orderDAOS) {
        this.id = id;
        this.phone = phone;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.orderDAOS = orderDAOS;
    }

    public UserDAO(String phone, String password, String email, String firstName, String lastName, List<OrderDAO> orderDAOS) {
        this.phone = phone;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.orderDAOS = orderDAOS;
    }

}
