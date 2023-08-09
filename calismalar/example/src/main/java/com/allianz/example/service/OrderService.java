package com.allianz.example.service;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.repository.OrderEntityRepository;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.requestDTO.OrderRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends BaseService<OrderEntity, OrderRequestDTO, OrderDTO> {

    private final OrderEntityRepository orderEntityRepository;

    public OrderService(OrderEntityRepository orderEntityRepository) {
        super(orderEntityRepository);
        this.orderEntityRepository = orderEntityRepository;
    }
}
