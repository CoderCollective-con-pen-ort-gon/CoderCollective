package com.codeup.codercollective.controllers;

import com.codeup.codercollective.model.User;
import com.codeup.codercollective.repos.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class UserController {
    private final UserRepository userDao;

    public UserController(UserRepository userRepository){
        userDao = userRepository;
    }

    @GetMapping("/profile/{id}")
    public String getUserProfile(@PathVariable long id, Model vModel){
        User user=userDao.findOne(id);
        vModel.addAttribute("user",user);

        return"users/profile";
    }





}
