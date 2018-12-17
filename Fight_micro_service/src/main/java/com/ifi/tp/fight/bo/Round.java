package com.ifi.tp.fight.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Round {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private int number;
    @NotNull
    private int idPokemon1, idPokemon2;
    @NotNull
    private int hpHints;//if positive the pokemon1 will lose hpHints if negative the pokemon 2 will lose |hpHints|

    public Round(){}

    public Round(@NotNull int number, @NotNull int idPokemon1, @NotNull int idPokemon2, @NotNull int hpHints) {
        this.number = number;
        this.idPokemon1 = idPokemon1;
        this.idPokemon2 = idPokemon2;
        this.hpHints = hpHints;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getIdPokemon1() {
        return idPokemon1;
    }

    public void setIdPokemon1(int idPokemon1) {
        this.idPokemon1 = idPokemon1;
    }

    public int getIdPokemon2() {
        return idPokemon2;
    }

    public void setIdPokemon2(int idPokemon2) {
        this.idPokemon2 = idPokemon2;
    }

    public int getHpHints() {
        return hpHints;
    }

    public void setHpHints(int hpHints) {
        this.hpHints = hpHints;
    }
}
