package com.burakcanciftci.erpweekeight.database.repository;

import com.burakcanciftci.erpweekeight.database.entity.KdvEntity;
import com.burakcanciftci.erpweekeight.model.ProductCategoryEnum;
import com.burakcanciftci.erpweekeight.util.dbutil.IBaseEntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KdvEntityRepository extends IBaseEntityRepository<KdvEntity, Long> {
    KdvEntity findByCategory(ProductCategoryEnum category);
}
