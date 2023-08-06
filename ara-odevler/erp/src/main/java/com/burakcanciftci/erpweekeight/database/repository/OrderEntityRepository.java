package com.burakcanciftci.erpweekeight.database.repository;

import com.burakcanciftci.erpweekeight.database.entity.OrderEntity;
import com.burakcanciftci.erpweekeight.util.dbutil.BaseEntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderEntityRepository extends BaseEntityRepository<OrderEntity, Long> {
}
