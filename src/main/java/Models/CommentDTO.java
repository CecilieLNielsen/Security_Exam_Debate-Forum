package Models;

public class CommentDTO {

    private int id;
    private String author;
    private int dateOfCreation;
    private int dateOfUpdate;

    public CommentDTO(int id, String author, int dateOfCreation, int dateOfUpdate) {
        this.id = id;
        this.author = author;
        this.dateOfCreation = dateOfCreation;
        this.dateOfUpdate = dateOfUpdate;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public int getDateOfCreation() {
        return dateOfCreation;
    }

    public int getDateOfUpdate() {
        return dateOfUpdate;
    }
}
