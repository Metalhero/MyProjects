package com.project.work.controller;

import com.project.work.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/solution", method = RequestMethod.GET)
public class SolutionController {

    @Autowired
    SolutionService solutionService;

    @GetMapping("/first")
    private String firstSolution () {
        solutionService.setThisSolutionToClipboard(solutionService.getSolutionFirst());
        return "redirect:/?first#work";
    }



}