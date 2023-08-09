package com.allianz.example.mapper;

import com.allianz.example.database.entity.SellerEntity;
import com.allianz.example.model.SellerDTO;
import com.allianz.example.model.requestDTO.SellerRequestDTO;
import com.allianz.example.util.BaseMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class SellerMapper extends BaseMapper<SellerDTO, SellerEntity, SellerRequestDTO> {
    @PostConstruct
    public void init(){
        this.init(SellerEntity.class, SellerDTO.class);
    }
}
