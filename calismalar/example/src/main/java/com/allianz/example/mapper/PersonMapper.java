package com.allianz.example.mapper;

import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.model.PersonDTO;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import com.allianz.example.util.BaseMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper extends BaseMapper<PersonDTO, PersonEntity, PersonRequestDTO> {
    @PostConstruct
    public void init(){
        this.init(PersonEntity.class, PersonDTO.class);
    }
}
