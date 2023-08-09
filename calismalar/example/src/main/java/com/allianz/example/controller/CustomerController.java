package com.allianz.example.controller;

import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.mapper.CustomerMapper;
import com.allianz.example.model.CustomerDTO;
import com.allianz.example.model.requestDTO.CustomerRequestDTO;
import com.allianz.example.service.CustomerService;
import com.allianz.example.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
public class CustomerController extends BaseController<CustomerEntity, CustomerRequestDTO, CustomerDTO> {
    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerMapper customerMapper;
}
