package com.ifi.tp.fight.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Round {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @NotNull
    private Long number;
    @NotNull
    private int idPokemon1, idPokemon2;
    @NotNull
    private int hpHints;

    public Round(){}

    public Round(Long number, int idPokemon1, int idPokemon2, int hpHints) {
        this.number = number;
        this.idPokemon1 = idPokemon1;
        this.idPokemon2 = idPokemon2;
        this.hpHints = hpHints;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
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
