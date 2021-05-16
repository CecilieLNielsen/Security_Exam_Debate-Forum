package Models.Beans;

import Models.Entities.User;

public class UserBean {

    private final String username;
    private final String role;

    public UserBean(User user) {
        this.username = user.getUsername();
        this.role = user.getRole().getRole();
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }
}
