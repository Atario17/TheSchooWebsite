package com.kondrat.TheSchooWebsite.controllers;

import com.kondrat.TheSchooWebsite.domain.Pupil;
import com.kondrat.TheSchooWebsite.repository.PupilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SchoolController {

    @Autowired
    PupilRepository pupilRepository;

    @PostConstruct
    public void fullListOfPupils(){
        Pupil pupil1 = new Pupil("Константин");
        Pupil pupil2 = new Pupil("Дмитрий");
        Pupil pupil3 = new Pupil("София");
        Pupil pupil4 = new Pupil("Елена");
        pupilRepository.save(pupil1);
        pupilRepository.save(pupil2);
        pupilRepository.save(pupil3);
        pupilRepository.save(pupil4);
    }

    @GetMapping("/allPupils")
    public String showListOfPupils(Model model){
        List<Pupil> allPupils = pupilRepository.findAll();
        List<String> allNamesOfPupils = new ArrayList<>();
        for(Pupil pupil : allPupils){
            allNamesOfPupils.add(pupil.getName());
        }
        model.addAttribute("list", allNamesOfPupils);
        return "pupils";
    }
}
