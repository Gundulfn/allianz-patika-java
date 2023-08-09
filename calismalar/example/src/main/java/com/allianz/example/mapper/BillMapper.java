package com.allianz.example.mapper;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.model.BillDTO;
import com.allianz.example.model.requestDTO.BillRequestDTO;
import com.allianz.example.util.BaseMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class BillMapper extends BaseMapper<BillDTO, BillEntity, BillRequestDTO> {
    @PostConstruct
    public void init(){
        this.init(BillEntity.class, BillDTO.class);
    }
}
