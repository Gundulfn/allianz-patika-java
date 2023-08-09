package com.allianz.example.service;

import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.database.repository.PersonEntityRepository;
import com.allianz.example.model.PersonDTO;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends BaseService<PersonEntity, PersonRequestDTO, PersonDTO> {
    private final PersonEntityRepository personEntityRepository;

    public PersonService(PersonEntityRepository personEntityRepository) {
        super(personEntityRepository);
        this.personEntityRepository = personEntityRepository;
    }
}