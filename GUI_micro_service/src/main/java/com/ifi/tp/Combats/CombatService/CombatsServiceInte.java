package com.ifi.tp.Combats.CombatService;

import com.ifi.tp.Combats.boo.Fight;

public interface CombatsServiceInte {
    Fight startCombat(String trainer1, String trainer2);

    Fight getCombatsHestory(String trainer1);
}
