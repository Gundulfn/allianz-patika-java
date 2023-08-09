package com.allianz.example.database.entity;

import com.allianz.example.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "person")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "person_uuid"
        )
)
@Data
public class PersonEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private int birthYear;

    @Column
    private String tc;
    // When renaming column such as @Column(name = "T_C"), it creates new column as "t_c"
    // Hibernate: alter table if exists person add column t_c varchar(255)

    @OneToMany(mappedBy = "personEntity")
    private List<AddressEntity> addressEntityList;
}
