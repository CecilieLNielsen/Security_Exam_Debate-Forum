package Models;

public class ThreadDTO {

    private int id;
    private String title;
    private String category;
    private String author;
    private String dateOfCreation;
    private String dateOfUpdate;

    public ThreadDTO(int id, String title, String category, String author, String dateOfCreation, String dateOfUpdate) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.author = author;
        this.dateOfCreation = dateOfCreation;
        this.dateOfUpdate = dateOfUpdate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getAuthor() {
        return author;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public String getDateOfUpdate() {
        return dateOfUpdate;
    }
}
