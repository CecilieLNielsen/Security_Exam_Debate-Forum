package Models;

import javax.persistence.*;

@Entity
public class Comment {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String author;
    private String description;
    private String dateOfCreation;
    private String dateOfUpdate;
    @ManyToOne
    private Thread thread;

    /**
     * Empty constructor for JPA
     */
    public Comment() {
    }

    /**
     * Constructor for converting a commentDTO into a comment entity
     *
     * @param commentDTO
     */
    public Comment(CommentDTO commentDTO) {
        this.id = commentDTO.getId();
        setAll(commentDTO);
    }

    public void setAll(CommentDTO commentDTO) {
        this.author = commentDTO.getAuthor();
        this.description = commentDTO.getDescription();
        this.dateOfCreation = commentDTO.getDateOfCreation();
        this.dateOfUpdate = commentDTO.getDateOfUpdate();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getDateOfUpdate() {
        return dateOfUpdate;
    }

    public void setDateOfUpdate(String dateOfUpdate) {
        this.dateOfUpdate = dateOfUpdate;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }
}

