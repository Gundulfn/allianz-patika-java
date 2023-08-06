package com.burakcanciftci.erpweekeight.controller;

import com.burakcanciftci.erpweekeight.database.entity.ProductEntity;
import com.burakcanciftci.erpweekeight.service.ProductEntityService;
import com.burakcanciftci.erpweekeight.util.dbutil.BaseEntityController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("product")
public class ProductEntityController extends BaseEntityController<ProductEntity> {
    @Autowired
    ProductEntityService productEntityService;

    @PostMapping("create")
    public ResponseEntity<ProductEntity> createProductEntity(@RequestBody ProductEntity productEntity) {
        ProductEntity _productEntity = productEntityService.createProduct(
                productEntity.getTitle(), productEntity.getDescription(),
                productEntity.getBrandName(), productEntity.getCompanyName(), productEntity.getCategory(),
                productEntity.getPrice(), productEntity.getIsKdvApplied());

        return new ResponseEntity<>(_productEntity, HttpStatus.CREATED);
    }

    @PutMapping("update-product-price/{uuid}")
    public ResponseEntity<ProductEntity> updateProductPriceByUuid(@PathVariable UUID uuid,
                                                                  @RequestBody BigDecimal price) {
        ProductEntity productEntity = productEntityService.updateProductPrice(uuid, price);

        if (productEntity != null) {
            return new ResponseEntity<>(productEntity, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}