package com.ifi.tp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class CombatsController {

    @RequestMapping(
            value = "/combats/fight",
            params = { "trainer1", "trainer2" },
            method = POST)
    @ResponseBody
    String index(@RequestParam String trainer1, @RequestParam String trainer2){

        return trainer1 + "VS" + trainer2;
    }



}
