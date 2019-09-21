package com.codeup.codercollective.controllers;

import com.codeup.codercollective.model.Forum;
import com.codeup.codercollective.model.User;
import com.codeup.codercollective.repos.ForumRepository;
import com.codeup.codercollective.repos.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class UserController {
    private final UserRepository userDao;
    private final ForumRepository forumDao;

    public UserController(UserRepository userRepository,ForumRepository forumRepository){
        userDao = userRepository;
        forumDao=forumRepository;
    }

    @GetMapping("/profile/{id}")
    public String getUserProfile(@PathVariable long id, Model vModel){
        User user=userDao.findOne(id);
        Iterable<Forum> forums = forumDao.findAll();
        vModel.addAttribute("forums", forums);
        vModel.addAttribute("user",user);

        return"users/profile";
    }





}
