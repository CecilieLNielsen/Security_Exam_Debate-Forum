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

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(int dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public int getDateOfUpdate() {
        return dateOfUpdate;
    }

    public void setDateOfUpdate(int dateOfUpdate) {
        this.dateOfUpdate = dateOfUpdate;
    }
}
