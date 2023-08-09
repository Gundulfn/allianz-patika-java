package com.allianz.example.database.entity;

import com.allianz.example.model.enums.ColorEnum;
import com.allianz.example.util.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
@Table
public class ProductEntity extends BaseEntity {
    @Column
    private String name;
    private String code;

    // NOTE: Default is ORDINAL which is changeable by enum value order, therefore keep enums as string
    @Enumerated(EnumType.STRING)
    private ColorEnum color;

    @Column
    private BigDecimal sellPrice;
    @Column
    private BigDecimal buyPrice;
    @Column
    private Integer quantity;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "productList")
    @JsonIgnore // for handling infinite loop
    private Set<CategoryEntity> categorySet;

    @ManyToOne(fetch = FetchType.EAGER)
    private TaxEntity tax;
}
