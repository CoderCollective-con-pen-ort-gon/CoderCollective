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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {

    private final UserRepository userDao;

    private final PostRepository postDao;
    private final ForumRepository forumDao;
    private final CommentRepository commentDao;

    public PostController(PostRepository postRepository, ForumRepository forumRepository,UserRepository userRepository, CommentRepository commentRepository) {
        postDao = postRepository;
        forumDao = forumRepository;
        userDao = userRepository;
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

    @PostMapping("/posts/comment")
    public String createComm(@ModelAttribute Comment comment) {
        User userSession = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findOne(userSession.getId());
        comment.setUser(user);
        Comment savedComment = commentDao.save(comment);
        long postId =savedComment.getPost().getId();

        return "redirect:/posts/"+postId;

    }

    @GetMapping("/posts/create")
    public String createPostForm( Model vModel){
        vModel.addAttribute("post", new Post());

        return "posts/create";
    }

    @PostMapping("profile/create")
        public String createPostOnProfile(@ModelAttribute Post post) {
        User userSession=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userdb =userDao.findOne(userSession.getId());
        post.setOwner(userdb);
        postDao.save(post);
        return "/profile/{id}";
    }


    @GetMapping("/comment/{id}/edit")
    public String editComment(@PathVariable long id, Model vModel) {

        vModel.addAttribute("comment", commentDao.findOne(id));
        return "posts/editComment";
    }

    @PostMapping("/comment/{id}/edit")
    public String returnEditComment(@PathVariable long id,
                                    @RequestParam(name = "body") String body) {
        Comment updateComment = commentDao.findOne(id);
        updateComment.setBody(body);
        commentDao.save(updateComment);
        Post post=updateComment.getPost();
        long postId =post.getId();
        return "redirect:/posts/" + postId;
    }

    @GetMapping("/comment/{id}/delete")
    public String deleteComment(@PathVariable long id) {
        Comment comment=commentDao.findOne(id);
        long postId=comment.getPost().getId();
        commentDao.delete(id);

        return "redirect:/posts/" + postId;
    }

}
