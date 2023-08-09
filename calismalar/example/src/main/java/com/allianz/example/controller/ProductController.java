package com.allianz.example.controller;

import com.allianz.example.database.entity.ProductEntity;
import com.allianz.example.mapper.ProductMapper;
import com.allianz.example.model.ProductDTO;
import com.allianz.example.model.requestDTO.ProductRequestDTO;
import com.allianz.example.service.ProductService;
import com.allianz.example.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController extends BaseController<ProductEntity, ProductRequestDTO, ProductDTO> {
    @Autowired
    ProductService productService;

    @Autowired
    ProductMapper productMapper;
}
