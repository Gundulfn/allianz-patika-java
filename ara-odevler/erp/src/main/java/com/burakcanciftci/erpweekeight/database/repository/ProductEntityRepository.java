package com.burakcanciftci.erpweekeight.database.repository;

import com.burakcanciftci.erpweekeight.database.entity.ProductEntity;
import com.burakcanciftci.erpweekeight.util.dbutil.IBaseEntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductEntityRepository extends IBaseEntityRepository<ProductEntity, Long> {
}
