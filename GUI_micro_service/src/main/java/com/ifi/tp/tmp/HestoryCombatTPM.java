package com.ifi.tp.tmp;

public class HestoryCombatTPM {

    private String trainerAsker;

    private String enemy;

    private boolean result;

    public HestoryCombatTPM(String trainerAsker, String enemy, boolean result) {
        this.trainerAsker = trainerAsker;
        this.enemy = enemy;
        this.result = result;
    }

    public HestoryCombatTPM(){}

    public String getTrainerAsker() {
        return trainerAsker;
    }

    public void setTrainerAsker(String trainerAsker) {
        this.trainerAsker = trainerAsker;
    }

    public String getEnemy() {
        return enemy;
    }

    public void setEnemy(String enemy) {
        this.enemy = enemy;
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
