package service;

import model.GameCharacter;
import model.Player;
import model.Pokemon;
import model.WeatherEnum;

import java.util.*;

public class GameService {
    private final LoadService loadService = new LoadService();
    private final GameCharacterService gameCharacterService = new GameCharacterService();
    private final WeatherService weatherService = new WeatherService();
    private final PokemonService pokemonService = new PokemonService();
    private final PlayerService playerService = new PlayerService();

    private int roundCount = 1;
    private WeatherEnum weatherEnum = WeatherEnum.NORMAL;

    public void setRoundCount(int value) {
        if (value > 0)
            roundCount = value;
    }

    private List<Pokemon> pokemonList;
    private List<GameCharacter> characterList;

    public Player[] getCustomizedPlayers(int playerCount, Scanner scanner) {
        GameCharacterService gameCharacterService = new GameCharacterService();

        Player[] players = new Player[playerCount];

        // Loading and ordering lists
        pokemonList = loadService.loadPokemons();

        // Lambda expression of Comparator<Pokemon>
        pokemonList.sort((o1, o2) -> o2.getDamage() - o1.getDamage());

        characterList = loadService.loadCharacters();

        // Setting players' attributes by their choices
        String playerName;
        GameCharacter gameCharacter;
        Pokemon pokemon;
        for (int i = 0; i < playerCount; i++) {
            System.out.print("Welcome Player " + (i + 1) + ", please enter your name: ");

            playerName = scanner.nextLine();
            System.out.println();

            gameCharacter = UtilityService.selectElementFromList(characterList, scanner,
                    "Please select your \"Character\" with ID number at left: ");
            System.out.println();

            pokemon = UtilityService.selectElementFromList(pokemonList, scanner,
                    "Please select your \"Pokemon\" with ID number at left: ");
            System.out.println();

            gameCharacterService.addPokemonToGameCharacter(gameCharacter, pokemon);
            players[i] = playerService.createPlayer(playerName, gameCharacter);

            // Removing selected items from lists
            characterList.remove(gameCharacter);
            pokemonList.remove(pokemon);

            // Resetting placeholder values
            playerName = "";
            gameCharacter = null;
            pokemon = null;
        }

        return players;
    }

    public void playSoloGame(Player[] players, Scanner scanner) {
        int firstPlayerIndex = new Random().nextInt(0, 2);
        int secondPlayerIndex = (firstPlayerIndex == 0 ? 1 : 0);

        System.out.println();
        System.out.println("Player " + players[firstPlayerIndex].getName() + " will attack first");

        Pokemon firstPlayerPokemon = UtilityService.selectElementFromList(
                players[firstPlayerIndex].getCharacter().getPokemonList(),
                scanner, players[firstPlayerIndex].getName() + ", please select your pokemon to fight: ");

        Pokemon secondPlayerPokemon = UtilityService.selectElementFromList(
                players[secondPlayerIndex].getCharacter().getPokemonList(),
                scanner, players[secondPlayerIndex].getName() + ", please select your pokemon to fight: ");

        boolean roundContinues;
        while (gameCharacterService.isThereLivingPokemon(players[firstPlayerIndex].getCharacter()) &&
                gameCharacterService.isThereLivingPokemon(players[secondPlayerIndex].getCharacter())) {
            System.out.println("-------------------------------");
            weatherEnum = WeatherEnum.getRandomWeather();
            System.out.println("Weather is: " + weatherEnum);

            roundContinues = executePlayerTurn(players[firstPlayerIndex], players[secondPlayerIndex],
                    firstPlayerPokemon, secondPlayerPokemon, scanner);

            if (!roundContinues)
                break;

            firstPlayerPokemon = gameCharacterService.getLivingPokemon(firstPlayerPokemon,
                    players[firstPlayerIndex].getCharacter(),
                    pokemonService, scanner);
            secondPlayerPokemon = gameCharacterService.getLivingPokemon(secondPlayerPokemon,
                    players[secondPlayerIndex].getCharacter(),
                    pokemonService, scanner);

            roundContinues = executePlayerTurn(players[secondPlayerIndex], players[firstPlayerIndex],
                    secondPlayerPokemon, firstPlayerPokemon, scanner);

            if (!roundContinues)
                break;

            firstPlayerPokemon = gameCharacterService.getLivingPokemon(firstPlayerPokemon,
                    players[firstPlayerIndex].getCharacter(),
                    pokemonService, scanner);
            secondPlayerPokemon = gameCharacterService.getLivingPokemon(secondPlayerPokemon,
                    players[secondPlayerIndex].getCharacter(),
                    pokemonService, scanner);
        }

        // Next round check
        roundCount--;
        if (roundCount > 0) {
            System.out.println("Next Round\n--------------------------");
            playSoloGame(players, scanner);
        } else {

            if (gameCharacterService.isThereLivingPokemon(players[firstPlayerIndex].getCharacter())) {
                playerService.setPlayerWinner(players[firstPlayerIndex]);
            } else {
                playerService.setPlayerWinner(players[secondPlayerIndex]);
            }
        }
    }

