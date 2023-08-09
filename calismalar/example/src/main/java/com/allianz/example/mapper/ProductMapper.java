package com.allianz.example.mapper;

import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.util.BaseMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper extends BaseMapper<ProductDTO, ProductEntity, ProductRequestDTO> {
    @PostConstruct
    public void init(){
        this.init(ProductEntity.class, ProductDTO.class);
    }
}
