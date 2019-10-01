package com.codeup.codercollective.controllers;

import com.codeup.codercollective.model.Forum;
import com.codeup.codercollective.model.Post;
import com.codeup.codercollective.model.User;
import com.codeup.codercollective.repos.ForumRepository;
import com.codeup.codercollective.repos.PostRepository;
import com.codeup.codercollective.repos.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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


    @GetMapping("/")
    public String user(Model vModel){
        vModel.addAttribute("user", new User());
        return "posts/landingpage";
    }


    @GetMapping("/profile")
    public String getUserProfile(Model vModel){
        User userSession= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser= userDao.findOne(userSession.getId());

        Iterable<Post> favPosts=currentUser.getFavoritepost();
        vModel.addAttribute("favPosts", favPosts);

        Iterable<Forum> forums = forumDao.findAll();
        vModel.addAttribute("forums", forums);
        vModel.addAttribute("posts",new Post());
        vModel.addAttribute("user",currentUser);
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
        User currentUser= userDao.findOne(userSession.getId());

        vModel.addAttribute("user",currentUser);
        return "users/edit";
    }
    @PostMapping("/profile/{id}/edit")
    public String editProfile(@PathVariable long id, @ModelAttribute User user){
        User userSession= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        long userid =userSession.getId();
        user.setId(userid);
        userDao.save(user);
        return "redirect:/profile";
    }

//    @RequestMapping(value="/logout", method = RequestMethod.GET)
//    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null){
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return "users/logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
//    }


}
