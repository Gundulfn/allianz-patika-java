package com.burakcanciftci.erpweekeight.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
public class Product implements Serializable {
    private UUID uuid;

    private String title;

    private String description;

    private String brandName;

    private String companyName;

    private ProductCategoryEnum category;

    private BigDecimal price;

    private Boolean isKdvApplied;
}
