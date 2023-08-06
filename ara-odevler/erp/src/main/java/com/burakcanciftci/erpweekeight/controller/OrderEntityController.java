package com.burakcanciftci.erpweekeight.controller;

import com.burakcanciftci.erpweekeight.database.entity.OrderEntity;
import com.burakcanciftci.erpweekeight.model.Company;
import com.burakcanciftci.erpweekeight.model.OrderStateEnum;
import com.burakcanciftci.erpweekeight.service.OrderEntityService;
import com.burakcanciftci.erpweekeight.util.dbutil.BaseEntityController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("order")
public class OrderEntityController extends BaseEntityController<OrderEntity> {
    @Autowired
    OrderEntityService orderEntityService;

    @PostMapping("create")
    public ResponseEntity<OrderEntity> createOrderEntity(@RequestBody OrderEntity orderEntity) {
        OrderEntity _orderEntity = orderEntityService.createOrder(
                orderEntity.getCustomer(), orderEntity.getOrderedProductList());

        return new ResponseEntity<>(_orderEntity, HttpStatus.CREATED);
    }

    @PutMapping("update-order-state/{uuid}")
    public ResponseEntity<OrderEntity> updateOrderStateByUuid(@PathVariable UUID uuid,
                                                              @RequestBody OrderStateEnum orderState) {
        // This method creates a bill if order is approved
        OrderEntity orderEntity = orderEntityService.updateOrderState(uuid, orderState,
                Company.PLACEHOLDER_COMPANY_NAME);

        if (orderState != null) {
            return new ResponseEntity<>(orderEntity, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}