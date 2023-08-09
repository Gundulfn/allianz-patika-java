package com.allianz.example.database.repository;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.util.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryEntityRepository extends IBaseRepository<CategoryEntity, Long> {

}
