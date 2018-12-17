package com.ifi.tp.controller;

import com.ifi.tp.fight.bo.Fight;
import com.ifi.tp.fight.service.FightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FightController {

    private FightService fightService;

    @Autowired
    public FightController(FightService fightService) {
        this.fightService = fightService;
    }

    @GetMapping("/trainers/{trainer1}/fight/{trainer2}")
    @ResponseBody
    public Fight fightLanche(@PathVariable String trainer1, @PathVariable String trainer2){
        return fightService.fight(trainer1,trainer2);
    }
}
