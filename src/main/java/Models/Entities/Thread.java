package Models.Entities;

import Models.DTO.ThreadDTO;

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
    @ManyToOne
    private User author;
    private String description;
    private String dateOfCreation;
    private String dateOfUpdate;
    @OneToMany(mappedBy = "thread", cascade = {CascadeType.REMOVE})
    private List<Comment> comments;

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
     * Constructor for creating a thread manual
     *
     * @param title
     * @param category
     * @param author
     * @param description
     */
    public Thread(String title, String category, User author, String description) {
        this.title = title;
        this.category = category;
        setAuthor(author);
        this.description = description;
    }

    /**
     * Use this instead of set methods
     */
    public void setAll(ThreadDTO threadDTO) {
        this.title = threadDTO.getTitle();
        this.category = threadDTO.getCategory();
        this.description = threadDTO.getDescription();
        //this.author = threadDTO.getAuthor();
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        if (author != null)
            author.addThread(this);
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
        if (comment != null)
            comment.setThread(this);
        if (comments == null)
            comments = new ArrayList<>();
        comments.add(comment);
    }
}

