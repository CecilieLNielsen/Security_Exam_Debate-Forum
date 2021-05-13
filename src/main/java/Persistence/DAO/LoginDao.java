package Persistence.DAO;

import Models.Beans.LoginBean;
import Models.Entities.User;

public interface LoginDao {
    boolean verifyCredentials(LoginBean loginCredentials);
}