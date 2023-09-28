package com.NaserGharbieh.codefellowship.controller;

import com.NaserGharbieh.codefellowship.models.ApplicationUser;
import com.NaserGharbieh.codefellowship.repositries.ApplicationUserRipository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Date;

@Controller
public class ApplicationUserController {
@Autowired
    ApplicationUserRipository applicationUserRipository;



    @Autowired
    private HttpServletRequest request;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login.html";
    }

    @GetMapping("/signup")
    public String getSignupPage() {
        return "signup.html";
    }

    @GetMapping("/logout")
    public String getLogoutPage() {
        return "home.html";
    }

    @PostMapping("/signup")
    public RedirectView createUser(String username, String password, String firstName, String lastName, String dateOfBirth, String bio) {

        ApplicationUser user = new ApplicationUser();
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setDateOfBirth(dateOfBirth);
        user.setBio(bio);

        String encryptedPassword = passwordEncoder.encode(password);
        user.setPassword(encryptedPassword);

        applicationUserRipository.save(user);

        authWithHttpServletRequest(username,password);

        return new RedirectView("/");
    }

    public void authWithHttpServletRequest(String username, String password) {
        try {
            request.login(username,password);
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }

    @GetMapping("/")
    public String getHomePage(Principal p, Model m){

        if(p != null){
            String username = p.getName();
            ApplicationUser user= applicationUserRipository.findByUsername(username);
            m.addAttribute("user", user);
        }

        return "home.html";
    }





}
