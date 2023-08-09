package com.burakcanciftci.erpweekeight.util.dbutil;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class BaseEntityService<T extends BaseEntity> {

    @Autowired
    IBaseEntityRepository<T, Long> baseEntityRepository;

    public T getByUUID(UUID uuid) {
        Optional<T> entityOptional = baseEntityRepository.findByUuid(uuid);

        return entityOptional.orElse(null);
    }

    public List<T> getAll(){
        return baseEntityRepository.findAll();
    }

    public T updateByUUID(UUID uuid, T entity) {
        T _entity = getByUUID(uuid);

        if (_entity != null) {
            return updateEntity(_entity, entity);
        }

        return null;
    }

    protected abstract T updateEntity(T oldEntity, T newEntity);

    @Transactional
    public Boolean deleteByUUID(UUID uuid) {
        T entity = getByUUID(uuid);

        if (entity != null) {

            baseEntityRepository.deleteByUuid(uuid);

            return true;
        }

        return false;
    }
}
