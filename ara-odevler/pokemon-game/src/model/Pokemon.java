package model;

public class Pokemon {
    private String name;
    private int health;
    private int initialHealth;
    private int damage;
    private TypeEnum type;
    private SpecialPower specialPower;

    public Pokemon(String name, int initialHealth, int damage, TypeEnum type, SpecialPower specialPower) {
        this.name = name;
        this.initialHealth = initialHealth;
        this.health = initialHealth;
        this.damage = damage;
        this.type = type;
        this.specialPower = specialPower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInitialHealth() {
        return initialHealth;
    }

    public void setInitialHealth(int initialHealth) {
        this.initialHealth = initialHealth;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
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
            return this.damage + this.specialPower.getExtraDamage();
        } else {
            System.out.println("You can not use special power!");
            return this.damage;
        }
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                ", type=" + type +
                '}';
    }
}
