package Persistence.DAO;

import Models.Beans.LoginBean;
import Models.Beans.RegisterBean;
import Models.Beans.UserBean;

public interface LoginDao {
    UserBean verifyCredentialsAndLogin(LoginBean loginCredentials);
    void register(RegisterBean credentials);
}