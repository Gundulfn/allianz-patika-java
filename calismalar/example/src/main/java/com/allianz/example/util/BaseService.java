package com.allianz.example.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public abstract class BaseService<Entity extends BaseEntity,
        RequestDTO extends BaseDTO,
        DTO extends BaseDTO> {

    private final IBaseRepository<Entity, Long> repository;
    
    protected BaseService(IBaseRepository<Entity, Long> repository) {
        this.repository = repository;
    }

    @Autowired
    private BaseMapper<DTO, Entity, RequestDTO> baseMapper;

    public List<Entity> getAll() {
        return repository.findAll();
    }

    public Boolean deleteByUUID(UUID uuid) {
        repository.deleteByUuid(uuid);

        return true;
    }

    public Entity getByUUID(UUID uuid) {
        Optional<Entity> optionalEntity = repository.findByUuid(uuid);
        return optionalEntity.orElse(null);
    }

    public DTO updateByUUID(UUID uuid, RequestDTO requestDTO){
        Entity entity = getByUUID(uuid);

        if(entity != null){
            BeanUtils.copyProperties(requestDTO, entity);
            repository.save(entity);

            return baseMapper.entityToDTO(entity);
        }

        return null;
    }

    public DTO save(RequestDTO requestDTO) {
        Entity entity = baseMapper.requestDTOToEntity(requestDTO);
        repository.save(entity);
        return baseMapper.entityToDTO(entity);
    }

}
