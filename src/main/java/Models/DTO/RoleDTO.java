package Models.DTO;

import Models.Entities.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleDTO {

    private int id;
    private String role;
    private List<UserDTO> users;

    /**
     * Constructor for converting a role entity into a roleDTO
     * Used when retrieve a user from DB
     *
     * @param role
     */
    public RoleDTO(Role role) {
        this.id = role.getId();
        this.role = role.getRole();
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

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    /**
     * Only use from inside userDTO
     *
     * @param userDTO
     */
    public void addUser(UserDTO userDTO) {
        if (users == null)
            users = new ArrayList<>();
        users.add(userDTO);
    }
}
