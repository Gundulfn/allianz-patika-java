package com.allianz.example.mapper;

import com.allianz.example.database.entity.CategoryEntity;
import com.allianz.example.model.CategoryDTO;
import com.allianz.example.model.requestDTO.CategoryRequestDTO;
import com.allianz.example.util.BaseMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper extends BaseMapper<CategoryDTO, CategoryEntity, CategoryRequestDTO> {
    @PostConstruct
    public void init(){
        this.init(CategoryEntity.class, CategoryDTO.class);
    }
}
