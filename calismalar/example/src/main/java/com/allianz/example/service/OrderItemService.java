package com.allianz.example.service;

import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.database.repository.OrderItemEntityRepository;
import com.allianz.example.model.OrderItemDTO;
import com.allianz.example.model.requestDTO.OrderItemRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService extends BaseService<OrderItemEntity, OrderItemRequestDTO, OrderItemDTO> {

    private final OrderItemEntityRepository orderItemEntityRepository;

    public OrderItemService(OrderItemEntityRepository orderItemEntityRepository) {
        super(orderItemEntityRepository);
        this.orderItemEntityRepository = orderItemEntityRepository;
    }

}
