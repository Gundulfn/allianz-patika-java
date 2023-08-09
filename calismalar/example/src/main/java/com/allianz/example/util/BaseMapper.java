package com.allianz.example.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BaseMapper<DTO extends BaseDTO, ENTITY extends BaseEntity, REQUESTDTO extends BaseDTO> {

    private Class<ENTITY> initialEntityClass;
    private Class<DTO> initialDTOClass;

    public void init(Class<ENTITY> entityValue, Class<DTO> dtoValue) {
        this.initialEntityClass = entityValue;
        this.initialDTOClass = dtoValue;
    }

    public ENTITY dtoToEntity(DTO dto) {
        ENTITY entity = null;
        try {
            entity = initialEntityClass.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(dto, entity);
        } catch (Exception e) {
            // Handle the exception appropriately
        }

        return entity;
    }

    public DTO entityToDTO(ENTITY entity) {
        DTO dto = null;
        try {
            dto = initialDTOClass.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(entity, dto);
        } catch (Exception e) {
            // Handle the exception appropriately
        }

        return dto;
    }

    public List<DTO> entityListToDTOList(List<ENTITY> personEntities) {
        List<DTO> dtoList = new ArrayList<>();
        for (ENTITY entity : personEntities) {
            dtoList.add(entityToDTO(entity));
        }
        return dtoList;
    }

    public List<ENTITY> dtoListToEntityList(List<DTO> dtos) {
        List<ENTITY> entityList = new ArrayList<>();
        for (DTO dto : dtos) {
            entityList.add(dtoToEntity(dto));
        }
        return entityList;
    }

    // How?? WHY???
    // @author: Mert Yıldız :D
    public ENTITY requestDTOToEntity(REQUESTDTO dto) {
        ENTITY _entity = null;
        try {
            _entity = initialEntityClass.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(dto, _entity);
        } catch (Exception e) {
            // Handle the exception appropriately
        }

        return _entity;
    }
}