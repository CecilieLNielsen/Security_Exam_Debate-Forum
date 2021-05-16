package Persistence.DAO;

import Models.Beans.LoginBean;

public interface LoginDao {
    boolean verifyCredentials(LoginBean loginCredentials);
}