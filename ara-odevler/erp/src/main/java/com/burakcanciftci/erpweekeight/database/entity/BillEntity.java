package com.burakcanciftci.erpweekeight.database.entity;

import com.burakcanciftci.erpweekeight.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "bill")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "bill_uuid"
        )
)
@Data
public class BillEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "ordered_product_id")
    private OrderEntity order;

    @Column
    private String companyName;

    @Column
    private BigDecimal totalPrice;

    @Column
    private BigDecimal totalKdv;
}