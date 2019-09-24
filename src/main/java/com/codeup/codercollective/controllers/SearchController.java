//package com.codeup.codercollective.controllers;
//
//import com.codeup.codercollective.model.Forum;
//import com.codeup.codercollective.model.Post;
//import com.codeup.codercollective.repos.ForumRepository;
//import com.codeup.codercollective.repos.PostRepository;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.util.List;
//
//@Controller
//public class SearchController {
//
//    private final PostRepository postDao;
//    private final ForumRepository forumDao;
//
//    public SearchController(PostRepository postRepository, ForumRepository forumRepository) {
//        postDao = postRepository;
//        forumDao = forumRepository;
//    }
//
//
//    @GetMapping("/forums")
//    public String forum(Model vModel){
//        Iterable<Forum> forums = forumDao.findAll();
//        vModel.addAttribute("forums", forums);
//        return "posts/forums";
//    }
//
//    @GetMapping("/forums/{id}")
//    public String show(@PathVariable long id, Model vModel) {
//        Forum forumId = forumDao.findOne(id);
//        List <Post> posts=forumId.getPosts();
//        vModel.addAttribute("forum", forumId);
//        vModel.addAttribute("posts", posts);
//        return "posts/posts";
//    }
//
//}
