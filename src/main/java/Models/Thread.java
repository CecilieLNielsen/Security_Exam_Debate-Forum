package Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Thread {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String category;
    private String author;
    private String description;
    private String dateOfCreation;
    private String dateOfUpdate;
    @OneToMany(mappedBy = "Thread", cascade = {CascadeType.PERSIST})
    private List<Comment> comments = new ArrayList<>();

    /**
     * Empty constructor for JPA
     */
    public Thread() {
    }

    /**
     * Constructor for converting a threadDTO into a thread entity
     *
     * @param threadDTO
     */
    public Thread(ThreadDTO threadDTO) {
        this.id = threadDTO.getId();
        setAll(threadDTO);
    }

    /**
     * Use this instead of set methods
     */
    public void setAll(ThreadDTO threadDTO) {
        this.title = threadDTO.getTitle();
        this.category = threadDTO.getCategory();
        this.description = threadDTO.getDescription();
        this.author = threadDTO.getAuthor();
        this.dateOfCreation = threadDTO.getDateOfCreation();
        this.dateOfUpdate = threadDTO.getDateOfUpdate();
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

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getDateOfUpdate() {
        return dateOfUpdate;
    }

    public void setDateOfUpdate(String dateOfUpdate) {
        this.dateOfUpdate = dateOfUpdate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
        comment.setThread(this);
    }
}

