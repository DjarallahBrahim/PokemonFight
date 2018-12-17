package com.ifi.tp.Combats.Controller;

import com.ifi.tp.Combats.CombatService.CombatsService;
import com.ifi.tp.Combats.boo.Round;
import com.ifi.tp.pokemonTypes.service.PokemonServiceImpl;
import org.springframework.stereotype.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class CombatsController {

    private CombatsService combatsService;
    private PokemonServiceImpl pokemonService;
    @Autowired
    public CombatsController(CombatsService combatsService, PokemonServiceImpl pokemonService) {
        this.combatsService = combatsService;
        this.pokemonService = pokemonService;
    }

    @RequestMapping(
            value = "/combats/fight",
            params = { "trainer1", "trainer2" },
            method = POST)
    @ResponseBody
    ModelAndView index(@RequestParam String trainer1, @RequestParam String trainer2){
        var modelAndView = new ModelAndView("combatResult");


        HashMap<Integer, String> hmap = new HashMap<Integer, String>();
        var fight = this.combatsService.startCombat(trainer1,trainer2);

        for(Round round : fight.getRounds()){
            var pkID1 = round.getIdPokemon1();
            var pkID2 = round.getIdPokemon2();
            if(!hmap.containsKey(pkID1)) {
                hmap.put(pkID1, this.pokemonService.getPokemonType(pkID1).getName());
               // modelAndView.addObject(String.valueOf(pkID1), this.pokemonService.getPokemonType(pkID1).getName());
            }
            if(!hmap.containsKey(pkID2)) {
                hmap.put(pkID2, this.pokemonService.getPokemonType(pkID2).getName());
               // modelAndView.addObject(String.valueOf(pkID2), this.pokemonService.getPokemonType(pkID2).getName());

            }
        }



        modelAndView.addObject("combatResult", fight);

        modelAndView.addObject("pokemonMap", hmap);
        return modelAndView;
    }



}
