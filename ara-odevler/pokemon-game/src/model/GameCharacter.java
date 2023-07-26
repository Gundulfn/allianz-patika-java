package model;

import java.util.ArrayList;

public class GameCharacter {
    private String name;
    private SpecialPower specialPower;
    private ArrayList<Pokemon> pokemonList;

    public GameCharacter(String name, SpecialPower specialPower) {
        this.name = name;
        this.specialPower = specialPower;
        this.pokemonList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SpecialPower getSpecialPower() {
        return specialPower;
    }

    public void setSpecialPower(SpecialPower specialPower) {
        this.specialPower = specialPower;
    }

    public int specialAttack() {
        if (this.specialPower.getRemainingRights() > 0) {
            this.specialPower.setRemainingRights(this.specialPower.getRemainingRights() - 1);
            return this.specialPower.getExtraDamage();
        } else {
            System.out.println("You can not use special power!");
            return 0;
        }
    }

    public ArrayList<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(ArrayList<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    @Override
    public String toString() {
        return "GameCharacter{" +
                "name='" + name + '\'' +
                ", specialPower=" + specialPower;
    }
}
