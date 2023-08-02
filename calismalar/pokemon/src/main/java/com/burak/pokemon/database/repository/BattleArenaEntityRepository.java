package com.burak.pokemon.database.repository;
import com.burak.pokemon.database.entity.BattleArenaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BattleArenaEntityRepository extends JpaRepository<BattleArenaEntity, Long> {
    List<BattleArenaEntity> findAllByNameContains(String key);
}