    /**
     * Method
     * Results:
     * - true means attacker and defender pokemons are alive, fight continues
     * - false means one of the pokemon has been defeated, stop fight
     */
    boolean usePokemonSpecialPower, useCharacterSpecialPower;

    private boolean executePlayerTurn(Player attacker, Player defender,
                                      Pokemon attackerPokemon, Pokemon defenderPokemon, Scanner scanner) {
        System.out.println();
        System.out.println(attacker.getName() + " turn!");

        // Pokemon's special ability selection
        System.out.println(attackerPokemon.getName() + " special power: " + attackerPokemon.getSpecialPower());
        System.out.print("Do you want to use it? (Press y): ");
        usePokemonSpecialPower = scanner.nextLine().equalsIgnoreCase("y");

        // Character's special ability selection
        System.out.println(attacker.getCharacter().getName() + " special power: " +
                attacker.getCharacter().getSpecialPower());
        System.out.print("Do you want to use it? (Press y): ");
        useCharacterSpecialPower = scanner.nextLine().equalsIgnoreCase("y");

        attack(attacker, attackerPokemon, defenderPokemon,
                usePokemonSpecialPower, useCharacterSpecialPower);

        if (!playerService.checkIfPlayerCanFight(defender, gameCharacterService)) {
            playerService.defeatPlayer(attacker, defender, pokemonService, gameCharacterService, pokemonList);
            return false;
        }

        if (!playerService.checkIfPlayerCanFight(attacker, gameCharacterService)) {
            playerService.defeatPlayer(defender, attacker, pokemonService, gameCharacterService, pokemonList);
            return false;
        }

        return true;
    }

    private void attack(Player attacker, Pokemon attackerPokemon, Pokemon defenderPokemon,
                        boolean isPokemonSpecialPower, boolean isCharacterSpecialPower) {
        int damage = attackerPokemon.getDamage();

        // Weather affection on pokemon
        weatherService.affectPokemonByWeather(weatherEnum, attackerPokemon, false);
        weatherService.affectPokemonByWeather(weatherEnum, defenderPokemon, false);

        if (isPokemonSpecialPower &&
                attackerPokemon.getSpecialPower().getRemainingRights() <= 0) {
            System.out.println("You passed your turn");
            return;
        }

        if (isCharacterSpecialPower &&
                attacker.getCharacter().getSpecialPower().getRemainingRights() <= 0) {
            System.out.println("You passed your turn");
            return;
        }

        if (isPokemonSpecialPower)
            damage = attackerPokemon.specialAttack();

        if (isCharacterSpecialPower)
            damage += attacker.getCharacter().specialAttack();

        // Weather affection on attack
        weatherService.affectPokemonByWeather(weatherEnum, attackerPokemon, true);
        damage += weatherService.getWeatherEffectOnDamage(weatherEnum, attackerPokemon);

        defenderPokemon.setHealth(defenderPokemon.getHealth() - damage);
        System.out.println(attackerPokemon.getName() + " attacks!");
        System.out.println("Attack results: \n" + attackerPokemon + "\n" + defenderPokemon);
    }
}