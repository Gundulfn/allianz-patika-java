package com.burakcanciftci.erpweekeight.database.entity;

import com.burakcanciftci.erpweekeight.util.dbutil.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "customer")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "customer_uuid"
        )
)
@Data
public class CustomerEntity extends BaseEntity{
        @Column
        private String name;

        @Column
        private String surname;

        @Column
        private String email;

        @Column
        private String phoneNo;

        @Column
        private String address;
}
