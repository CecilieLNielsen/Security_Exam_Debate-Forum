package Utils;

import Dependencies.MysqlConnection;
import Models.Comment;
import Models.CommentDTO;
import Models.Thread;
import Models.ThreadDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupStartData {


    public static void main(String[] args) {
        EntityManagerFactory emf = new MysqlConnection().createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        Thread thread_01 = new Thread(new ThreadDTO("JSP help", "Code", "Clay Jensen", "How to make JSP? I have been struggling with creating simple pages"));
        Thread thread_02 = new Thread(new ThreadDTO("Cake recipes", "Food", "Bertilda Monteson", "I need a good recipe for chocolate brownie cake"));
        Thread thread_03 = new Thread(new ThreadDTO("Funny cats", "Animal", "James Ford", "My cat is doing this funny thing when I put a cucumber in front of it"));

        Comment comment_01_01 = new Comment(new CommentDTO("Peta Jensen", "You do that, then this and lastly that"));
        Comment comment_01_02 = new Comment(new CommentDTO("Clay Jensen", "Ohh Thanks!"));
        Comment comment_02_01 = new Comment(new CommentDTO("Geminine Reclif", "Visit this page (some url to unknown places). That is a very great recipe."));
        Comment comment_03_01 = new Comment(new CommentDTO("Kate", "Hehe, so funny..."));
        Comment comment_03_02 = new Comment(new CommentDTO("Hugo", "Dude! That's awesome!"));
        Comment comment_03_03 = new Comment(new CommentDTO("John", "Hello James, I find your cat very funny."));

        thread_01.addComment(comment_01_01);
        thread_01.addComment(comment_01_02);
        thread_02.addComment(comment_02_01);
        thread_03.addComment(comment_03_01);
        thread_03.addComment(comment_03_02);
        thread_03.addComment(comment_03_03);

        em.getTransaction().begin();

        em.createQuery("DELETE FROM Comment ").executeUpdate();
        em.createQuery("DELETE FROM Thread").executeUpdate();
        em.createNativeQuery("ALTER TABLE `COMMENT` AUTO_INCREMENT = 1").executeUpdate();
        em.createNativeQuery("ALTER TABLE `THREAD` AUTO_INCREMENT = 1").executeUpdate();

        em.persist(thread_01);
        em.persist(thread_02);
        em.persist(thread_03);

        em.getTransaction().commit();
    }
}