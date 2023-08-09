package com.allianz.example.mapper;

import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.model.TaxDTO;
import com.allianz.example.model.requestDTO.TaxRequestDTO;
import com.allianz.example.util.BaseMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class TaxMapper extends BaseMapper<TaxDTO, TaxEntity, TaxRequestDTO> {
    @PostConstruct
    public void init(){
        this.init(TaxEntity.class, TaxDTO.class);
    }
}
