package com.allianz.example.service;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.repository.BillEntityRepository;
import com.allianz.example.model.BillDTO;
import com.allianz.example.model.requestDTO.BillRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class BillService extends BaseService<BillEntity, BillRequestDTO, BillDTO> {

    private final BillEntityRepository billEntityRepository;

    
    public BillService(BillEntityRepository billEntityRepository) {
        super(billEntityRepository); 
        this.billEntityRepository = billEntityRepository;
    }

}
