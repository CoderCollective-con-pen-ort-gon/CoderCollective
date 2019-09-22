package com.codeup.codercollective.controllers;
import com.codeup.codercollective.model.Comment;
import com.codeup.codercollective.model.Post;
import com.codeup.codercollective.repos.CommentRepository;
import com.codeup.codercollective.repos.ForumRepository;
import com.codeup.codercollective.repos.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class PostController {


    private final PostRepository postDao;
    private final ForumRepository forumDao;
    private final CommentRepository commentDao;

    public PostController(PostRepository postRepository, ForumRepository forumRepository, CommentRepository commentRepository) {
        postDao = postRepository;
        forumDao = forumRepository;
        commentDao = commentRepository;
    }

    @GetMapping("/")
    public String home(){
        return "posts/index";
    }

    @GetMapping("/posts")
    public String showPosts(){
        return "posts/posts";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model vModel) {
        Post postId = postDao.findOne(id);
        Iterable<Comment> comments = postId.getComments();
        vModel.addAttribute("comments", comments);
        vModel.addAttribute("post", postDao.findOne(id));
        vModel.addAttribute("comment", new Comment());
        return "posts/postDetail";
    }


}
