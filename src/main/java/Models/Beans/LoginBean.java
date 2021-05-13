package Models.Beans;

import Utils.BCryptUtil;

public class LoginBean {
    private final String email;
    private final String hashedPassword;

    public LoginBean(String email, String password) {
        this.email = email;
        this.hashedPassword = BCryptUtil.hash(password);
    }

    public String getEmail() {
        return email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }


}
