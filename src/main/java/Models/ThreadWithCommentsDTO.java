package Models;

import java.util.List;

public class ThreadWithCommentsDTO {

    private ThreadDTO thread;
    private List<CommentDTO> comments;

    public ThreadWithCommentsDTO(ThreadDTO thread, List<CommentDTO> comments) {
        this.thread = thread;
        this.comments = comments;
    }

    public ThreadDTO getThread() {
        return thread;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }
}
