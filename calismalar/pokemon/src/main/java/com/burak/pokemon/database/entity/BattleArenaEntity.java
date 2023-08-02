package com.burak.pokemon.database.entity;

import com.burak.pokemon.model.WeatherEnum;
import com.burak.pokemon.util.dbutil.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "battle_arena")
@Data
public class BattleArenaEntity extends BaseEntity {

    @Column
    private String name;

    @Column(name = "weather")
    private WeatherEnum weatherEnum;
}
