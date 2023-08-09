package com.burakcanciftci.erpweekeight.database.repository;

import com.burakcanciftci.erpweekeight.database.entity.StockEntity;
import com.burakcanciftci.erpweekeight.util.dbutil.IBaseEntityRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StockEntityRepository extends IBaseEntityRepository<StockEntity, Long> {
    Optional<StockEntity> findByProductUuid(UUID uuid);
}
