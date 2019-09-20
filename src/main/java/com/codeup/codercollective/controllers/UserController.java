package com.codeup.codercollective.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping
    public String getUserProfile(){
        return(users/profile);
    }



}
