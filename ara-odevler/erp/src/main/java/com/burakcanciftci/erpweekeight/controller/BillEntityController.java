package com.burakcanciftci.erpweekeight.controller;

import com.burakcanciftci.erpweekeight.database.entity.BillEntity;
import com.burakcanciftci.erpweekeight.service.BillEntityService;
import com.burakcanciftci.erpweekeight.util.dbutil.BaseEntityController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("bill")
public class BillEntityController extends BaseEntityController<BillEntity> {
    @Autowired
    BillEntityService billEntityService;

    @PostMapping("create")
    public ResponseEntity<BillEntity> createBillEntity(@RequestBody BillEntity billEntity) {
        BillEntity _billEntity = billEntityService.createBill(billEntity.getOrder(), billEntity.getCompanyName());

        return new ResponseEntity<>(_billEntity, HttpStatus.CREATED);
    }
}