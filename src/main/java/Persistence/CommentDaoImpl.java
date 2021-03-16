package Persistence;

import Models.CommentDTO;
import Persistence.DAO.CommentDao;

import java.util.List;

public class CommentDaoImpl implements CommentDao {
    @Override
    public int createComment(CommentDTO comment) {
        return 0;
    }

    @Override
    public List<CommentDTO> getAllCommentsByThreadId(int threadId) {
        return null;
    }

    @Override
    public int updateComment(CommentDTO comment) {
        return 0;
    }

    @Override
    public void deleteComment(int id) {

    }
}
