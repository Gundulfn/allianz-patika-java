package com.burakcanciftci.erpweekeight.controller;

import com.burakcanciftci.erpweekeight.database.entity.StockEntity;
import com.burakcanciftci.erpweekeight.service.StockEntityService;
import com.burakcanciftci.erpweekeight.util.dbutil.BaseEntityController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("stock")
public class StockEntityController extends BaseEntityController<StockEntity> {
    @Autowired
    StockEntityService stockEntityService;

    @PostMapping("create")
    public ResponseEntity<StockEntity> createStockEntity(@RequestBody StockEntity stockEntity) {
        StockEntity _stockEntity = stockEntityService.createStock(stockEntity.getProduct(), stockEntity.getCount());
        return new ResponseEntity<>(_stockEntity, HttpStatus.CREATED);
    }

    @PutMapping("reduce-stock-count/{uuid}")
    public ResponseEntity<StockEntity> reduceStockCountByUuid(@PathVariable UUID uuid,
                                                              @RequestBody Integer amount) {
        StockEntity stockEntity = stockEntityService.reduceStockCount(uuid, amount);

        if (stockEntity != null) {
            return new ResponseEntity<>(stockEntity, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}