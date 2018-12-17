package com.ifi.tp.controller;

import com.ifi.tp.listener.NotificationReceiver;
import com.ifi.tp.service.NotificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class CombatsController {

    private NotificationReceiver notificationReceiver;

    @Autowired
    public CombatsController(NotificationReceiver notificationReceiver) {
        this.notificationReceiver = notificationReceiver;
    }

    @RequestMapping(
            value = "/combats/fight",
            params = { "trainer1", "trainer2" },
            method = POST)
    @ResponseBody
    String index(@RequestParam String trainer1, @RequestParam String trainer2){


        return this.notificationReceiver.getMessage();
    }



}
