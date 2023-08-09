package com.allianz.example.database.repository;

import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.util.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductEntityRepository extends IBaseRepository<ProductEntity, Long> {

}
