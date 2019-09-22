package com.codeup.codercollective.controllers;

import com.codeup.codercollective.model.Forum;
import com.codeup.codercollective.model.User;
import com.codeup.codercollective.repos.ForumRepository;
import com.codeup.codercollective.repos.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {
    private final UserRepository userDao;
    private final ForumRepository forumDao;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository,ForumRepository forumRepository, PasswordEncoder passwordEncoder){
        userDao = userRepository;
        forumDao = forumRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/profile/{id}")
    public String getUserProfile(@PathVariable long id, Model vModel){
        User user=userDao.findOne(id);
        Iterable<Forum> forums = forumDao.findAll();
        vModel.addAttribute("forums", forums);
        vModel.addAttribute("user",user);

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







}
