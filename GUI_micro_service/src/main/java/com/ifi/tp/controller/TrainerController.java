package com.ifi.tp.controller;

import com.ifi.tp.Combats.CombatService.CombatsService;
import com.ifi.tp.Combats.boo.Fight;
import com.ifi.tp.tmp.HestoryCombatTPM;
import com.ifi.tp.trainers.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

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
    ModelAndView historyCombats(@PathVariable String name){

        Fight [] fight = this.combatsService.getCombatsHestory(name);

        List<HestoryCombatTPM> hestoryCombatTPMList= new ArrayList<>();

        for(int i=0; i< fight.length; i++){
            HestoryCombatTPM tmpHestpry = new HestoryCombatTPM();
            tmpHestpry.setTrainerAsker(name);
            if(!fight[i].getTrainer1().equals(name))
                tmpHestpry.setEnemy(fight[i].getTrainer1());
            else
                tmpHestpry.setEnemy(fight[i].getTrainer2());

            if(!fight[i].getWinner().equals(name))
                tmpHestpry.setResult(false);
            else
                tmpHestpry.setResult(true);

            hestoryCombatTPMList.add(tmpHestpry);

        }


        var modelAndView = new ModelAndView("history");
        System.out.print(fight.length);
        modelAndView.addObject("history", fight);
        modelAndView.addObject("historytmp", hestoryCombatTPMList);


        return modelAndView;
    }


    @GetMapping("/trainers/{name}/combatsHistory/{enemi}")
    String historyCombat(@PathVariable String name){
        return "historyOneCombat";
    }


    @GetMapping("/trainers/arena/{name}")
    @ResponseBody
    ModelAndView arena(@PathVariable String name){

        var modelAndView = new ModelAndView("arena");

        modelAndView.addObject("arena", trainerService.getAllTrainers());
        modelAndView.addObject("asker", name);

        return modelAndView;
    }

}
