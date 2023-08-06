package com.burakcanciftci.erpweekeight.model;

import com.burakcanciftci.erpweekeight.database.entity.ProductEntity;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
public class OrderedProduct implements Serializable {

    private Product product;

    private BigDecimal priceWithoutKdv;

    private BigDecimal priceWithKdv;

    private String kdv;

    private Integer count;
}
