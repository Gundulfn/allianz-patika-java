package com.allianz.example.database.repository;

import com.allianz.example.database.entity.SettingsEntity;
import com.allianz.example.util.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingsEntityRepository extends IBaseRepository<SettingsEntity, Long> {

}
