package com.codeup.codercollective.model;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
@Entity
@Table(name = "users")
public class User {
    @Id@GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String firstname;

    @Column(nullable = true)
    private String lastname;

    @Column(nullable = true)
    private String title;

    @Column(nullable=true)
    private String photo;

    @OneToMany(cascade= CascadeType.ALL, mappedBy = "owner" )
    private List<Post> post;

    @OneToMany(cascade= CascadeType.ALL, mappedBy = "user" )
    private List<Comment> comments;

    @OneToMany(cascade= CascadeType.ALL, mappedBy = "owner" )
    private List<Rating> ratings;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="favorite_post",
            joinColumns={@JoinColumn(name="user_id")},
            inverseJoinColumns={@JoinColumn(name="post_id")}
    )
    private List<Post> favoritepost;
    public User(){
    }

    public User(String username, String email, String password, String firstname, String lastname, String title, String photo, List<Post> post, List<Comment> comments, List<Rating> ratings, List<Post> favoritepost) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
        this.photo = photo;
        this.post = post;
        this.comments = comments;
        this.ratings = ratings;
        this.favoritepost = favoritepost;
    }
    public User(User copy){
        this.id=copy.id;
        this.username = copy.username;
        this.email = copy.email;
        this.password = copy.password;
        this.firstname = copy.firstname;
        this.lastname = copy.lastname;
        this.title = copy.title;
        this.photo= copy.photo;
        this.comments = copy.comments;
        this.post= copy.post;
        this.ratings=copy.ratings;
        this.favoritepost=copy.favoritepost;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<Comment> getComments() {
        return comments;
    }
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public List<Post> getPost() {
        return post;
    }
    public void setPost(List<Post> post) {
        this.post = post;
    }
    public List<Rating> getRatings() {
        return ratings;
    }
    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
    public List<Post> getFavoritepost() {
        return favoritepost;
    }
    public void setFavoritepost(List<Post> favoritepost) {
        this.favoritepost = favoritepost;
    }
}