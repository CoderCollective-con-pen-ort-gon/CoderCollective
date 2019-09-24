package com.codeup.codercollective.repos;

import com.codeup.codercollective.model.Forum;
import com.codeup.codercollective.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ForumRepository extends CrudRepository<Forum, Long> {
}
