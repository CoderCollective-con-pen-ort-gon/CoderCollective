package com.codeup.codercollective.model;

import javax.persistence.*;
import javax.persistence.GeneratedValue;

@Entity
public class Rating{
    @Id @GeneratedValue
    private long id;

    @Column(nullable=false,columnDefinition = "TINYINT")
    private Boolean vote;

    @ManyToOne
    private User owner;

    @ManyToOne
    private Comment comment;

    public Rating(){}

    public Rating(Boolean vote, User owner, Comment comment) {
        this.vote = vote;
        this.owner = owner;
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getVote() {
        return vote;
    }

    public void setVote(Boolean vote) {
        this.vote = vote;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}

