package Service;

import Dependencies.MysqlConnection;
import Models.DTO.CommentDTO;
import Models.DTO.ThreadDTO;
import Models.DTO.ThreadWithCommentsDTO;
import Persistence.CommentDaoImpl;
import Persistence.DAO.CommentDao;
import Persistence.DAO.ThreadDao;
import Persistence.ThreadDaoImpl;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class Service implements IThreadService, ICommentService {

    private static Service service;
    private final ThreadDao THREAD_DAO;
    private final CommentDao COMMENT_DAO;

    private Service() {
        EntityManagerFactory emf = new MysqlConnection().createEntityManagerFactory();
        THREAD_DAO = ThreadDaoImpl.getInstance(emf);
        COMMENT_DAO = CommentDaoImpl.getInstance(emf);
    }

    public static Service getInstance() {
        if (service == null)
            service = new Service();
        return service;
    }

    @Override
    public int createThread(ThreadDTO thread) {
        return THREAD_DAO.createThread(thread);
    }

    @Override
    public List<ThreadDTO> getAllThreads() {
        return THREAD_DAO.getAllThreads();
    }

    @Override
    public ThreadWithCommentsDTO getThreadWithCommentsById(int id) {
        return THREAD_DAO.getThreadById(id);
    }

    @Override
    public int updateThread(ThreadDTO thread) {
        return THREAD_DAO.updateThread(thread);
    }

    @Override
    public void deleteThread(int id) {
        THREAD_DAO.deleteThread(id);
    }

    @Override
    public int createComment(CommentDTO comment) {
        return COMMENT_DAO.createComment(comment);
    }

    @Override
    public int updateComment(CommentDTO comment) {
        return COMMENT_DAO.updateComment(comment);
    }

    @Override
    public void deleteComment(int id) {
        COMMENT_DAO.deleteComment(id);
    }
}