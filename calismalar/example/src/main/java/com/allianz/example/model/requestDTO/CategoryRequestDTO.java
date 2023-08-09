package com.allianz.example.model.requestDTO;

import com.allianz.example.model.ProductDTO;
import com.allianz.example.util.BaseDTO;
import lombok.Data;

import java.util.List;

@Data
public class CategoryRequestDTO extends BaseDTO {
    private String name;
    private List<ProductDTO> productList;
}
