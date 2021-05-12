package Persistence.DAO;

import Models.DTO.CommentDTO;

public interface CommentDao {
    int createComment(CommentDTO comment);

    int updateComment(CommentDTO comment);

    void deleteComment(int id);
}
