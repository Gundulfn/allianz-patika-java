package com.allianz.example.controller;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.mapper.AddressMapper;
import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.requestDTO.AddressRequestDTO;
import com.allianz.example.service.AddressService;
import com.allianz.example.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("address")
public class AddressController extends BaseController<AddressEntity, AddressRequestDTO, AddressDTO> {
    @Autowired
    AddressService addressService;

    @Autowired
    AddressMapper addressMapper;
}
