package com.codeup.codercollective.repos;

import com.codeup.codercollective.model.Post;
import com.codeup.codercollective.model.User;
import org.springframework.data.repository.CrudRepository;


public interface PostRepository extends CrudRepository<Post, Long> {

    Iterable<Post> findByOwner(User user);
}
