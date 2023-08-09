package com.allianz.example.database.repository;

import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.util.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxEntityRepository extends IBaseRepository<TaxEntity, Long> {

}
