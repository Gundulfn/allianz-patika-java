package com.burakcanciftci.erpweekeight.util.dbutil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public class BaseEntityController<T> {
    @Autowired
    BaseEntityService<T> baseEntityService;

    @GetMapping("source/{uuid}")
    public ResponseEntity<T> getEntityByUuid(@PathVariable UUID uuid) {
        T entity = baseEntityService.getByUUID(uuid);

        if (entity != null) {
            return new ResponseEntity<>(entity, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("source-all")
    public ResponseEntity<List<T>> getEntityList() {
        return new ResponseEntity<>(baseEntityService.getAll(), HttpStatus.OK);
    }

    @PutMapping("update/{uuid}")
    public ResponseEntity<T> updateEntity(@RequestBody T entity, @PathVariable UUID uuid) {
        T _entity = baseEntityService.updateByUUID(uuid, entity);

        if (_entity != null) {
            return new ResponseEntity<>(_entity, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("delete/{uuid}")
    public ResponseEntity<Boolean> deleteEntityByUuid(@PathVariable UUID uuid,
                                                      @RequestBody T entity) {
        Boolean isDeleted = baseEntityService.deleteByUUID(uuid);

        if (isDeleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }

        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
