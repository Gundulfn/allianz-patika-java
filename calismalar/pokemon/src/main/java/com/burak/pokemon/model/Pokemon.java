package com.burak.pokemon.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Pokemon {
    private UUID uuid;
    private String name;
    private int health;
    private int damage;
    private ElementTypeEnum elementTypeEnum;
    private String specialPower;

    public Pokemon(String name, int health, int damage, ElementTypeEnum elementTypeEnum, String specialPower) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.elementTypeEnum = elementTypeEnum;
        this.specialPower = specialPower;
    }
}