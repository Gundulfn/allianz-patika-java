package com.allianz.example.database.repository;

import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.util.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerEntityRepository extends IBaseRepository<CustomerEntity, Long> {

}
