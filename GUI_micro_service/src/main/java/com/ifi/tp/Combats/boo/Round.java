package com.ifi.tp.Combats.boo;



public class Round {


    private int id;
    private int number;
    private int idPokemon1, idPokemon2;
    private int hpHints;//if positive the pokemon1 will lose hpHints if negative the pokemon 2 will lose |hpHints|

    public Round(){}

    public Round(int number,  int idPokemon1,  int idPokemon2,  int hpHints) {
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
