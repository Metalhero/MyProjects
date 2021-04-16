package com.example.demo.controller;

import com.example.demo.domain.ContactMessage;
import com.example.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactusController {

    EmailService emailService;

    @Autowired
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/contactus")
    private String contactUs(Model model){
        ContactMessage contactMessage=new ContactMessage();
        model.addAttribute("object",contactMessage);
        return "contact";
    }

    @PostMapping("/contacted")
    private String contacted(@ModelAttribute("msg") ContactMessage contactMessage) {

        emailService.receivedMessage(contactMessage);
        return "redirect:/contactus?sent";
    }
}
