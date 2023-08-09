package com.allianz.example.mapper;

import com.allianz.example.database.entity.Settings;
import com.allianz.example.model.SettingsDTO;
import com.allianz.example.model.requestDTO.SettingsRequestDTO;
import com.allianz.example.util.BaseMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class SettingsMapper extends BaseMapper<SettingsDTO, Settings, SettingsRequestDTO> {
    @PostConstruct
    public void init(){
        this.init(Settings.class, SettingsDTO.class);
    }
}
