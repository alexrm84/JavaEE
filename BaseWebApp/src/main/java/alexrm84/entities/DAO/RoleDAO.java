package alexrm84.entities.DAO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class RoleDAO implements Serializable {
    private static final long serialVersionUID = -2451708486817482467L;

    private Long id;
    private String name;

    public RoleDAO(String name) {
        this.name = name;
    }

    public RoleDAO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
