package com.allianz.example.database.repository;

import com.allianz.example.database.entity.Settings;
import com.allianz.example.util.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingsRepository extends IBaseRepository<Settings, Long> {

}
