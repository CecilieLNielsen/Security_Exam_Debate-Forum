package Persistence;

import Models.DTO.CommentDTO;
import Models.Entities.Comment;
import Persistence.DAO.CommentDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class CommentDaoImpl implements CommentDao {

    /**
     * The singleton instance
     */
    private static CommentDaoImpl commentDaoImpl;
    private static EntityManagerFactory emf;

    /**
     * Private constructor to ensure singleton pattern
     */
    private CommentDaoImpl(EntityManagerFactory _emf) {
        emf = _emf;
    }

    public static CommentDaoImpl getInstance(EntityManagerFactory _emf) {
        if (commentDaoImpl == null)
            commentDaoImpl = new CommentDaoImpl(_emf);
        return commentDaoImpl;
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
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("DELETE FROM Comment c WHERE c.id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}