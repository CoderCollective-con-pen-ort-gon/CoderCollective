package com.codeup.codercollective.model;

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

    @Column(nullable= false, columnDefinition = "DATETIME")
    private String createdAt;

    @OneToOne
    private User owner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<Comment> comments;

    @ManyToMany(cascade= CascadeType.ALL)
    @JoinTable(
            name="posts_Forums",
            joinColumns={@JoinColumn(name="post_id")},
            inverseJoinColumns = {@JoinColumn(name="forum_id")}
    )
    private List<Forum> forums;

    @ManyToMany(mappedBy = "post")
    private List<User> users;


    public Post () {

    }

    public Post(String title, String body,String createdAt, User owner, List<Comment> comments) {
        this.title = title;
        this.body = body;
        this.createdAt = createdAt;
        this.owner = owner;
        this.comments = comments;
    }

    public Post(long id, String title, String body, User owner, List<Comment> comments) {
        this.title = title;
        this.body = body;
        this.owner = owner;
        this.comments = comments;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
