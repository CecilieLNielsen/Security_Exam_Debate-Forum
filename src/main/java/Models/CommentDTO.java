package Models;

import java.util.Date;

public class CommentDTO {

    private int id;
    private String author;
    private String description;
    private String dateOfCreation;
    private String dateOfUpdate;

    /**
     * Constructor to convert comment entity to comment DTO
     *
     * @param comment
     */
    public CommentDTO(Comment comment) {
        this.id = comment.getId();
        this.author = comment.getAuthor();
        this.description = comment.getDescription();
        this.dateOfCreation = comment.getDateOfCreation();
        this.dateOfUpdate = comment.getDateOfUpdate();
    }

    /**
     * Use for create new thread manual
     */
    public CommentDTO(int id, String author, String description, String dateOfCreation, String dateOfUpdate) {
        this.id = id;
        this.author = author;
        this.description = description;
        this.dateOfCreation = dateOfCreation;
        this.dateOfUpdate = dateOfUpdate;
    }

    /**
     * Use for create new comment
     */
    public CommentDTO(String author, String description) {
        this.author = author;
        this.description = description;
        String currentDate = new Date().toString();
        this.dateOfCreation = currentDate;
        this.dateOfUpdate = currentDate;
    }

    /**
     * Use for update comment
     */
    public CommentDTO(int id, String author, String description) {
        this.id = id;
        this.author = author;
        this.description = description;
        this.dateOfUpdate = new Date().toString();
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
}