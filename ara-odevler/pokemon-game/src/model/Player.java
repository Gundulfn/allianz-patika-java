package model;

public class Player {
    private String name;
    private GameCharacter character;
    private boolean isWinner;

    public Player(String name, GameCharacter character, boolean isWinner) {
        this.name = name;
        this.character = character;
        this.isWinner = isWinner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GameCharacter getCharacter() {
        return character;
    }

    public void setCharacter(GameCharacter character) {
        this.character = character;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", characters=" + character +
                ", isWinner=" + isWinner +
                '}';
    }
}
