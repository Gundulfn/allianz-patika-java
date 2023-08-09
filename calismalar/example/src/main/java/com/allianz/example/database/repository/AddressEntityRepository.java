package com.allianz.example.database.repository;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.util.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressEntityRepository extends IBaseRepository<AddressEntity, Long> {

}
