package com.allianz.example.mapper;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.requestDTO.AddressRequestDTO;
import com.allianz.example.util.BaseMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper extends BaseMapper<AddressDTO, AddressEntity, AddressRequestDTO> {
    @PostConstruct
    public void init(){
        this.init(AddressEntity.class, AddressDTO.class);
    }
}
