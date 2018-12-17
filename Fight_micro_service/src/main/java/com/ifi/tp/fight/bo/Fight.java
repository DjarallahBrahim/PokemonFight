package com.ifi.tp.fight.bo;

import com.ifi.tp.trainers.bo.Trainer;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
@Entity
public class Fight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private Long trainer1, trainer2;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Round> rounds;

    private int idWinner;

    public Fight() {

    }

    public Fight(@NotNull long trainer1, @NotNull long trainer2, List<Round> rounds, int idWinner) {
        this.trainer1 = trainer1;
        this.trainer2 = trainer2;
        this.rounds = rounds;
        this.idWinner = idWinner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTrainer1() {
        return trainer1;
    }

    public void setTrainer1(long trainer1) {
        this.trainer1 = trainer1;
    }

    public long getTrainer2() {
        return trainer2;
    }

    public void setTrainer2(long trainer2) {
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
