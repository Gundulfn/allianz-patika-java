package com.allianz.example.service;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.database.repository.CategoryEntityRepository;
import com.allianz.example.model.CategoryDTO;
import com.allianz.example.model.requestDTO.CategoryRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends BaseService<CategoryEntity, CategoryRequestDTO, CategoryDTO> {

    private final CategoryEntityRepository addressEntityRepository;

    public CategoryService(CategoryEntityRepository addressEntityRepository) {
        super(addressEntityRepository);
        this.addressEntityRepository = addressEntityRepository;
    }

}
