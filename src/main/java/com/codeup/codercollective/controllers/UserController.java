package com.codeup.codercollective.controllers;

import com.codeup.codercollective.model.User;
import com.codeup.codercollective.repos.UserRepository;
import org.springframework.stereotype.Controller;


@Controller
public class UserController {

    @GetMapping("/profile/{id}")
    public String getUserProfile(@PathVariable long id, Model vModel){
        User user=userDao.findOne(id);
        vModel.addAttribute("user",user);

        return"users/profile";
    }





}
