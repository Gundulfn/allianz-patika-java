package com.allianz.example.controller;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.mapper.CategoryMapper;
import com.allianz.example.model.CategoryDTO;
import com.allianz.example.model.requestDTO.CategoryRequestDTO;
import com.allianz.example.service.CategoryService;
import com.allianz.example.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
public class CategoryController extends BaseController<CategoryEntity, CategoryRequestDTO, CategoryDTO> {
    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryMapper categoryMapper;
}
