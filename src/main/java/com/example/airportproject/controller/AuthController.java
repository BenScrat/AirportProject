package com.example.airportproject.controller;

import com.example.airportproject.bll.UserManager;
import com.example.airportproject.bo.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {


    private final UserManager userManager;

    public AuthController( UserManager userService) {
        this.userManager = userService;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }


    @GetMapping("/login")
    public String login() {
        /* modele.addAttribute("utilisateurs", new Utilisateurs());*/
        return "login";
    }

    @PostMapping("/login")
    /*Pour l'envoi du formulaire*/
    public String connexion(@ModelAttribute("user") User user) {
        return "redirect:/home";
    }

    @GetMapping(value="/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }
}
