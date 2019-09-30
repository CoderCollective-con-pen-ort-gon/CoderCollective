package com.codeup.codercollective.controllers;

import com.codeup.codercollective.model.Post;
import com.codeup.codercollective.model.User;
import com.codeup.codercollective.repos.PostRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    private final PostRepository postDao;

    public SearchController(PostRepository postRepository) {
        postDao = postRepository;
    }


    @GetMapping("/search")
    public String showPosts(){
//        vModel.addAttribute("searched", null);
//        vModel.addAttribute("posts", null);
        return "posts/search";
    }

    @PostMapping("/search")
    public String show(@RequestParam(value = "searched", required = false) String searched, Model vModel) {
//        User loggedIn = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println("UserId = " + loggedIn.getId());
        List<Post> postsSearched;
        postsSearched = postDao.findAllByBodyOrTitle(searched);

        vModel.addAttribute("posts", postsSearched);
        vModel.addAttribute("searched", searched);
        return "posts/search";
    }

}
