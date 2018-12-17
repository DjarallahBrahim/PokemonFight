package com.ifi.tp.fight.bo;

import com.ifi.tp.trainers.bo.Trainer;

import java.util.List;

public class Fight {

    private Trainer traier1, trainer2;
    private List<Round> rounds;
    private int idWinner;

    public Trainer getTraier1() {
        return traier1;
    }

    public void setTraier1(Trainer traier1) {
        this.traier1 = traier1;
    }

    public Trainer getTrainer2() {
        return trainer2;
    }

    public void setTrainer2(Trainer trainer2) {
        this.trainer2 = trainer2;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    public int getIdWinner() {
        return idWinner;
    }

    public void setIdWinner(int idWinner) {
        this.idWinner = idWinner;
    }
}
