package com.burak.pokemon.controller;

import com.burak.pokemon.service.CharacterService;
import com.burak.pokemon.service.PokemonService;
import com.burak.pokemon.util.dbutil.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("selection")
public class SelectionController {
    @Autowired
    PokemonService pokemonService;

    @Autowired
    CharacterService characterService;

    @GetMapping
    public ResponseEntity<List<BaseEntity>> getPokemonAndCharacterEntitiesByPhrase(@RequestBody String phrase){
        List<BaseEntity> baseEntityList = new ArrayList<>();
        baseEntityList.add(characterService.getCharacterEntityByPhraseString(phrase));
        baseEntityList.add(pokemonService.getPokemonEntityByPhraseString(phrase));

        return new ResponseEntity<>(baseEntityList, HttpStatus.OK);
    }
}
