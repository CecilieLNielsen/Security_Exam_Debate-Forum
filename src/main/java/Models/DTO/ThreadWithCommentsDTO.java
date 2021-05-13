package Models.DTO;

import Models.Entities.Comment;
import Models.Entities.Thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadWithCommentsDTO {

    private final ThreadDTO thread;
    private final List<CommentDTO> comments;

    public ThreadWithCommentsDTO(Thread thread) {
        this.thread = new ThreadDTO(thread);
        List<CommentDTO> tempComments = new ArrayList<>();
        for (Comment comment : thread.getComments()) {
            tempComments.add(new CommentDTO(comment));
        }
        this.comments = tempComments;
    }

    public ThreadDTO getThread() {
        return thread;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }
}