package com.codeup.codercollective.repos;

import com.codeup.codercollective.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
