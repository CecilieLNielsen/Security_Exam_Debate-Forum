package Persistence;

import Models.Beans.LoginBean;
import Models.Beans.RegisterBean;
import Models.Beans.UserBean;
import Models.Entities.Role;
import Models.Entities.User;
import Persistence.DAO.LoginDao;
import Utils.BCryptUtil;
import Utils.LoggingUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.logging.Level;

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
        LoggingUtil.log(Level.INFO, String.format("Verifing login credentails for %s", loginCredentials.getEmail()));
        EntityManager em = getEntityManager();
        TypedQuery<String> queryPassword = em.createQuery("SELECT u.hashedPassword FROM User u WHERE u.email = :email", String.class);
        queryPassword.setParameter("email", loginCredentials.getEmail());
        try {
            String storedHashedPassword = queryPassword.getSingleResult();
            boolean correctPassword = BCryptUtil.verify(loginCredentials.getPassword(), storedHashedPassword);
            if (correctPassword) {
                LoggingUtil.log(Level.FINE, String.format("Verifing for %s went well", loginCredentials.getEmail()));
                TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
                query.setParameter("email", loginCredentials.getEmail());
                User user = query.getSingleResult();
                return new UserBean(user);
            } else {
                LoggingUtil.log(Level.WARNING, String.format("Verifing for %s went bad since password was wrong", loginCredentials.getEmail()));
                return null;
            }
        } catch (NoResultException e) {
            LoggingUtil.log(Level.SEVERE, String.format("Verifing for %s went bad since email doesn't exist.", loginCredentials.getEmail()));
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public void register(RegisterBean credentials) {
        EntityManager em = getEntityManager();
        User user = new User(credentials.getEmail(), credentials.getUsername(), BCryptUtil.hash(credentials.getPassword1()));

        try {
            TypedQuery<Role> query = em.createQuery("SELECT r FROM Role r WHERE r.role = :role", Role.class);
            // Hardcoded USER to give all new registered user the USER role
            query.setParameter("role", "USER");
            Role role = query.getSingleResult();
            user.setRole(role);

            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
