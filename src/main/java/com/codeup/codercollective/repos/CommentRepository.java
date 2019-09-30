package com.codeup.codercollective.repos;

import com.codeup.codercollective.model.Comment;
import com.codeup.codercollective.model.Post;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {

    void deleteAllByPost_Id(Long id);
    List<Comment> findAllByPost_Id(Long id);

    @Query(value = "select post_id from codercollective_db.comments where post_id = ?;", nativeQuery = true)
    Long findComByPost_Id (Long post_id);

    @Modifying
    @Transactional
    @Query(value = "delete from codercollective_db.comments where post_id = :post_id;", nativeQuery = true)
    void deleteComsByPost_Id(@Param("post_id") Long post_id);


}



