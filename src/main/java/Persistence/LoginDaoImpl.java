package Persistence;

import Models.Beans.LoginBean;
import Models.Beans.UserBean;
import Models.Entities.User;
import Persistence.DAO.LoginDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class LoginDaoImpl implements LoginDao {

    /**
     * The singleton instance
     */
    private static LoginDaoImpl instance;
    private static EntityManagerFactory emf;

    /**
     * Private constructor to ensure singleton pattern
     */
    private LoginDaoImpl(EntityManagerFactory _emf) {
        emf = _emf;
    }

    /**
     * Get singleton instance to ensure singleton pattern
     *
     * @return the singleton instance
     */
    public static LoginDaoImpl getInstance(EntityManagerFactory _emf) {
        if (instance == null)
            instance = new LoginDaoImpl(_emf);
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public UserBean verifyCredentialsAndLogin(LoginBean loginCredentials) {
        EntityManager em = getEntityManager();
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.email = :email AND u.hashedPassword = :hashedPassword", User.class);
        query.setParameter("email", loginCredentials.getEmail());
        query.setParameter("hashedPassword", loginCredentials.getHashedPassword());
        try {
            User user = query.getSingleResult();
            return new UserBean(user);
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
}
