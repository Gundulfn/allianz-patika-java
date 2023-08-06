package com.burakcanciftci.erpweekeight.database.entity;

import com.burakcanciftci.erpweekeight.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "stock")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "stock_uuid"
        )
)
@Data
public class StockEntity extends BaseEntity {

        @OneToOne
        @JoinColumn(name = "product_id")
        private ProductEntity product;

        @Column
        private Integer count;
}
