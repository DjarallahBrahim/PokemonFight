package com.ifi.tp.Combats.CombatService;

import com.ifi.tp.Combats.boo.Fight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CombatsService implements  CombatsServiceInte {

    private RestTemplate restTemplate;

    @Autowired
    public CombatsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Fight startCombat(String trainer1, String trainer2) {
        var url ="http://localhost:8087/trainers/"+trainer1+"/fight/"+trainer2;
        var fight = restTemplate.getForObject(url, Fight.class);
        return fight;
    }


    @Override
    public Fight[] getCombatsHestory(String trainer1) {
        var url ="http://localhost:8087/trainers/"+trainer1+"/history";
        Fight fight[] = restTemplate.getForObject(url, Fight[].class);
        return fight;
    }
}
