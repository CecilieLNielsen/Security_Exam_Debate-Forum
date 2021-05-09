package Persistence.DAO;

import Models.CommentDTO;

public interface CommentDao {
    int createComment(CommentDTO comment);

    int updateComment(CommentDTO comment);

    void deleteComment(int id);
}
