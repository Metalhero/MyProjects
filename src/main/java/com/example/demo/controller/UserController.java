package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.EmailService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    UserService service;
    EmailService emailService;

    @Autowired
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @GetMapping("/users")
    private String getUsers() {
        return "user";
    }

    @PostMapping("users/addNew")
    public RedirectView addNew(User user, RedirectAttributes redir) {
        RedirectView redirectView;
        if (service.findAllByEmail(user.getEmail()).size() == 0) {
            redirectView = new RedirectView("/login", true);
            redir.addFlashAttribute("message", "You successfully registered! Please check your e-mails for the activation!");
            emailService.sendMessage(user.getEmail(), user.getUsername(), user.getValidationCode());
            service.saveNewUser(user);
        } else {
            redirectView = new RedirectView("/registration", true);
            redir.addFlashAttribute("message", "The selected email/username has been already registered! Please select another one!");
        }
        return redirectView;
    }


    @RequestMapping(value = "/users/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(User user) {
        service.save(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/users/delete", method = {RequestMethod.PUT, RequestMethod.GET})
    public String delete(Long id) {
        service.delete(id);
        return "redirect:/users";
    }
}
