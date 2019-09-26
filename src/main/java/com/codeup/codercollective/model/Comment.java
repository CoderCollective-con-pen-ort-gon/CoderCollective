package com.codeup.codercollective.model;

import javax.persistence.*;
import javax.persistence.ManyToOne;
import java.util.List;


@Entity
@Table(name="comments")
public class Comment {

    @Id @GeneratedValue
    private long id;

    @Column(nullable=false,columnDefinition="TEXT")
    private String body;

    @Column(nullable=true)
    private String photo;


    @ManyToOne
    @JoinColumn (name="user_id")
    private User user;



    @ManyToOne
    @JoinColumn (name="post_id")
    private Post post;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comment")
    private List<Rating> ratings;


    public Comment(){}


    public Comment(String body, String photo, User user, Post post, List<Rating> ratings) {
        this.body = body;
        this.photo = photo;
        this.user = user;
        this.post = post;
        this.ratings = ratings;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public long ratingTota(){
        long sum=0;
        for (Rating rating:this.ratings) {
            if(rating.getVote()== true){
                sum++;
            }
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", photo='" + photo + '\'' +
                ", user=" + user +
                ", post=" + post +
                '}';
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

}
