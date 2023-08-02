package com.burak.pokemon.service;

import com.burak.pokemon.database.entity.CharacterEntity;
import com.burak.pokemon.database.entity.PokemonEntity;
import com.burak.pokemon.database.repository.CharacterEntityRepository;
import com.burak.pokemon.model.ElementTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    @Autowired
    CharacterEntityRepository characterEntityRepository;

    public CharacterEntity createCharacterEntity(String name, String specialPower) {
        CharacterEntity characterEntity = new CharacterEntity();
        characterEntity.setName(name);
        characterEntity.setSpecialPower(specialPower);

        characterEntityRepository.save(characterEntity);
        return characterEntity;
    }

    public List<CharacterEntity> getCharacterEntityList() {
        return characterEntityRepository.findAll();
    }

    public CharacterEntity getCharacterEntityByNameEqualsIgnoreCase(String name) {
        return characterEntityRepository.findAllByNameEqualsIgnoreCase(name).get(0);
    }

    public CharacterEntity getCharacterEntityByPhraseString(String phrase) {
        phrase = phrase.replace("\"", "");
        String[] phraseParts = phrase.split(" ");

        for (String part : phraseParts) {
            part = part.trim();
            if (characterEntityRepository.findAllByNameEqualsIgnoreCase(part).size() > 0) {
                return characterEntityRepository.findAllByNameEqualsIgnoreCase(part).get(0);
            }
        }

        return null;
    }
}