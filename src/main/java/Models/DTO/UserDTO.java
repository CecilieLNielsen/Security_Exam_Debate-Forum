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
        email = user.getEmail();
        username = user.getUsername();
        role = new RoleDTO(user.getRole());
    }

    /**
     * Use for create new thread manual
     */
    public UserDTO(String email, String username, String hashedPassword) {
        this.email = email;
        this.username = username;
        this.hashedPassword = hashedPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        if (role != null)
            role.addUser(this);
        this.role = role;
    }
}
