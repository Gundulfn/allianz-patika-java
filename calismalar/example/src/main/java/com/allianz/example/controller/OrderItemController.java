package com.allianz.example.controller;

import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.mapper.OrderItemMapper;
import com.allianz.example.model.OrderItemDTO;
import com.allianz.example.model.requestDTO.OrderItemRequestDTO;
import com.allianz.example.service.OrderItemService;
import com.allianz.example.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order-item")
public class OrderItemController extends BaseController<OrderItemEntity, OrderItemRequestDTO, OrderItemDTO> {
    @Autowired
    OrderItemService orderItemService;

    @Autowired
    OrderItemMapper orderItemMapper;
}
