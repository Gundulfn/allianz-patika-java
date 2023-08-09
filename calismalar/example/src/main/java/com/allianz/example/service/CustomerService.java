package com.allianz.example.service;

import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.database.repository.CustomerEntityRepository;
import com.allianz.example.model.CustomerDTO;
import com.allianz.example.model.requestDTO.CustomerRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseService<CustomerEntity, CustomerRequestDTO, CustomerDTO> {

    private final CustomerEntityRepository customerEntityRepository;

    public CustomerService(CustomerEntityRepository customerEntityRepository) {
        super(customerEntityRepository);
        this.customerEntityRepository = customerEntityRepository;
    }

}
