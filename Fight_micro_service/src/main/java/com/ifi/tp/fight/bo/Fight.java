package com.ifi.tp.fight.bo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Fight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private String trainer1, trainer2;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Round> rounds;

    private String Winner;

    public Fight() {
        this.rounds = new ArrayList<Round>();
    }

    public Fight(@NotNull String trainer1, @NotNull String trainer2, List<Round> rounds, String winner) {
        this.trainer1 = trainer1;
        this.trainer2 = trainer2;
        this.rounds = rounds;
        Winner = winner;
        this.rounds = new ArrayList<Round>();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrainer1() {
        return trainer1;
    }

    public void setTrainer1(String trainer1) {
        this.trainer1 = trainer1;
    }

    public String getTrainer2() {
        return trainer2;
    }

    public void setTrainer2(String trainer2) {
        this.trainer2 = trainer2;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    public String getWinner() {
        return Winner;
    }

    public void setWinner(String winner) {
        Winner = winner;
    }

    public void addRound(Round e){
        this.rounds.add(e);
    }
}
