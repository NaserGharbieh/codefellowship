package com.NaserGharbieh.codefellowship.controller;

import com.NaserGharbieh.codefellowship.models.ApplicationUser;
import com.NaserGharbieh.codefellowship.models.Post;
import com.NaserGharbieh.codefellowship.repositries.ApplicationUserRipository;
import com.NaserGharbieh.codefellowship.repositries.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.time.LocalDate;

@Controller
public class PostsController {
    @Autowired
    ApplicationUserRipository applicationUserRipository;
    @Autowired
    PostsRepository postsRepository;

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/myprofile")
    public String getMyProfile(Principal p, Model m) {
        if (p != null) {
            String username = p.getName();
            ApplicationUser user = applicationUserRipository.findByUsername(username);
            if (user != null) {
                m.addAttribute("user", user);
                m.addAttribute("post", user.getPosts());
            }
        }

        return "profile.html";
    }


    @GetMapping("/users/{id}")
    public String getUsers(Principal p, Model m, @PathVariable Long id) {
        if (p != null) {
        ApplicationUser applicationUser = applicationUserRipository.findById(id).orElseThrow();
        m.addAttribute("user", applicationUser);
        m.addAttribute("post", applicationUser.getPosts()); }


        return "otherUsers.html";
    }



    @PostMapping("/addPost")
    public RedirectView addPost(Principal p, String body) {
        if (p != null) {
            String username = p.getName();
            ApplicationUser applicationUser = applicationUserRipository.findByUsername(username);

            if (applicationUser != null) {
                Post post = new Post(body, applicationUser);
                post.setCreatedAt(LocalDate.now());
                postsRepository.save(post);
                return new RedirectView("/myprofile");
            }
        }
        return new RedirectView("/myprofile");
    }


    @PostMapping("/wihtelabelpage")
    public RedirectView cuseWihteLabelpage(Principal p , RedirectAttributes redir) {
        if (p != null) {
            //this will allow you to store model attributes temporarily like this message error
            redir.addFlashAttribute("errorMessage", "you caused this @_@  wihte label fragment");
        }

            return new RedirectView("/wihtelabelpage");
        }





    @GetMapping("/wihtelabelpage")
    public String getWihteLabelpage(Principal p, Model m) {
        if (p != null) {
            String username = p.getName();
            ApplicationUser user = applicationUserRipository.findByUsername(username);
            if (user != null) {
                m.addAttribute("user", user);
                return "wihtelabelpage.html";}

        }


            return "wihtelabelpage.html";}



}

