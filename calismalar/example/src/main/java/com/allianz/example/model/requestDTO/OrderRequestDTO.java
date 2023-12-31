package com.allianz.example.model.requestDTO;

import com.allianz.example.model.CustomerDTO;
import com.allianz.example.model.OrderItemDTO;
import com.allianz.example.model.enums.OrderStatusEnum;
import com.allianz.example.util.BaseDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderRequestDTO extends BaseDTO {
    private CustomerDTO customer;
    private List<OrderItemDTO> orderItemList;
    private OrderStatusEnum orderStatus;
    private BigDecimal totalSellPrice;
}
