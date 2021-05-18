package Models.Beans;

public class RegisterBean {

    private final String email;
    private final String username;
    private final String password1;
    private final String password2;

    public RegisterBean(String email, String username, String password1, String password2) {
        this.email = email;
        this.username = username;
        this.password1 = password1;
        this.password2 = password2;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword1() {
        return password1;
    }

    public String getPassword2() {
        return password2;
    }
}
