package com.kondrat.TheSchooWebsite.controllers;

import com.kondrat.TheSchooWebsite.domain.Pupil;
import com.kondrat.TheSchooWebsite.repository.PupilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SchoolController {

    @Autowired
    PupilRepository pupilRepository;

    @PostConstruct
    public void fullListOfPupils(){
        Pupil pupil1 = new Pupil("Константин", 1);
        Pupil pupil2 = new Pupil("Дмитрий",2);
        Pupil pupil3 = new Pupil("София",3);
        Pupil pupil4 = new Pupil("Елена",4);
        pupilRepository.save(pupil1);
        pupilRepository.save(pupil2);
        pupilRepository.save(pupil3);
        pupilRepository.save(pupil4);
    }

    @GetMapping("/allPupils")
    public String showListOfPupils(Model model){
        List<Pupil> allPupils = pupilRepository.findAll();
        model.addAttribute("list", allPupils);
        return "pupils";
    }

    @PostMapping("/addNewPupils")
        public String addNewPupils(Model model, String name){
        List<Pupil> pupils = pupilRepository.makeStringsPupils(name);
        model.addAttribute("list", pupils);
            return "pupils";
        }
    }

