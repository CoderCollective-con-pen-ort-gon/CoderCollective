package com.codeup.codercollective.repos;

import com.codeup.codercollective.model.Comment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


public interface FavoritesRepository extends CrudRepository<Comment, Long> {

    @Query(value = "select post_id from codercollective_db.favorite_post where post_id = ?;", nativeQuery = true)
    Long findFavByPost_Id (Long post_id);

    @Modifying
    @Transactional
    @Query(value = "delete from codercollective_db.favorite_post where post_id = :post_id;", nativeQuery = true)
    void deleteFavByPost_Id(@Param("post_id") Long post_id);


}



