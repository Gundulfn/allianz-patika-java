package com.allianz.example.service;

import com.allianz.example.database.entity.SellerEntity;
import com.allianz.example.database.repository.SellerEntityRepository;
import com.allianz.example.model.SellerDTO;
import com.allianz.example.model.requestDTO.SellerRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class SellerService extends BaseService<SellerEntity, SellerRequestDTO, SellerDTO> {

    private final SellerEntityRepository sellerEntityRepository;

    public SellerService(SellerEntityRepository sellerEntityRepository) {
        super(sellerEntityRepository);
        this.sellerEntityRepository = sellerEntityRepository;
    }

}
