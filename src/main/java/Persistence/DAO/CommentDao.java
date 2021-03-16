package Persistence.DAO;

import Models.CommentDTO;

import java.util.List;

public interface CommentDao {
    public int createComment(CommentDTO comment);
    public List<CommentDTO> getAllCommentsByThreadId(int threadId);
    public int updateComment(CommentDTO comment);
    public void deleteComment(int id);
}
