package com.allianz.example.database.entity;

import com.allianz.example.model.enums.OrderStatusEnum;
import com.allianz.example.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Table
@Entity
public class OrderEntity extends BaseEntity {
    @ManyToOne
    private CustomerEntity customer;

    @Enumerated(EnumType.STRING)
    private OrderStatusEnum orderStatus;

    @OneToMany
    private List<OrderItemEntity> orderItemList;

    @Column
    private BigDecimal totalSellPrice;

}
