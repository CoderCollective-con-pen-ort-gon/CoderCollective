package com.codeup.codercollective.repos;

import com.codeup.codercollective.model.Rating;
import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating, Long> {
}
