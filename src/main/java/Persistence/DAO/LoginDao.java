package Persistence.DAO;

import Models.Beans.LoginBean;
import Models.Beans.UserBean;

public interface LoginDao {
    UserBean verifyCredentialsAndLogin(LoginBean loginCredentials);
}