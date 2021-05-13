package Persistence;

import Models.DTO.ThreadDTO;
import Models.DTO.ThreadWithCommentsDTO;
import Models.Entities.Thread;
import Models.Entities.User;
import Persistence.DAO.ThreadDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class ThreadDaoImpl implements ThreadDao {

    /**
     * The singleton instance
     */
    private static ThreadDaoImpl instance;
    private static EntityManagerFactory emf;

    /**
     * Private constructor to ensure singleton pattern
     */
    private ThreadDaoImpl(EntityManagerFactory _emf) {
        emf = _emf;
    }

    /**
     * Get singleton instance to ensure singleton pattern
     *
     * @return the singleton instance
     */
    public static ThreadDaoImpl getInstance(EntityManagerFactory _emf) {
        if (instance == null)
            instance = new ThreadDaoImpl(_emf);
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public int createThread(ThreadDTO thread) {
        EntityManager em = getEntityManager();
        Thread threadEntity = new Thread(thread);
        // TODO: Remove hardcoded value and user logged in user
        threadEntity.setAuthor(em.find(User.class, 5));
        // User with id 5 should be Bertilda Monteson
        try {
            em.getTransaction().begin();
            em.persist(threadEntity);
            em.getTransaction().commit();
            return threadEntity.getId();
        } finally {
            em.close();
        }
    }

    @Override
    public List<ThreadDTO> getAllThreads() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Thread> query = em.createQuery("SELECT t FROM Thread t", Thread.class);
            List<Thread> res = query.getResultList();
            List<ThreadDTO> threads = new ArrayList<>();
            for (Thread thread : res) {
                threads.add(new ThreadDTO(thread));
            }
            return threads;
        } finally {
            em.close();
        }
    }

    @Override
    public ThreadWithCommentsDTO getThreadById(int id) {
        EntityManager em = getEntityManager();
        try {
            Thread thread = em.find(Thread.class, id);
            return new ThreadWithCommentsDTO(thread);
        } finally {
            em.close();
        }
    }

    @Override
    public int updateThread(ThreadDTO updatedThread) {
        EntityManager em = getEntityManager();
        Thread thread = em.find(Thread.class, updatedThread.getId());
        thread.setAll(updatedThread);
        try {
            em.getTransaction().begin();
            em.merge(thread);
            em.getTransaction().commit();
            return thread.getId();
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteThread(int id) {
        EntityManager em = emf.createEntityManager();
        Thread thread = em.find(Thread.class, id);
        try {
            em.getTransaction().begin();
            em.remove(thread);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}