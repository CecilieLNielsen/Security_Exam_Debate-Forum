package Service.Interfaces;

import Models.DTO.CommentDTO;

public interface ICommentService {
    int createComment(CommentDTO comment);

    int updateComment(CommentDTO comment);

    void deleteComment(int id);
}
