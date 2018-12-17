package com.ifi.tp.fight.service;

import com.ifi.tp.fight.bo.Fight;
import com.ifi.tp.fight.bo.Round;
import com.ifi.tp.pokemonTypes.service.PokemonService;
import com.ifi.tp.trainers.bo.Pokemon;
import com.ifi.tp.trainers.bo.Trainer;
import com.ifi.tp.trainers.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FightServiceImpl implements FightService{

    TrainerService trainerService;

    PokemonService pokemonService;
    Trainer trainer1, trainer2;

    Fight fight;


    @Autowired
    public FightServiceImpl(TrainerService trainerService, PokemonService pokemonService) {
        this.trainerService = trainerService;
        this.pokemonService = pokemonService;
    }

    @Override
    public Fight fight(String trainer1 ,String trainer2) {
        this.fight = new Fight();

        //get trainers data
        this.trainer1 = trainerService.getTrainer(trainer1);
        this.trainer2 = trainerService.getTrainer(trainer2);

        //
        fight.setTrainer1(trainer1);
        fight.setTrainer2(trainer2);

        this.startFight();

        return this.fight;
    }

    private void startFight() {
        int trainer1NbrRemainingPokemons = trainer1.getTeam().size();
        int trainer2NbrRemainingPokemons = trainer2.getTeam().size();


        Pokemon pokemon1 = trainer1.getTeam().get(0);
        Pokemon pokemon2 = trainer2.getTeam().get(0);

//        //stat = baseStat + level
//        pokemonAddLevel(pokemon1);
//        pokemonAddLevel(pokemon2);


        //true if the pokemon 1 is the one that will attack next
        boolean pk1Attack ;

        int numRound = 1;
        
        //equal to 1 if the pokemon 1 died or 2 if the pokemon 2 died
        int pkOneOrTwoDied = 0;

        while (trainer1NbrRemainingPokemons != 0 && trainer2NbrRemainingPokemons != 0) {//there is more pokemons in both teams

            pk1Attack = firstFaster(pokemon1,pokemon2);

            while (hpNotNullForBoth(pokemon1,pokemon2)) {//hp still for current pokemon

                Round round = this.calculateRound(pokemon1,pokemon2,numRound,pk1Attack);

                //le tour d'attack pass
                pk1Attack = (!pk1Attack);

                fight.addRound(round);

                numRound++;
            }

            // a pokemon died then substruc 1 from the nbr of pokemons
            if (pokemon1.getType().getStats().getHp() <= 0){
                trainer1NbrRemainingPokemons --;
                pkOneOrTwoDied = 1;
            } else if(pokemon2.getType().getStats().getHp()<= 0) {
                trainer2NbrRemainingPokemons--;
                pkOneOrTwoDied = 2;
            }

            //no more pokemons for a trainer set a winner and break from the loop
            if (trainer1NbrRemainingPokemons == 0){
                fight.setWinner(trainer2.getName());
                System.out.println(trainer2.getName());
                break;
            }
            else if(trainer2NbrRemainingPokemons == 0) {
                fight.setWinner(trainer1.getName());
                System.out.println(trainer1.getName());

                break;
            }


            // a pokemon died check tack another pokemon
            if (pkOneOrTwoDied == 1){
                pokemon1 = trainer1.getTeam().get(trainer1.getTeam().size()-trainer1NbrRemainingPokemons );
            }else if(pkOneOrTwoDied == 2){
                pokemon2 = trainer2.getTeam().get(trainer2.getTeam().size()-trainer1NbrRemainingPokemons );
            }
                

        }

    }

    private Round calculateRound(Pokemon pokemon1, Pokemon pokemon2,int roundNumber, boolean pk1Attack){
        int hpHint = 0;
        if (pk1Attack) { //pokemon 1 will attack pokemon 2
            hpHint = pokemon1.getType().getStats().getAttack() - pokemon2.getType().getStats().getDefense();
            if (hpHint <0)
                hpHint = 0;
            //update pokemon hp state
            pokemon2.getType().getStats().setHp(pokemon2.getType().getStats().getHp() - hpHint);
        }else{ //pokemon 2 will attack pokemon 1
            hpHint = pokemon2.getType().getStats().getAttack() - pokemon1.getType().getStats().getDefense();
            if (hpHint <0)
                hpHint = 0;
            else
                hpHint = (-hpHint);
            //update pokemon hp state
            pokemon1.getType().getStats().setHp(pokemon1.getType().getStats().getHp() + hpHint);
        }

        var pokemon1Name = this.pokemonService.getPokemonType(pokemon1.getPokemonNumber()).getName();
        var pokemon2Name = this.pokemonService.getPokemonType(pokemon2.getPokemonNumber()).getName();

        Round round = new Round(roundNumber, pokemon1.getPokemonNumber(),
                                pokemon2.getPokemonNumber(),hpHint,pk1Attack,
                pokemon1Name,pokemon2Name);

        return round;
    }

    private boolean firstFaster(Pokemon pokemon1, Pokemon pokemon2){
        return pokemon1.getType().getStats().getSpeed() > pokemon2.getType().getStats().getSpeed();
    }

    private boolean hpNotNullForBoth(Pokemon p,Pokemon p2){
        return (p.getType().getStats().getHp() != 0) && (p2.getType().getStats().getHp() != 0);
    }

//    private void pokemonAddLevel(Pokemon pokemon, int level){
//        pokemon.getType().getStats().setHp(pokemon.getType().getStats().getHp()+pokemon.getType().);
//        pokemon.getType().getStats().setAttack(pokemon.getType().getStats().getAttack()+level);
//        pokemon.getType().getStats().setSpeed(pokemon.getType().getStats().getSpeed()+level);
//        pokemon.getType().getStats().setDefense(pokemon.getType().getStats().getDefense()+level);
//    }

}
