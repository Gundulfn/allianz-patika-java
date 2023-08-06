package com.burakcanciftci.erpweekeight.database.entity;


import com.burakcanciftci.erpweekeight.model.ProductCategoryEnum;
import com.burakcanciftci.erpweekeight.util.dbutil.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "product")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "product_uuid"
        )
)
@Data
public class ProductEntity extends BaseEntity {
        @Column
        private String title;

        @Column
        private String description;

        @Column
        private String brandName;

        @Column
        private String companyName;

        @Column(name = "category")
        private ProductCategoryEnum category;

        @Column
        private BigDecimal price;

        @Column
        private Boolean isKdvApplied;
}
