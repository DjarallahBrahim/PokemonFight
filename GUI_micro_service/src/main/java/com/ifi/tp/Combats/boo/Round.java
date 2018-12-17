package com.ifi.tp.Combats.boo;


import javax.validation.constraints.NotNull;

public class Round {


    private int id;
    private int number;
    private int idPokemon1, idPokemon2;
    private int hpHints;//if positive the pokemon1 will lose hpHints if negative the pokemon 2 will lose |hpHints|
    private boolean pok1Attack;
    private String pokemon1, pokemon2;

    public Round(){}

    public Round(int number,  int idPokemon1,  int idPokemon2,  int hpHints, boolean pok1Attack,String pokemon1, String pokemon2) {
        this.number = number;
        this.idPokemon1 = idPokemon1;
        this.idPokemon2 = idPokemon2;
        this.hpHints = hpHints;
        this.pok1Attack = pok1Attack;
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
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

    public boolean isPok1Attack() {
        return pok1Attack;
    }

    public void setPok1Attack(boolean pok1Attack) {
        this.pok1Attack = pok1Attack;
    }

    public String getPokemon1() {
        return pokemon1;
    }

    public void setPokemon1(String pokemon1) {
        this.pokemon1 = pokemon1;
    }

    public String getPokemon2() {
        return pokemon2;
    }

    public void setPokemon2(String pokemon2) {
        this.pokemon2 = pokemon2;
    }
}
