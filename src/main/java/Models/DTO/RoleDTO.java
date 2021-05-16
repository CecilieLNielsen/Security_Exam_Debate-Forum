package Models.DTO;

import Models.Entities.Role;

public class RoleDTO {

    private final int id;
    private final String role;

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

    public String getRole() {
        return role;
    }
}
