package com.codeup.codercollective.repos;

import com.codeup.codercollective.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface FavoritesRepository extends CrudRepository<Comment, Long> {

void deleteByPost_Id(Long id);
}



