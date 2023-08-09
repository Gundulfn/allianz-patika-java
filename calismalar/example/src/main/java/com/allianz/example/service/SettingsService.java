package com.allianz.example.service;

import com.allianz.example.database.entity.Settings;
import com.allianz.example.database.repository.SettingsRepository;
import com.allianz.example.model.SettingsDTO;
import com.allianz.example.model.requestDTO.SettingsRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class SettingsService extends BaseService<Settings, SettingsRequestDTO, SettingsDTO> {
    private final SettingsRepository settingsRepository;

    public SettingsService(SettingsRepository settingsRepository) {
        super(settingsRepository);
        this.settingsRepository = settingsRepository;
    }
}
