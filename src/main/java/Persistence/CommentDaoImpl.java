package Persistence;

import Models.DTO.CommentDTO;
import Models.Entities.Comment;
import Models.Entities.Thread;
import Persistence.DAO.CommentDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class CommentDaoImpl implements CommentDao {

    /**
     * The singleton instance
     */
    private static CommentDaoImpl instance;
    private static EntityManagerFactory emf;

    /**
     * Private constructor to ensure singleton pattern
     */
    private CommentDaoImpl(EntityManagerFactory _emf) {
        emf = _emf;
    }

    public static CommentDaoImpl getInstance(EntityManagerFactory _emf) {
        if (instance == null)
            instance = new CommentDaoImpl(_emf);
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public int createComment(CommentDTO comment) {
        EntityManager em = getEntityManager();
        Comment commentEntity = new Comment(comment);
        try {
            em.getTransaction().begin();
            em.persist(commentEntity);
            em.getTransaction().commit();
            return commentEntity.getId();
        } finally {
            em.close();
        }
    }

    @Override
    public int updateComment(CommentDTO updatedComment) {
        EntityManager em = getEntityManager();
        Comment comment = em.find(Comment.class, updatedComment.getId());
        comment.setAll(updatedComment);
        try {
            em.getTransaction().begin();
            em.merge(comment);
            em.getTransaction().commit();
            return comment.getId();
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteComment(int id) {
        EntityManager em = emf.createEntityManager();
        Comment comment = em.find(Comment.class, id);
        try {
            em.getTransaction().begin();
            em.remove(comment);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}