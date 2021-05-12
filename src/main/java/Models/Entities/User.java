package Models.Entities;

import Models.DTO.UserDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String hashedPassword;
    @ManyToOne
    private Role role;
    @OneToMany(mappedBy = "author")
    private List<Thread> threads;
    @OneToMany(mappedBy = "author")
    private List<Comment> comments;

    /**
     * Empty constructor for JPA
     */
    public User() {
    }

    /**
     * Constructor for converting a userDTO into a user entity
     *
     * @param userDTO
     */
    public User(UserDTO userDTO) {
        email = userDTO.getEmail();
        username = userDTO.getUsername();
        hashedPassword = userDTO.getHashedPassword();
    }

    /**
     * Constructor for creating a user manual
     *
     * @param email
     * @param username
     * @param hashedPassword
     */
    public User(String email, String username, String hashedPassword) {
        this.email = email;
        this.username = username;
        this.hashedPassword = hashedPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        if (role != null)
            role.addUser(this);
        this.role = role;
    }

    public List<Thread> getThreads() {
        return threads;
    }

    public void setThreads(List<Thread> threads) {
        this.threads = threads;
    }

    public void addThread(Thread thread) {
        if (threads == null)
            threads = new ArrayList<>();
        threads.add(thread);
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void addComment(Comment comment) {
        if (comments == null)
            comments = new ArrayList<>();
        comments.add(comment);
    }
}
