package com.codeup.codercollective.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PostController {

    @GetMapping("/cc")
    public String home(){
        return "posts/index";
    }

}
