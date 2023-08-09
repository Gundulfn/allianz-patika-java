package com.allianz.example.service;

import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.database.repository.ProductEntityRepository;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends BaseService<ProductEntity, ProductRequestDTO, ProductDTO> {

    private final ProductEntityRepository productEntityRepository;

    public ProductService(ProductEntityRepository productEntityRepository) {
        super(productEntityRepository);
        this.productEntityRepository = productEntityRepository;
    }

}
