package Models.DTO;

import Models.Entities.Comment;

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
        this.author = comment.getAuthor().getUsername();
        this.description = comment.getDescription();
        this.dateOfCreation = comment.getDateOfCreation();
        this.dateOfUpdate = comment.getDateOfUpdate();
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
     * Use for updating a comment
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

    public String getDescription() {
        return description;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public String getDateOfUpdate() {
        return dateOfUpdate;
    }
}