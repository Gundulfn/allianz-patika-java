package com.burakcanciftci.erpweekeight.database.repository;

import com.burakcanciftci.erpweekeight.database.entity.BillEntity;
import com.burakcanciftci.erpweekeight.util.dbutil.IBaseEntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillEntityRepository extends IBaseEntityRepository<BillEntity, Long> {
}
