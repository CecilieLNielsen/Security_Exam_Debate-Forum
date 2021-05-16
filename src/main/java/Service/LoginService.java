package Service;

import Dependencies.MysqlConnection;
import Models.Beans.LoginBean;
import Persistence.DAO.LoginDao;
import Persistence.LoginDaoImpl;
import Service.Interfaces.ILoginService;

import javax.persistence.EntityManagerFactory;

public class LoginService implements ILoginService {

    private static LoginService service;
    private final LoginDao LOGIN_DAO;

    private LoginService() {
        EntityManagerFactory emf = new MysqlConnection().createEntityManagerFactory();
        LOGIN_DAO = LoginDaoImpl.getInstance(emf);
    }

    public static LoginService getInstance() {
        if (service == null)
            service = new LoginService();
        return service;
    }

    @Override
    public boolean verifyCredentials(LoginBean loginCredentials) {
        return LOGIN_DAO.verifyCredentials(loginCredentials);
    }

    @Override
    public boolean logout() {
        return false;
    }

    @Override
    public boolean isLoggedin() {
        return false;
    }
}
