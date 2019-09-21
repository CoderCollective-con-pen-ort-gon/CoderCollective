package com.codeup.codercollective.repos;

import com.codeup.codercollective.model.Forum;
import com.codeup.codercollective.model.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findByForums(Forum id);

    Iterable<Post> findAll();
}
