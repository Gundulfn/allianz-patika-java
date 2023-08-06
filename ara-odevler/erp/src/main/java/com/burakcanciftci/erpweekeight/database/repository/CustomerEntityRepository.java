package com.burakcanciftci.erpweekeight.database.repository;

import com.burakcanciftci.erpweekeight.database.entity.CustomerEntity;
import com.burakcanciftci.erpweekeight.util.dbutil.BaseEntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerEntityRepository extends BaseEntityRepository<CustomerEntity, Long> {
}
