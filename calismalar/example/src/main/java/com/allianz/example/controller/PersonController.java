package com.allianz.example.controller;

import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.mapper.PersonMapper;
import com.allianz.example.model.PersonDTO;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import com.allianz.example.service.PersonService;
import com.allianz.example.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("person")
public class PersonController extends BaseController<PersonEntity, PersonRequestDTO, PersonDTO> {
    @Autowired
    PersonService personService;

    @Autowired
    PersonMapper personMapper;
}
