package com.allianz.example.database.entity;

import com.allianz.example.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "address")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "address_uuid"
        )
)
@Data
public class AddressEntity extends BaseEntity {
    @Column
    private String title;

    @Column(length = 500)
    private String address;

    @ManyToOne
    private PersonEntity personEntity;
}
