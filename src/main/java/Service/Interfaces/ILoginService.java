package Service.Interfaces;

import Models.Beans.LoginBean;

public interface ILoginService {
    boolean verifyCredentials(LoginBean loginCredentials);

    boolean logout();

    boolean isLoggedin();
}
