package com.codeup.codercollective.controllers;

import com.codeup.codercollective.model.Forum;
import com.codeup.codercollective.repos.ForumRepository;
import com.codeup.codercollective.repos.PostRepository;
import com.codeup.codercollective.repos.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForumController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    private final ForumRepository forumDao;

    public ForumController(PostRepository postRepository, UserRepository userRepository, ForumRepository forumRepository) {
        postDao = postRepository;
        userDao = userRepository;
        forumDao = forumRepository;
    }


    @GetMapping("/forums")
    public String forum(Model vModel){
        Iterable<Forum> forums = forumDao.findAll();
        vModel.addAttribute("forums", forums);
        return "posts/forums";
    }


}
