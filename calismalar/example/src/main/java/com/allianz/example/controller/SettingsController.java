package com.allianz.example.controller;

import com.allianz.example.database.entity.SettingsEntity;
import com.allianz.example.mapper.SettingsMapper;
import com.allianz.example.model.SettingsDTO;
import com.allianz.example.model.requestDTO.SettingsRequestDTO;
import com.allianz.example.service.SettingsService;
import com.allianz.example.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("settings")
public class SettingsController extends BaseController<SettingsEntity, SettingsRequestDTO, SettingsDTO> {
    @Autowired
    SettingsService settingsService;

    @Autowired
    SettingsMapper settingsMapper;
}
