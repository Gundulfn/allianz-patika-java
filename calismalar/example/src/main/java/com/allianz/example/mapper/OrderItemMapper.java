package com.allianz.example.mapper;

import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.model.OrderItemDTO;
import com.allianz.example.model.requestDTO.OrderItemRequestDTO;
import com.allianz.example.util.BaseMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper extends BaseMapper<OrderItemDTO, OrderItemEntity, OrderItemRequestDTO> {
    @PostConstruct
    public void init(){
        this.init(OrderItemEntity.class, OrderItemDTO.class);
    }
}
