package com.burak.pokemon.controller;

import com.burak.pokemon.database.entity.BattleArenaEntity;
import com.burak.pokemon.database.entity.CharacterEntity;
import com.burak.pokemon.model.BattleArena;
import com.burak.pokemon.model.Character;
import com.burak.pokemon.service.BattleArenaService;
import com.burak.pokemon.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("character")
public class CharacterController {
    @Autowired
    CharacterService characterService;

    @GetMapping("source-all")
    public ResponseEntity<List<CharacterEntity>> getCharacterEntityList() {
        return new ResponseEntity<>(characterService.getCharacterEntityList(), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<CharacterEntity> createCharacterEntity(@RequestBody Character character) {
        CharacterEntity characterEntity = characterService.createCharacterEntity(character.getName(),
                character.getSpecialPower());

        return new ResponseEntity<>(characterEntity, HttpStatus.CREATED);
    }
}
