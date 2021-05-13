package Models.DTO;

import Models.Entities.Thread;

import java.util.Date;

public class ThreadDTO {

    private int id;
    private String title;
    private String category;
    private String author;
    private String description;
    private String dateOfCreation;
    private String dateOfUpdate;
    private int comments;

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
        this.author = thread.getAuthor().getUsername();
        this.dateOfCreation = thread.getDateOfCreation();
        this.dateOfUpdate = thread.getDateOfUpdate();
        this.comments = thread.getComments().size();
    }

    /**
     * Use for create new thread
     */
    public ThreadDTO(String title, String category, String description) {
        this.title = title;
        this.category = category;
        this.description = description;
        String currentDate = new Date().toString();
        this.dateOfCreation = currentDate;
        this.dateOfUpdate = currentDate;
    }

    /**
     * Use for updating a thread
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

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
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