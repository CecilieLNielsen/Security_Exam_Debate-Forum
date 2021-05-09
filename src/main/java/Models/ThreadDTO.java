package Models;

import java.util.Date;

public class ThreadDTO {

    private int id;
    private String title;
    private String category;
    private String author;
    private String description;
    private String dateOfCreation;
    private String dateOfUpdate;

    /**
     * Constructor to convert thread entity to thread DTO
     *
     * @param thread
     */
    public ThreadDTO(Thread thread) {
        this.id = thread.getId();
        this.title = thread.getTitle();
        this.category = thread.getCategory();
        this.description = thread.getDescription();
        this.author = thread.getAuthor();
        this.dateOfCreation = thread.getDateOfCreation();
        this.dateOfUpdate = thread.getDateOfUpdate();
    }

    /**
     * Use for create new thread manual
     */
    public ThreadDTO(int id, String title, String category, String author, String description, String dateOfCreation, String dateOfUpdate) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.author = author;
        this.description = description;
        this.dateOfCreation = dateOfCreation;
        this.dateOfUpdate = dateOfUpdate;
    }

    /**
     * Use for create new thread
     */
    public ThreadDTO(String title, String category, String author, String description) {
        this.title = title;
        this.category = category;
        this.author = author;
        this.description = description;
        String currentDate = new Date().toString();
        this.dateOfCreation = currentDate;
        this.dateOfUpdate = currentDate;
    }

    /**
     * Use for update thread
     */
    public ThreadDTO(int id, String title, String category, String author, String description) {
        this.id = id;
        this.title = title;
        this.category = category;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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