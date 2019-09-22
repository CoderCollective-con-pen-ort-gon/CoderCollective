package com.codeup.codercollective.controllers;
import com.codeup.codercollective.model.Comment;
import com.codeup.codercollective.model.Post;
import com.codeup.codercollective.model.User;
import com.codeup.codercollective.repos.ForumRepository;
import com.codeup.codercollective.repos.PostRepository;
import com.codeup.codercollective.repos.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PostController {


    private final PostRepository postDao;
    private final ForumRepository forumDao;
    private final UserRepository userDao;

    public PostController(PostRepository postRepository, ForumRepository forumRepository,UserRepository userRepository) {
        postDao = postRepository;
        forumDao = forumRepository;
        userDao = userRepository;
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

        return "posts/postDetail";
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



}
