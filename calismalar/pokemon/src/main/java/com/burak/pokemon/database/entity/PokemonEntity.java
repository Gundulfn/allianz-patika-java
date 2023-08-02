package com.burak.pokemon.database.entity;

import com.burak.pokemon.model.ElementTypeEnum;
import com.burak.pokemon.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "Pokemon")
@Data
public class PokemonEntity extends BaseEntity {
    private UUID uuid;

    @Column
    private String name;

    @Column
    private int health;

    @Column
    private int damage;

    @Column(name = "element_type")
    private ElementTypeEnum elementTypeEnum;

    @Column(name = "special_power")
    private String specialPower;
}
