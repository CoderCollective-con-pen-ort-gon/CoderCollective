package com.codeup.codercollective.model;

import org.hibernate.annotations.CreationTimestamp;
import java.util.Date;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="posts")
public class Post {
    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_date")
    private Date createdAt;

    @Column(nullable=true)
    private String photo;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User owner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<Comment> comments;



    @ManyToOne
    @JoinColumn (name="forum_id")
    private Forum forums;


    @ManyToMany(mappedBy = "favoritepost")
    private List<User> postfavorites;


    public Post () {

    }

    public Post(String title, String body, Date createdAt, String photo, User owner, List<Comment> comments, Forum forums, List<User> postfavorites) {
        this.title = title;
        this.body = body;
        this.createdAt = createdAt;
        this.photo = photo;
        this.owner = owner;
        this.comments = comments;
        this.forums = forums;
        this.postfavorites = postfavorites;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Forum getForums() {
        return forums;
    }

    public void setForums( Forum forums) {
        this.forums = forums;
    }

    public List<User> getPostfavorites() {
        return postfavorites;
    }

    public void setPostfavorites(List<User> postfavorites) {
        this.postfavorites = postfavorites;
    }
}
