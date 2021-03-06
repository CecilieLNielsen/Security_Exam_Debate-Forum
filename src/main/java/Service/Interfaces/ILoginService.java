package Service.Interfaces;

import Models.Beans.LoginBean;
import Models.Beans.RegisterBean;
import Models.Beans.UserBean;

public interface ILoginService {
    UserBean verifyCredentialsAndLogin(LoginBean loginCredentials);
    void register(RegisterBean credentials);
}
