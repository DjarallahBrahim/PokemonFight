package com.ifi.tp.controller;

import com.ifi.tp.fight.bo.Fight;
import com.ifi.tp.fight.repository.FightRepository;
import com.ifi.tp.fight.service.FightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FightController {

    private FightService fightService;

    private FightRepository fightRepository;
    @Autowired
    public FightController(FightService fightService,FightRepository fightRepository) {
        this.fightService = fightService;
        this.fightRepository = fightRepository;
    }

    @GetMapping("/trainers/{trainer1}/fight/{trainer2}")
    @ResponseBody
    public Fight fightLanche(@PathVariable String trainer1, @PathVariable String trainer2){
        Fight f = fightService.fight(trainer1,trainer2);
        fightRepository.save(f);
        return f;
    }

    @GetMapping("/trainers/{trainer}/history")
    @ResponseBody
    public Iterable<Fight> fightHistory(@PathVariable String trainer){
        return fightRepository.findByTrainer1OrTrainer2(trainer,trainer);
    }
}
