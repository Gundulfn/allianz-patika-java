package com.allianz.example.service;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.database.repository.AddressEntityRepository;
import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.requestDTO.AddressRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends BaseService<AddressEntity, AddressRequestDTO, AddressDTO> {

    private final AddressEntityRepository addressEntityRepository;

    
    public AddressService(AddressEntityRepository addressEntityRepository) {
        super(addressEntityRepository); 
        this.addressEntityRepository = addressEntityRepository;
    }

}
