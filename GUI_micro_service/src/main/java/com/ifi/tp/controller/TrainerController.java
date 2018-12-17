package com.ifi.tp.controller;

import com.ifi.tp.trainers.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @GetMapping("/trainers")
    ModelAndView index(){
        var modelAndView = new ModelAndView("trainers");

        modelAndView.addObject("trainers", trainerService.getAllTrainers());

        return modelAndView;
    }

    @GetMapping("/trainers/{name}")
    ModelAndView index(@PathVariable String name){
        var modelAndView = new ModelAndView("trainer");

        modelAndView.addObject("trainer", trainerService.getTrainer(name));

        return modelAndView;
    }

    @GetMapping("/trainers/{name}/combatsHistory")
    String historyCombats(@PathVariable String name){
        return "history";
    }


    @GetMapping("/trainers/{name}/combatsHistory/{enemi}")
    String historyCombat(@PathVariable String name){
        return "historyOneCombat";
    }

}
