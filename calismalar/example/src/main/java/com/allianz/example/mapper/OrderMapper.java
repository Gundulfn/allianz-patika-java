package com.allianz.example.mapper;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.requestDTO.OrderRequestDTO;
import com.allianz.example.util.BaseMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper extends BaseMapper<OrderDTO, OrderEntity, OrderRequestDTO> {
    @PostConstruct
    public void init(){
        this.init(OrderEntity.class, OrderDTO.class);
    }
}
