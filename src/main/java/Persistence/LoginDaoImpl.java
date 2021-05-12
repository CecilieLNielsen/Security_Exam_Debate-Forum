package Persistence;

import Dependencies.IMysqlConnection;
import Dependencies.MysqlConnection;
import Models.Entities.User;
import Persistence.DAO.LoginDao;

public class LoginDaoImpl implements LoginDao {

    private final IMysqlConnection imc;

    public LoginDaoImpl() {
        this.imc = new MysqlConnection(); // loose coupling
    }

    @Override
    public boolean verifyCredentials(User user) {
        return false;
    }


}
