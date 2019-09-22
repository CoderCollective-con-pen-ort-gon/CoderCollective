package com.codeup.codercollective.controllers;

import com.codeup.codercollective.model.Comment;
import com.codeup.codercollective.model.Post;
import com.codeup.codercollective.model.User;
import com.codeup.codercollective.repos.CommentRepository;
import com.codeup.codercollective.repos.ForumRepository;
import com.codeup.codercollective.repos.PostRepository;
import com.codeup.codercollective.repos.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {


    private final PostRepository postDao;
    private final ForumRepository forumDao;
    private final UserRepository userDao;
    private final CommentRepository commentDao;

    public CommentController(PostRepository postRepository, ForumRepository forumRepository, UserRepository userRepository, CommentRepository commentRepository) {
        postDao = postRepository;
        forumDao = forumRepository;
        userDao = userRepository;
        commentDao = commentRepository;
    }


@PostMapping("/posts/{id}/comment")
    public String createComment(@PathVariable long id, @ModelAttribute Comment comment) {
    User userSession = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    comment.setUser(userSession);
    Comment savedComment=commentDao.save(comment);

    Post post = postDao.findOne(id);
    savedComment.setPost(post);
    commentDao.save(savedComment);

    return "redirect:/posts/{id}";
}

}
