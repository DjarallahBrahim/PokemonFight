package com.ifi.tp.Combats.Controller;

import com.ifi.tp.Combats.CombatService.CombatsService;
import org.springframework.stereotype.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class CombatsController {

    private CombatsService combatsService;

    @Autowired
    public CombatsController(CombatsService combatsService) {
        this.combatsService = combatsService;
    }

    @RequestMapping(
            value = "/combats/fight",
            params = { "trainer1", "trainer2" },
            method = POST)
    @ResponseBody
    ModelAndView index(@RequestParam String trainer1, @RequestParam String trainer2){

        var modelAndView = new ModelAndView("combatResult");

        modelAndView.addObject("combatResult", this.combatsService.startCombat(trainer1,trainer2));

        return modelAndView;
    }



}
