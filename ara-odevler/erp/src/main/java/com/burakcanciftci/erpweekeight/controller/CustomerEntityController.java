package com.burakcanciftci.erpweekeight.controller;

import com.burakcanciftci.erpweekeight.database.entity.CustomerEntity;
import com.burakcanciftci.erpweekeight.service.CustomerEntityService;
import com.burakcanciftci.erpweekeight.util.dbutil.BaseEntityController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerEntityController extends BaseEntityController<CustomerEntity>{
    @Autowired
    CustomerEntityService customerEntityService;

    @PostMapping("create")
    public ResponseEntity<CustomerEntity> createCustomerEntity(@RequestBody CustomerEntity customerEntity) {
        CustomerEntity _customerEntity = customerEntityService.createCustomer(
                customerEntity.getName(), customerEntity.getSurname(),
                customerEntity.getEmail(), customerEntity.getPhoneNo(), customerEntity.getAddress());

        return new ResponseEntity<>(_customerEntity, HttpStatus.CREATED);
    }
}