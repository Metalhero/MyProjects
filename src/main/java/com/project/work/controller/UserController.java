package com.project.work.controller;

import com.project.work.model.User;
import com.project.work.service.EmailService;
import com.project.work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    EmailService emailService;

    @PostMapping("/reg")
    public String registration(User user) {
        if (userService.findUserByUsername(user.getUsername())==null) {
            emailService.sendMessage(user.getEmail(), user.getUsername(), user.getActivationCode());
            userService.saveUser(user);
        } else {
            return "redirect:/registration?error";
        }
        return "redirect:/registration?success";
    }

    @GetMapping(path = "/activation/{code}")
    private String activation(@PathVariable("code") String code) {
        String result = userService.activateUser(code);
        if (result.equals("ok"))
            return "redirect:/";
        else
            return "/login?error";
    }
}
