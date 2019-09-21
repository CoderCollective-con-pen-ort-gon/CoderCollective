package com.codeup.codercollective.repos;

import com.codeup.codercollective.model.Post;
import org.springframework.data.repository.CrudRepository;


public interface PostRepository extends CrudRepository<Post, Long> {


}
