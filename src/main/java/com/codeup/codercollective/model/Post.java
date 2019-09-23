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

    @OneToOne
    private User owner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<Comment> comments;

//    @ManyToMany(cascade= CascadeType.ALL)
//    @JoinTable(
//            name="posts_Forums",
//            joinColumns={@JoinColumn(name="post_id")},
//            inverseJoinColumns = {@JoinColumn(name="forum_id")}
//    )
//    private List<Forum> forums;

    @ManyToOne
    @JoinColumn (name="forum_id")
    private Forum forums;


    @ManyToMany(mappedBy = "post")
    private List<User> users;


    public Post () {

    }

    public Post(String title, String body,Date createdAt, User owner, List<Comment> comments,String photo) {
        this.title = title;
        this.body = body;
        this.createdAt = createdAt;
        this.owner = owner;
        this.comments = comments;
        this.photo=photo;
    }

    public Post(long id, String title, String body, User owner, List<Comment> comments) {
        this.title = title;
        this.body = body;
        this.owner = owner;
        this.comments = comments;
    }

    public Post(String title, String body, Date createdAt, String photo, User owner, List<Comment> comments, Forum forums, List<User> users) {
        this.title = title;
        this.body = body;
        this.createdAt = createdAt;
        this.photo = photo;
        this.owner = owner;
        this.comments = comments;
        this.forums = forums;
        this.users = users;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
