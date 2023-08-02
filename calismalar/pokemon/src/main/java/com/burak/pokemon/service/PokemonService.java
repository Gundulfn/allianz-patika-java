package com.burak.pokemon.service;

import com.burak.pokemon.database.entity.PokemonEntity;
import com.burak.pokemon.database.repository.PokemonEntityRepository;
import com.burak.pokemon.model.ElementTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PokemonService {

    @Autowired
    PokemonEntityRepository pokemonEntityRepository;

    public PokemonEntity createPokemonEntity(String name, int health, int damage,
                                             ElementTypeEnum elementTypeEnum, String specialPower) {
        PokemonEntity pokemonEntity = new PokemonEntity();
        pokemonEntity.setName(name);
        pokemonEntity.setHealth(health);
        pokemonEntity.setDamage(damage);
        pokemonEntity.setElementTypeEnum(elementTypeEnum);
        pokemonEntity.setSpecialPower(specialPower);

        pokemonEntityRepository.save(pokemonEntity);
        return pokemonEntity;
    }

    public PokemonEntity getPokemonEntityByUUID(UUID pokemonUUID) {
        return pokemonEntityRepository.findByUuidEquals(pokemonUUID).get(0);
    }

    public List<PokemonEntity> getPokemonEntityList() {
        return pokemonEntityRepository.findAll();
    }

    public PokemonEntity getPokemonEntityByPhraseString(String phrase) {
        phrase = phrase.replace("\"", "");
        String[] phraseParts = phrase.split(" ");

        for (String part : phraseParts) {
            part = part.trim();
            if (pokemonEntityRepository.findAllByNameEqualsIgnoreCase(part).size() > 0) {
                return pokemonEntityRepository.findAllByNameEqualsIgnoreCase(part).get(0);
            }
        }

        return null;
    }
}