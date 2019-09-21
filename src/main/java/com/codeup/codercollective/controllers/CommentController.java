package com.codeup.codercollective.controllers;

import com.codeup.codercollective.model.Comment;
import com.codeup.codercollective.model.Post;
import com.codeup.codercollective.repos.CommentRepository;
import com.codeup.codercollective.repos.ForumRepository;
import com.codeup.codercollective.repos.PostRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class CommentController {

//    private final PostRepository postDao;
//    private final ForumRepository forumDao;
//    private final CommentRepository commentDao;
//
//    public CommentController(PostRepository postRepository, ForumRepository forumRepository, CommentRepository commentRepository) {
//        postDao = postRepository;
//        forumDao = forumRepository;
//        commentDao = commentRepository;
//    }
//
//    @GetMapping("/comments/show")
//    public String show(@PathVariable long id, Model vModel) {
//        Post postId = postDao.findOne(id);
//        Iterable<Comment> comments = postId.getComments();
//        vModel.addAttribute("comments", comments);
//        return "posts/post";
//    }

}
