package service;

import model.*;
import model.GameCharacter;

import java.util.ArrayList;

public class LoadService {
    public ArrayList<GameCharacter> loadCharacters(){
        SpecialPower strategy1 = new Strategy("Perfect Strategy", 4, 1);
        SpecialPower strategy2 = new Strategy("Almost-Perfect Strategy ", 3, 1);

        GameCharacter ash = new Ash("Ash", strategy1, null);
        GameCharacter brooke = new Brooke("Brooke", strategy2, null);

        ArrayList<GameCharacter> characterList = new ArrayList<>();
        characterList.add(ash);
        characterList.add(brooke);

        return characterList;
    }

    public ArrayList<Pokemon> loadPokemons(){
        SpecialPower electricity = new Electricity("Electricty", 3, 1);
        SpecialPower water = new Water("Water", 1, 1);
        SpecialPower fire = new Fire("Fire", 5, 1);
        SpecialPower earth = new Earth("Earth", 4, 1);

        Pokemon pokemon1 = new Pikachu("Pikachu", 100, 10, TypeEnum.ELECTRICITY, electricity);
        Pokemon pokemon2 = new Sqiurtle("Squirtle", 100, 8, TypeEnum.WATER, water);
        Pokemon pokemon3 = new Charmander("Charmender", 100, 12, TypeEnum.FIRE, fire);
        Pokemon pokemon4 = new Balbausar("Balbausar", 100, 7, TypeEnum.EARTH, earth);

        ArrayList<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(pokemon1);
        pokemonList.add(pokemon2);
        pokemonList.add(pokemon3);
        pokemonList.add(pokemon4);

        return pokemonList;
    }
}
