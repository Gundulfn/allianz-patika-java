package com.allianz.example.database.entity;

import com.allianz.example.util.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class TaxEntity extends BaseEntity {
    @Column
    private String name;

    @Column(unique = true)
    private String code;

    @Column
    private Double rate;
}
