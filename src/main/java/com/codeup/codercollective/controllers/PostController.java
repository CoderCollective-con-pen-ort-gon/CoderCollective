package com.codeup.codercollective.controllers;

import com.codeup.codercollective.model.*;
import com.codeup.codercollective.repos.*;
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
    private final FavoritesRepository favDao;
    private final RatingRepository ratingDao;

    public PostController(PostRepository postRepository, ForumRepository forumRepository, UserRepository userRepository, CommentRepository commentRepository, RatingRepository ratingRepository, FavoritesRepository favoritesRepository) {
        postDao = postRepository;
        forumDao = forumRepository;
        userDao = userRepository;
        commentDao = commentRepository;
        ratingDao = ratingRepository;
        favDao = favoritesRepository;
    }

//    @GetMapping("/")
//    public String home() {
//        return "posts/landingpage";
//    }

    @GetMapping("/posts")
    public String showPosts() {
        return "posts/posts";
    }

    @GetMapping("/test")
    public String test() {
        return "posts/test";
    }


    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model vModel) {
//        User loggedIn = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println("UserId = " + loggedIn.getId());
//        vModel.addAttribute("user", loggedIn);
        Post postId = postDao.findOne(id);
        Iterable<Comment> comments = postId.getComments();
        vModel.addAttribute("comments", comments);
        vModel.addAttribute("post", postDao.findOne(id));
        vModel.addAttribute("comment", new Comment());
        vModel.addAttribute("rating", new Rating());


        return "posts/postDetail";
    }

    @PostMapping("/posts/comment")
    public String createComm(@ModelAttribute Comment comment) {
        User userSession = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findOne(userSession.getId());
        comment.setUser(user);
        System.out.println(comment.getPost().getId());

        Comment savedComment = commentDao.save(comment);
        long postId = savedComment.getPost().getId();

        return "redirect:/posts/" + postId;

    }

    @GetMapping("/posts/create")
    public String createPostForm(Model vModel) {
        Iterable<Forum> forums = forumDao.findAll();
        vModel.addAttribute("forums", forums);
        vModel.addAttribute("posts", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        User userSession = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setOwner(userSession);
        Post savedPost = postDao.save(post);
        long postid = savedPost.getId();

        return "redirect:/posts/" + postid;
    }


    @PostMapping("profile/create")
    public String createPostOnProfile(@ModelAttribute Post post) {
        User userSession = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setOwner(userSession);
        postDao.save(post);


        return "redirect:/profile";
    }

    @PostMapping("/comment/{id}/delete")
    public String deleteComment(@PathVariable long id) {
        Comment comment = commentDao.findOne(id);
        long postId = comment.getPost().getId();
        commentDao.delete(id);

        return "redirect:/posts/" + postId;
    }


    @PostMapping("/{id}/delete")
    public String deletePost(@PathVariable long id) {
//        Forum forum = forumDao.findOne(id);
//        long forumId = forum.getId();
        System.out.println(id);

        if (favDao.findFavByPost_Id(id) != null) {
            favDao.deleteFavByPost_Id(id);
        }
        System.out.println("fav");
        if (commentDao.findAllByPost_Id(id) != null) {
            commentDao.deleteAllByPost_Id(id);
        }
        System.out.println("comment");

        postDao.delete(id);
        return "redirect:/profile";
//        return "/forums/" + forumId;
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
        Post post = updateComment.getPost();
        long postId = post.getId();
        return "redirect:/posts/" + postId;
    }


    @GetMapping("/post/{id}/edit")
    public String editPost(@PathVariable long id, Model vModel) {
        vModel.addAttribute("post", postDao.findOne(id));
        return "posts/editPost";
    }

    @PostMapping("/post/{id}/edit")
    public String returnEditPost(@PathVariable long id,
                                 @RequestParam(name = "title") String title,
                                 @RequestParam(name = "body") String body) {
        Post updatePost = postDao.findOne(id);
        updatePost.setTitle(title);
        updatePost.setBody(body);
        postDao.save(updatePost);
        long postId = updatePost.getId();
        return "redirect:/posts/" + postId;
    }

    @PostMapping("/comment/rate")
    public String rateComment(@ModelAttribute Rating rating) {
        User userSession = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        rating.setOwner(userSession);
        System.out.println(rating.getOwner().getId());
        Iterable<Rating> ratings = ratingDao.findAll();
        for (Rating rate : ratings) {
            if (rating.getOwner().getId() == rate.getOwner().getId() && rating.getComment().getId() == rate.getComment().getId()) {
                ratingDao.delete(rate);
            }
        }
        Rating savedRating = ratingDao.save(rating);
        System.out.println(rating);
        long commentid = rating.getComment().getId();
        Comment comment = commentDao.findOne(commentid);
        long postId = comment.getPost().getId();
//        Comment comment=rating.getComment();
//        System.out.println(comment);
        return "redirect:/posts/" + postId;
    }


}
