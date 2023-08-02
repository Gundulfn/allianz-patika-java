package com.burak.pokemon.database.entity;

import com.burak.pokemon.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "character")
@Data
public class CharacterEntity extends BaseEntity {

    @Column
    private String name;

    @Column(name = "special-power")
    private String specialPower;
}