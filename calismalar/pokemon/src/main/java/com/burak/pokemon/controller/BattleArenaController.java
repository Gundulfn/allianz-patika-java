package com.burak.pokemon.controller;

import com.burak.pokemon.database.entity.BattleArenaEntity;
import com.burak.pokemon.model.BattleArena;
import com.burak.pokemon.service.BattleArenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("battle-arena")
public class BattleArenaController {
    @Autowired
    BattleArenaService battleArenaService;

    @GetMapping("source/{key}")
    public ResponseEntity<List<BattleArenaEntity>> getBattleArenaEntityByNameContains(@PathVariable String key) {
        return new ResponseEntity<>(battleArenaService.getBattleArenaListEntityByNameContains(key), HttpStatus.OK);
    }

    @GetMapping("source-all")
    public ResponseEntity<List<BattleArenaEntity>> getBattleArenaList() {
        return new ResponseEntity<>(battleArenaService.getBattleArenaList(), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<BattleArenaEntity> createBattleArenaEntity(@RequestBody BattleArena battleArena) {
        BattleArenaEntity battleArenaEntity = battleArenaService.createBattleArenaEntity(battleArena.getName(),
                battleArena.getWeatherEnum());

        return new ResponseEntity<>(battleArenaEntity, HttpStatus.CREATED);
    }
}
