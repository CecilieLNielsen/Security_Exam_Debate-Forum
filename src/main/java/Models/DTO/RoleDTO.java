package Models.DTO;

import Models.Entities.Role;

public class RoleDTO {

    private int id;
    private String role;

    /**
     * Constructor for converting a role entity into a roleDTO
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
}
