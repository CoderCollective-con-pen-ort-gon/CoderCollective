package com.codeup.codercollective.controllers;

import com.codeup.codercollective.model.Forum;
import com.codeup.codercollective.model.Post;
import com.codeup.codercollective.model.User;
import com.codeup.codercollective.repos.ForumRepository;
import com.codeup.codercollective.repos.PostRepository;
import com.codeup.codercollective.repos.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {
    private final UserRepository userDao;
    private final ForumRepository forumDao;
    private final PasswordEncoder passwordEncoder;
    private final PostRepository postDao;

    public UserController(UserRepository userRepository,ForumRepository forumRepository, PasswordEncoder passwordEncoder, PostRepository postRepository){
        userDao = userRepository;
        forumDao = forumRepository;
        this.passwordEncoder = passwordEncoder;
        postDao= postRepository;
    }


    @GetMapping("/landingpage")
    public String user(Model vModel){
        vModel.addAttribute("user", new User());
        return "posts/landingpage";
    }



    @GetMapping("/profile")
    public String getUserProfile(Model vModel){
        User userSession= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Iterable<Forum> forums = forumDao.findAll();
        vModel.addAttribute("forums", forums);
        vModel.addAttribute("posts",new Post());
        vModel.addAttribute("user",userSession);
        Iterable<Post> userPosts = postDao.findByOwner(userSession);
        vModel.addAttribute("userPosts", userPosts);
        return"users/profile";
    }

    @GetMapping("/register")
    public String signUp(Model vModel){
        vModel.addAttribute("user", new User());
        return "users/register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/login";
    }

    @GetMapping("/profile/{id}/edit")
    public String editProfileForm( Model vModel){
        User userSession= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        vModel.addAttribute("user",userSession);
        return "users/edit";
    }
    @PostMapping("/profile/{id}/edit")
    public String editProfile(@PathVariable long id, @ModelAttribute User user){
        userDao.save(user);
        return "redirect:/profile";
    }



}
