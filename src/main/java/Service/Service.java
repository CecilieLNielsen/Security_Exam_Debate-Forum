package Service;

import Models.CommentDTO;
import Models.ThreadDTO;
import Models.ThreadWithCommentsDTO;
import Persistence.CommentDaoImpl;
import Persistence.DAO.CommentDao;
import Persistence.DAO.ThreadDao;
import Persistence.ThreadDaoImpl;

import java.util.List;

public class Service implements IThreadService, ICommentService{

    private ThreadDao threadDao;
    private CommentDao commentDao;

    public Service() {
        threadDao = new ThreadDaoImpl();
        commentDao = new CommentDaoImpl();
    }

    @Override
    public int createThread(ThreadDTO thread) {
        return threadDao.createThread(thread);
    }

    @Override
    public List<ThreadDTO> getAllThreads() {
        return threadDao.getAllThreads();
    }

    @Override
    public ThreadWithCommentsDTO getThreadWithCommentsById(int id) {
        ThreadDTO thread = threadDao.getThreadById(id);
        List<CommentDTO> comments = commentDao.getAllCommentsByThreadId(id);
        return new ThreadWithCommentsDTO(thread, comments);
    }

    @Override
    public int updateThread(ThreadDTO thread) {
        return threadDao.updateThread(thread);
    }

    @Override
    public void deleteThread(int id) {
        threadDao.deleteThread(id);
    }

    @Override
    public int createComment(CommentDTO comment) {
        return commentDao.createComment(comment);
    }

    @Override
    public int updateComment(CommentDTO comment) {
        return commentDao.updateComment(comment);
    }

    @Override
    public void deleteComment(int id) {
        commentDao.deleteComment(id);
    }
}
