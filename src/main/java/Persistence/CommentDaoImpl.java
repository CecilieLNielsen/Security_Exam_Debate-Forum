package Persistence;

import Models.CommentDTO;
import Models.ThreadDTO;
import Persistence.DAO.CommentDao;

import java.util.List;

public class CommentDaoImpl implements CommentDao {
    private List<CommentDTO> comments;

    @Override
    public int createComment(CommentDTO comment) {
        int newCommentId = 1; // Start ID hvis ingen kommentarer findes i systemet
        if (!comments.isEmpty()) { // Tjekker på om listen ikke er tom
            int lastCommentIndex = comments.size() - 1; // Henter index plads på den seneste kommentar
            int lastCommentId = comments.get(lastCommentIndex).getId(); // Henter ID ud fra den givne indexplads
            newCommentId = lastCommentId + 1; // Autoincrement ID på næste kommentar
        }
        comment.setId(newCommentId);
        comments.add(comment);
        return comment.getId();
    }

    @Override
    public List<CommentDTO> getAllCommentsByThreadId(int threadId) {
        return comments;
    }

    @Override
    public int updateComment(CommentDTO updatedComment) {
        for (CommentDTO existingComment : comments) {
            if (existingComment.getId() == updatedComment.getId()) {
                existingComment.setAuthor(updatedComment.getAuthor());
                existingComment.setDateOfUpdate(updatedComment.getDateOfUpdate());
                return existingComment.getId();
            }
        }
        return -1;
    }

    @Override
    public void deleteComment(int id) {
        for (int i = 0; i < comments.size(); i++) {
            CommentDTO comment = comments.get(i);
            if (comment.getId() == id) {
                comments.remove(i);
            }
        }
    }
}
