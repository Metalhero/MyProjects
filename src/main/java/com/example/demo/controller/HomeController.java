package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

/*    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }*/

    @GetMapping("/")
    private String Index() {
        return "index";
    }


/*    @GetMapping("/login")
    private String login() {
        return "login";
    }

    @GetMapping("/registration")
    private String registrationPage() {
            return "registration";
    }*/

/*    @GetMapping(path = "/activation/{code}")
    private String activation(@PathVariable("code") String code, HttpServletResponse response) {
        String result = userService.activateUser(code);
        if (result.equals("ok"))
            return "redirect:/";
        else
            return "/login?error";
    }*/

}