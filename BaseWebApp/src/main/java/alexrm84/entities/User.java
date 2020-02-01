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

    @Column(name = "phone")
    private String phone;

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

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "users_roles",
//                joinColumns = @JoinColumn(name = "user_id"),
//                inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Collection<Role> roles;


    public User(String phone, String firstName) {
        this.phone = phone;
        this.firstName = firstName;
    }

    public User(String phone, String password, String email, String firstName, String lastName, List<Order> orders) {
        this.phone = phone;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.orders = orders;
    }

    public User(Long id, String phone, String password, String email, String firstName, String lastName, List<Order> orders) {
        this.id = id;
        this.phone = phone;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.orders = orders;
    }
}
