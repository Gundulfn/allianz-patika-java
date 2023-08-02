package com.burak.pokemon.controller;

import com.burak.pokemon.database.entity.PokemonEntity;
import com.burak.pokemon.model.Pokemon;
import com.burak.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("pokemon")
public class PokemonController {
    @Autowired
    PokemonService pokemonService;

    @GetMapping("source/{pokemonUuid}")
    public ResponseEntity<PokemonEntity> getPokemonByUUID(@PathVariable UUID pokemonUuid) {
        return new ResponseEntity<>(pokemonService.getPokemonEntityByUUID(pokemonUuid), HttpStatus.OK);
    }

    @GetMapping("source")
    public ResponseEntity<PokemonEntity> getPokemonByPhraseString(@RequestBody String phrase) {
        return new ResponseEntity<>(pokemonService.getPokemonEntityByPhraseString(phrase), HttpStatus.OK);
    }

    @GetMapping("source-all")
    public ResponseEntity<List<PokemonEntity>> getPokemonList() {
        return new ResponseEntity<>(pokemonService.getPokemonEntityList(), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<PokemonEntity> createPokemon(@RequestBody Pokemon pokemon) {
        PokemonEntity pokemonEntity = pokemonService.createPokemonEntity(pokemon.getName(), pokemon.getHealth(),
                pokemon.getDamage(), pokemon.getElementTypeEnum(), pokemon.getSpecialPower());

        return new ResponseEntity<>(pokemonEntity, HttpStatus.CREATED);
    }
}
