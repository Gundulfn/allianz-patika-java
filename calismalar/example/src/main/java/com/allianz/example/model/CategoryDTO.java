package com.allianz.example.model;

import com.allianz.example.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDTO extends BaseDTO {
    private String name;
    private List<ProductDTO> productList;
}
