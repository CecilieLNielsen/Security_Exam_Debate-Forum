package Utils;

import Dependencies.MysqlConnection;
import Models.Entities.Comment;
import Models.Entities.Role;
import Models.Entities.Thread;
import Models.Entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Date;

public class SetupStartData {

    private static Role role_user, role_admin;
    private static User user_01, user_02, user_03, user_04, user_05, user_06, user_07, user_08, user_09;
    private static Thread thread_01, thread_02, thread_03;
    private static Comment comment_01, comment_02, comment_03, comment_04, comment_05, comment_06;

    public static void main(String[] args) {
        EntityManagerFactory emf = new MysqlConnection().createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        resetDatabase(em);
        createRoles(em);
        createUsers(em);
        createThreads(em);
        createComments(em);
    }

    private static void createComments(EntityManager em) {
        comment_01 = new Comment(user_04, "You do that, then this and lastly that");
        comment_02 = new Comment(user_01, "Ohh Thanks!");
        comment_03 = new Comment(user_05, "Visit this page (some url to unknown places). That is a very great recipe.");
        comment_04 = new Comment(user_06, "Hehe, so funny...");
        comment_05 = new Comment(user_07, "Dude! That's awesome!");
        comment_06 = new Comment(user_08, "Hello James, I find your cat very funny.");

        String currentDate = new Date().toString();
        comment_01.setDateOfCreation(currentDate);
        comment_01.setDateOfUpdate(currentDate);
        currentDate = new Date().toString();
        comment_02.setDateOfCreation(currentDate);
        comment_02.setDateOfUpdate(currentDate);
        currentDate = new Date().toString();
        comment_03.setDateOfCreation(currentDate);
        comment_03.setDateOfUpdate(currentDate);
        currentDate = new Date().toString();
        comment_04.setDateOfCreation(currentDate);
        comment_04.setDateOfUpdate(currentDate);
        currentDate = new Date().toString();
        comment_05.setDateOfCreation(currentDate);
        comment_05.setDateOfUpdate(currentDate);
        currentDate = new Date().toString();
        comment_06.setDateOfCreation(currentDate);
        comment_06.setDateOfUpdate(currentDate);

        thread_01.addComment(comment_01);
        thread_01.addComment(comment_02);
        thread_02.addComment(comment_03);
        thread_03.addComment(comment_04);
        thread_03.addComment(comment_05);
        thread_03.addComment(comment_06);


        em.getTransaction().begin();
        em.persist(comment_01);
        em.persist(comment_02);
        em.persist(comment_03);
        em.persist(comment_04);
        em.persist(comment_05);
        em.persist(comment_06);
        em.getTransaction().commit();
    }

    private static void createThreads(EntityManager em) {
        thread_01 = new Thread("JSP help", "Code", user_01, "How to make JSP? I have been struggling with creating simple pages");
        thread_02 = new Thread("Cake recipes", "Food", user_02, "I need a good recipe for chocolate brownie cake");
        thread_03 = new Thread("Funny cats", "Animal", user_03, "My cat is doing this funny thing when I put a cucumber in front of it");

        String currentDate = new Date().toString();
        thread_01.setDateOfCreation(currentDate);
        thread_01.setDateOfUpdate(currentDate);
        currentDate = new Date().toString();
        thread_02.setDateOfCreation(currentDate);
        thread_02.setDateOfUpdate(currentDate);
        currentDate = new Date().toString();
        thread_03.setDateOfCreation(currentDate);
        thread_03.setDateOfUpdate(currentDate);

        em.getTransaction().begin();
        em.persist(thread_01);
        em.persist(thread_02);
        em.persist(thread_03);
        em.getTransaction().commit();
    }

    private static void createUsers(EntityManager em) {
        /**
         * NEVER push correct password to Github
         */
        String password_01 = BCryptUtil.hash("change_me");
        String password_02 = BCryptUtil.hash("change_me");
        String password_03 = BCryptUtil.hash("change_me");
        String password_04 = BCryptUtil.hash("change_me");
        String password_05 = BCryptUtil.hash("change_me");
        String password_06 = BCryptUtil.hash("change_me");
        String password_07 = BCryptUtil.hash("change_me");
        String password_08 = BCryptUtil.hash("change_me");
        String password_09 = BCryptUtil.hash("change_me");

        user_01 = new User("cj@gmail.com", "Clay Jensen", password_01);
        user_02 = new User("bm@gmail.com", "Bertilda Monteson", password_02);
        user_03 = new User("jf@gmail.com", "James Ford", password_03);
        user_04 = new User("pj@gmail.com", "Peta Jensen", password_04);
        user_05 = new User("gr@gmail.com", "Geminine Reclif", password_05);
        user_06 = new User("ka@gmail.com", "Kate Austen", password_06);
        user_07 = new User("hr@gmail.com", "Hugo Reyes", password_07);
        user_08 = new User("jl@gmail.com", "John Locke", password_08);
        user_09 = new User("admin@gmail.com", "Admin", password_09);

        user_01.setRole(role_user);
        user_02.setRole(role_user);
        user_03.setRole(role_user);
        user_04.setRole(role_user);
        user_05.setRole(role_user);
        user_06.setRole(role_user);
        user_07.setRole(role_user);
        user_08.setRole(role_user);
        user_09.setRole(role_admin);

        em.getTransaction().begin();
        em.persist(user_01);
        em.persist(user_02);
        em.persist(user_03);
        em.persist(user_04);
        em.persist(user_05);
        em.persist(user_06);
        em.persist(user_07);
        em.persist(user_08);
        em.persist(user_09);
        em.getTransaction().commit();
    }

    private static void createRoles(EntityManager em) {
        role_user = new Role("USER");
        role_admin = new Role("ADMIN");

        em.getTransaction().begin();
        em.persist(role_user);
        em.persist(role_admin);
        em.getTransaction().commit();
    }

    private static void resetDatabase(EntityManager em) {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Comment ").executeUpdate();
        em.createQuery("DELETE FROM Thread").executeUpdate();
        em.createQuery("DELETE FROM User").executeUpdate();
        em.createQuery("DELETE FROM Role").executeUpdate();
        em.createNativeQuery("ALTER TABLE `COMMENT` AUTO_INCREMENT = 1").executeUpdate();
        em.createNativeQuery("ALTER TABLE `THREAD` AUTO_INCREMENT = 1").executeUpdate();
        em.createNativeQuery("ALTER TABLE `USER` AUTO_INCREMENT = 1").executeUpdate();
        em.createNativeQuery("ALTER TABLE `ROLE` AUTO_INCREMENT = 1").executeUpdate();
        em.getTransaction().commit();
    }
}