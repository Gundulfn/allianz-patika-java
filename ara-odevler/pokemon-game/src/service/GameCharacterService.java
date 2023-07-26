package service;

import model.GameCharacter;
import model.Pokemon;
import model.SpecialPower;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameCharacterService {
    public void addPokemonToGameCharacter(GameCharacter gameCharacter, Pokemon pokemon){
        // Null check
        if(gameCharacter.getPokemonList() == null)
            gameCharacter.setPokemonList(new ArrayList<>());

        gameCharacter.getPokemonList().add(pokemon);
    }

    public void addPokemonToGameCharacter(GameCharacter gameCharacter, ArrayList<Pokemon> pokemonList){
        // Null check
        if(gameCharacter.getPokemonList() == null)
            gameCharacter.setPokemonList(pokemonList);

        gameCharacter.getPokemonList().addAll(pokemonList);
    }

    public boolean isThereLivingPokemon(GameCharacter gameCharacter){
        for(Pokemon pokemon : gameCharacter.getPokemonList()){
            if(pokemon.getHealth() > 0){
                return true;
            }
        }

        return false;
    }

    public Pokemon getLivingPokemon(Pokemon currentPokemon, GameCharacter character, PokemonService pokemonService,
                                     Scanner scanner) {
        if (currentPokemon.getHealth() <= 0) {
            if (isThereLivingPokemon(character)) {
                return UtilityService.selectElementFromList(
                        pokemonService.getLivingPokemonsFromList(character.getPokemonList()),
                        scanner,
                        "Pokemon "
                                + currentPokemon.getName() + " is defeated"
                                + ", please select new pokemon to fight: ");
            } else {
                return null;
            }
        } else {
            return currentPokemon;
        }
    }
}
