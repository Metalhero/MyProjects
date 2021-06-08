package com.project.work.controller;

import com.project.work.model.ContactMessage;
import com.project.work.service.EmailService;
import com.project.work.service.HomeService;
import com.project.work.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private HomeService homeService;

    @Autowired
    private EmailService emailService;

    @Autowired
    SolutionService solutionService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("coverLetter",homeService.readPdfDocument());
        model.addAttribute("contactMsg",new ContactMessage());
        model.addAttribute("first", solutionService.getSolutionFirst().getSolution());
        return "index";
    }

    @PostMapping("/contacted")
    private String contacted(@ModelAttribute ContactMessage contactMessage) {
        emailService.contactMessage(contactMessage);
        return "redirect:/?sent#contactme";
    }

    @GetMapping("/registration")
    private String registration(){
        return "registration";
    }


}
