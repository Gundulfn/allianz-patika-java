package com.burak.pokemon.database.repository;

import com.burak.pokemon.database.entity.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PokemonEntityRepository extends JpaRepository<PokemonEntity, Long> {
    List<PokemonEntity> findByUuidEquals(UUID uuid);
    List<PokemonEntity> findAllByNameEqualsIgnoreCase(String str);
}
