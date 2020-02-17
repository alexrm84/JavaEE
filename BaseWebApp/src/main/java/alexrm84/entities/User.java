package alexrm84.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 5895087542723435578L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_roles",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;


    public User(String login, String firstName) {
        this.login = login;
        this.firstName = firstName;
    }

    public User(String login, String password, String email, String firstName, String lastName, List<Order> orders) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.orders = orders;
    }

    public User(Long id, String login, String password, String email, String firstName, String lastName, List<Order> orders, List<Role> roles) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.orders = orders;
        this.roles = roles;
    }
}
