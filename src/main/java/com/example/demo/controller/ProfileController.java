package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Locale;

@Controller
public class ProfileController {

    private UserService userService;

    @Autowired
    public void setEmployeeService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String profile(Model model, Principal principal, Locale locale){
        if (principal!=null) {
            String name = principal.getName();
            model.addAttribute("user", userService.findByUsername(name));
            model.addAttribute("country", locale.getCountry());
        }
        return "profile";
    }
}
