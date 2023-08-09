package com.allianz.example.mapper;

import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.model.CustomerDTO;
import com.allianz.example.model.requestDTO.CustomerRequestDTO;
import com.allianz.example.util.BaseMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper extends BaseMapper<CustomerDTO, CustomerEntity, CustomerRequestDTO> {
    @PostConstruct
    public void init(){
        this.init(CustomerEntity.class, CustomerDTO.class);
    }
}
