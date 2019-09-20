package com.codeup.codercollective.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="forums")
public class PostForum {

    @Id @GeneratedValue
    private long id;

    @Column(nullable=false)
    private String name;

    @ManyToMany(mappedBy="forums")
    private List<Post> posts;

}
