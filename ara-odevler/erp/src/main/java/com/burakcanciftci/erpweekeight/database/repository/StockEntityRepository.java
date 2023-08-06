package com.burakcanciftci.erpweekeight.database.repository;

import com.burakcanciftci.erpweekeight.database.entity.ProductEntity;
import com.burakcanciftci.erpweekeight.database.entity.StockEntity;
import com.burakcanciftci.erpweekeight.util.dbutil.BaseEntityRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StockEntityRepository extends BaseEntityRepository<StockEntity, Long> {
    Optional<StockEntity> findByProductUuid(UUID uuid);
}
