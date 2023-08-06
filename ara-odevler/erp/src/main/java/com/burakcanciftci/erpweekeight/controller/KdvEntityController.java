package com.burakcanciftci.erpweekeight.controller;

import com.burakcanciftci.erpweekeight.database.entity.KdvEntity;
import com.burakcanciftci.erpweekeight.service.KdvEntityService;
import com.burakcanciftci.erpweekeight.util.dbutil.BaseEntityController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kdv")
public class KdvEntityController extends BaseEntityController<KdvEntity>{
    @Autowired
    KdvEntityService kdvEntityService;

    @PostMapping("create")
    public ResponseEntity<KdvEntity> createKdvEntity(@RequestBody KdvEntity kdvEntity) {
        KdvEntity _kdvEntity = kdvEntityService.createKdv(
                kdvEntity.getCategory(), kdvEntity.getKdvRate());

        return new ResponseEntity<>(_kdvEntity, HttpStatus.CREATED);
    }
}