package com.allianz.example.service;

import com.allianz.example.database.entity.SettingsEntity;
import com.allianz.example.database.repository.SettingsEntityRepository;
import com.allianz.example.model.SettingsDTO;
import com.allianz.example.model.requestDTO.SettingsRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class SettingsService extends BaseService<SettingsEntity, SettingsRequestDTO, SettingsDTO> {
    private final SettingsEntityRepository settingsRepository;

    public SettingsService(SettingsEntityRepository settingsRepository) {
        super(settingsRepository);
        this.settingsRepository = settingsRepository;
    }
}
