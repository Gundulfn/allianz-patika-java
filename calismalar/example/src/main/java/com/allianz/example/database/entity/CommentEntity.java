package com.allianz.example.database.entity;

import com.allianz.example.util.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Table
@Entity
@Data
public class CommentEntity extends BaseEntity {
    @ManyToOne
    private CustomerEntity customer;

    @Column
    private String comment;
}
