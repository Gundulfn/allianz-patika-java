package service;

import model.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class PokemonService {
    public void restoreHealthAll(List<Pokemon> pokemonList){
        for (Pokemon pokemon : pokemonList){
            pokemon.setHealth(pokemon.getInitialHealth());
        }
    }

    public List<Pokemon> getLivingPokemonsFromList(List<Pokemon> pokemonList){
        List<Pokemon> livingPokemonList = new ArrayList<>();
        for(Pokemon pokemon : pokemonList){
            if(pokemon.getHealth() > 0)
                livingPokemonList.add(pokemon);
        }

        return livingPokemonList;
    }
}