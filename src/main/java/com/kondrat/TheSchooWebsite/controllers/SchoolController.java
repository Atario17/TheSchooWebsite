package com.kondrat.TheSchooWebsite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SchoolController {

    @GetMapping("/allPupils")
    public String showListOfPupils(Model model){
        return "pupils";
    }
}
