package service;

import model.GameCharacter;
import model.Player;
import model.Pokemon;

import java.util.List;

public class PlayerService {
    public Player createPlayer(String name, model.GameCharacter character){
        return new Player(name, character, false);
    }

    public void addCharacterToPlayer(Player player, GameCharacter character){
        player.setCharacter(character);
    }

    public void setPlayerWinner(Player player){
        player.setWinner(true);
    }

    public boolean checkIfPlayerCanFight(Player player, GameCharacterService gameCharacterService) {
        if (gameCharacterService.isThereLivingPokemon(player.getCharacter())) {
            return true;
        } else {
            System.out.println(player.getName() + " cannot continue to fight");
            return false;
        }
    }

    public void defeatPlayer(Player winnerPlayer, Player defeatedPlayer,
                             PokemonService pokemonService, GameCharacterService gameCharacterService,
                             List<Pokemon> pokemonList) {
        System.out.println(winnerPlayer.getName() + " WON");
        pokemonService.restoreHealthAll(defeatedPlayer.getCharacter().getPokemonList());
        gameCharacterService.addPokemonToGameCharacter(
                winnerPlayer.getCharacter(),
                defeatedPlayer.getCharacter().getPokemonList());

        // Give defeated player the least powerful pokemon which is at the end of list
        defeatedPlayer.getCharacter().setPokemonList(null);
        gameCharacterService.addPokemonToGameCharacter(
                defeatedPlayer.getCharacter(),
                pokemonList.get(pokemonList.size() - 1));
        System.out.println(winnerPlayer.getName() + " took all pokemons of " + defeatedPlayer.getName());
    }
}
