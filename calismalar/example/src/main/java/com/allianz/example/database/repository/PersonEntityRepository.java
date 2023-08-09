package com.allianz.example.database.repository;

import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.util.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonEntityRepository extends IBaseRepository<PersonEntity, Long> {

}
