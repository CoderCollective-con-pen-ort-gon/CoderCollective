package com.codeup.codercollective.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="forums")
public class Forum {

    @Id @GeneratedValue
    private long id;

    @Column(nullable=false)
    private String name;

    @ManyToMany(mappedBy="forums")
    private List<Post> posts;

    public Forum(){}

    public Forum(String name, List<Post> posts) {
        this.name = name;
        this.posts = posts;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
