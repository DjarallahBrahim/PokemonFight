package com.ifi.tp.controller;

import com.ifi.tp.Combats.CombatService.CombatsService;
import com.ifi.tp.Combats.boo.Fight;
import com.ifi.tp.trainers.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TrainerController {

    @Autowired
    private TrainerService trainerService;
    @Autowired
    private CombatsService combatsService;

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
    Fight historyCombats(@PathVariable String name){

        Fight fight = this.combatsService.getCombatsHestory(name);

        var modelAndView = new ModelAndView("history");

        modelAndView.addObject("history", fight);


        return fight;
    }


    @GetMapping("/trainers/{name}/combatsHistory/{enemi}")
    String historyCombat(@PathVariable String name){
        return "historyOneCombat";
    }

}
