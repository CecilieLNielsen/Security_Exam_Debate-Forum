package Models;

import java.util.ArrayList;
import java.util.List;

public class ThreadWithCommentsDTO {

    private ThreadDTO thread;
    private List<CommentDTO> comments;

    public ThreadWithCommentsDTO(ThreadDTO thread, List<CommentDTO> comments) {
        this.thread = thread;
        this.comments = comments;
    }

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