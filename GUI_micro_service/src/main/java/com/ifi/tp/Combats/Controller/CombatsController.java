package com.ifi.tp.Combats.Controller;

import com.ifi.tp.Combats.CombatService.CombatsService;
import com.ifi.tp.Combats.boo.Fight;
import org.springframework.stereotype.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    Fight index(@RequestParam String trainer1, @RequestParam String trainer2){

        return this.combatsService.startCombat(trainer1,trainer2);
    }



}
