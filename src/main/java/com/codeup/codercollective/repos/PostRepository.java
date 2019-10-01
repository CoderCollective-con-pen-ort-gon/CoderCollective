package com.codeup.codercollective.repos;

import com.codeup.codercollective.model.Post;
import com.codeup.codercollective.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.method.P;

import java.util.List;


public interface PostRepository extends CrudRepository<Post, Long> {

    Iterable<Post> findByOwner(User user);



//    List<Post> findAllByBodyOrTitle(String searchedOne, String searchedTwo);


//    @Query(value = "SELECT * from cc_db.posts c where c.body like CONCAT('%', :searched, '%') OR c.title like CONCAT(:searched, '%')", nativeQuery = true)
//    List<Post> findAllByBodyOrTitle (@Param(("searched")) String searched);

    @Query(value = "SELECT * from codercollective_db.posts c where c.body like CONCAT('%', :searched, '%') OR c.title like CONCAT('%',:searched, '%')", nativeQuery = true)
    List<Post> findAllByBodyOrTitle (@Param(("searched")) String searched);

}
