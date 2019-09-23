package com.codeup.codercollective.controllers;
import com.codeup.codercollective.model.Comment;
import com.codeup.codercollective.model.Forum;
import com.codeup.codercollective.model.Post;
import com.codeup.codercollective.model.User;
import com.codeup.codercollective.repos.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


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
        Iterable<Forum> forums = forumDao.findAll();
        vModel.addAttribute("forums", forums);
        vModel.addAttribute("posts",new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost( @ModelAttribute Post post){
        User userSession=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setOwner(userSession);
        Post savedPost=postDao.save(post);
        long postid=savedPost.getId();

        return"redirect:/posts/"+ postid;
    }



    @PostMapping("profile/create")
        public String createPostOnProfile(@ModelAttribute Post post) {
        User userSession=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setOwner(userSession);
        postDao.save(post);


        return "redirect:/profile";
    }

}
