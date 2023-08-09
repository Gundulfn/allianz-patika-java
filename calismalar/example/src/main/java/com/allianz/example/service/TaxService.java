package com.allianz.example.service;

import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.database.repository.TaxEntityRepository;
import com.allianz.example.model.TaxDTO;
import com.allianz.example.model.requestDTO.TaxRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.stereotype.Service;

@Service
public class TaxService extends BaseService<TaxEntity, TaxRequestDTO, TaxDTO> {

    private final TaxEntityRepository taxEntityRepository;

    public TaxService(TaxEntityRepository taxEntityRepository) {
        super(taxEntityRepository);
        this.taxEntityRepository = taxEntityRepository;
    }

}
