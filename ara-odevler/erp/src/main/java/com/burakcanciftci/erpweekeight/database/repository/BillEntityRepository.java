package com.burakcanciftci.erpweekeight.database.repository;

import com.burakcanciftci.erpweekeight.database.entity.BillEntity;
import com.burakcanciftci.erpweekeight.util.dbutil.BaseEntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillEntityRepository extends BaseEntityRepository<BillEntity, Long> {
}
