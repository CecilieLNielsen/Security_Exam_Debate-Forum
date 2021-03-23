package Service;

import Models.CommentDTO;

import java.util.List;

public interface ICommentService {
    public int createComment(CommentDTO comment);
    public int updateComment(CommentDTO comment);
    public void deleteComment(int id);
}
