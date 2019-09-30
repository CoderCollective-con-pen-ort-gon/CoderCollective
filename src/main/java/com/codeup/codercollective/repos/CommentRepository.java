package com.codeup.codercollective.repos;

import com.codeup.codercollective.model.Comment;
import com.codeup.codercollective.model.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {

    void deleteAllByPost_Id(Long id);
    List<Comment> findAllByPost_Id(Long id);

}



