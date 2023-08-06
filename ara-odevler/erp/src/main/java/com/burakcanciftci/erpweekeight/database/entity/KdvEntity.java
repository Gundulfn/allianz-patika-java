package com.burakcanciftci.erpweekeight.database.entity;

import com.burakcanciftci.erpweekeight.model.ProductCategoryEnum;
import com.burakcanciftci.erpweekeight.util.dbutil.BaseEntity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Entity
@Table(name = "kdv")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "kdv_uuid"
        )
)
@Data
public class KdvEntity extends BaseEntity {

    @Column(unique = true)
    private ProductCategoryEnum category;

    @Column
    private BigDecimal kdvRate;
}
