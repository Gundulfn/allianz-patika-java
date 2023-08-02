package com.burak.pokemon.service;

import com.burak.pokemon.database.entity.BattleArenaEntity;
import com.burak.pokemon.database.repository.BattleArenaEntityRepository;
import com.burak.pokemon.model.WeatherEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BattleArenaService {

    @Autowired
    BattleArenaEntityRepository battleArenaEntityRepository;

    public BattleArenaEntity createBattleArenaEntity(String name, WeatherEnum weatherEnum) {
        BattleArenaEntity pokemonEntity = new BattleArenaEntity();
        pokemonEntity.setName(name);
        pokemonEntity.setWeatherEnum(weatherEnum);

        battleArenaEntityRepository.save(pokemonEntity);
        return pokemonEntity;
    }

    public List<BattleArenaEntity> getBattleArenaListEntityByNameContains(String key) {
        return battleArenaEntityRepository.findAllByNameContains(key);
    }

    public List<BattleArenaEntity> getBattleArenaList() {
        return battleArenaEntityRepository.findAll();
    }
}