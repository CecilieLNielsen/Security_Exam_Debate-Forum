package Models.Entities;

import Models.DTO.RoleDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Role {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String role;
    @OneToMany(mappedBy = "role")
    private List<User> users;

    /**
     * Empty constructor for JPA
     */
    public Role() {
    }

    /**
     * Constructor for manual creating a role
     *
     * @param role
     */
    public Role(String role) {
        this.role = role;
    }

    /**
     * Constructor for converting a role DTO into a role entity
     *
     * @param roleDTO
     */
    public Role(RoleDTO roleDTO) {
        this.id = roleDTO.getId();
        this.role = roleDTO.getRole();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    /**
     * Only use from inside User
     *
     * @param user
     */
    public void addUser(User user) {
        if (users == null)
            users = new ArrayList<>();
        users.add(user);
    }
}
