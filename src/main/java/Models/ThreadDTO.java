package Models;

import java.util.Objects;

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

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public String getDateOfUpdate() {
        return dateOfUpdate;
    }

    public void setDateOfUpdate(String dateOfUpdate) {
        this.dateOfUpdate = dateOfUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThreadDTO threadDTO = (ThreadDTO) o;
        return id == threadDTO.id;
    }
}
