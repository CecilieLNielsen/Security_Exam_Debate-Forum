package Models.DTO;

import Models.Entities.User;

public class UserDTO {

    private int id;
    private String email;
    private String username;
    private String hashedPassword;
    private RoleDTO role;

    /**
     * Constructor for converting a user entity into a userDTO
     *
     * @param user
     */
    public UserDTO(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.role = new RoleDTO(user.getRole());
    }

    /**
     * Use for create new user
     */
    public UserDTO(String email, String username, String hashedPassword) {
        this.email = email;
        this.username = username;
        this.hashedPassword = hashedPassword;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }
}
