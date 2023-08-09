package com.allianz.example.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public abstract class BaseController<ENTITY extends BaseEntity, RequestDTO extends BaseDTO, ResponseDTO extends BaseDTO> {

    @Autowired
    BaseService<ENTITY, RequestDTO, ResponseDTO> baseService;

    @Autowired
    BaseMapper<ResponseDTO, ENTITY, RequestDTO> baseMapper;

    @PostMapping("add")
    public ResponseEntity<ResponseDTO> createBill(@RequestBody RequestDTO requestDTO) {
        return new ResponseEntity<>(baseService.save(requestDTO), HttpStatus.OK);
    }

    @GetMapping("get/{uuid}")
    public ResponseEntity<ResponseDTO> getByUuid(@PathVariable UUID uuid) {

        ENTITY entity = baseService.getByUUID(uuid);

        if (entity != null) {
            return new ResponseEntity<>(baseMapper.entityToDTO(entity), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("get-all")
    public ResponseEntity<List<ResponseDTO>> getAll() {
        return new ResponseEntity<>(baseMapper.entityListToDTOList(baseService.getAll()), HttpStatus.OK);
    }

    /** NOTE: This method might set null variable, need to check
     */

    @PutMapping("update/{uuid}")
    public ResponseEntity<ResponseDTO> update(@RequestBody RequestDTO requestDTO, @PathVariable UUID uuid) {
        ResponseDTO responseDTO = baseService.updateByUUID(uuid, requestDTO);

        if (responseDTO != null) {
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.ALREADY_REPORTED);
    }

    @DeleteMapping("delete/{uuid}")
    public ResponseEntity<Boolean> deleteByUuid(@PathVariable UUID uuid) {
        Boolean isDeleted = baseService.deleteByUUID(uuid);

        if (isDeleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }

        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}