package com.burakcanciftci.erpweekeight.service;

import com.burakcanciftci.erpweekeight.database.entity.ProductEntity;
import com.burakcanciftci.erpweekeight.database.repository.ProductEntityRepository;
import com.burakcanciftci.erpweekeight.model.ProductCategoryEnum;
import com.burakcanciftci.erpweekeight.util.dbutil.BaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class ProductEntityService extends BaseEntityService<ProductEntity> {

    @Autowired
    ProductEntityRepository productEntityRepository;

    public ProductEntity createProduct(String title, String description, String brandName, String companyName,
                                       ProductCategoryEnum category, BigDecimal price, Boolean isKdvApplied){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setTitle(title);
        productEntity.setDescription(description);
        productEntity.setBrandName(brandName);
        productEntity.setCompanyName(companyName);
        productEntity.setCategory(category);
        productEntity.setPrice(price);
        productEntity.setIsKdvApplied(isKdvApplied);

        productEntityRepository.save(productEntity);
        return productEntity;
    }

    @Override
    protected ProductEntity updateEntity(ProductEntity oldEntity, ProductEntity newEntity){
        oldEntity.setTitle(newEntity.getTitle());
        oldEntity.setDescription(newEntity.getDescription());
        oldEntity.setBrandName(newEntity.getBrandName());
        oldEntity.setCompanyName(newEntity.getCompanyName());
        oldEntity.setCategory(newEntity.getCategory());
        oldEntity.setPrice(newEntity.getPrice());
        oldEntity.setIsKdvApplied(newEntity.getIsKdvApplied());

        productEntityRepository.save(oldEntity);
        return oldEntity;
    }

    public ProductEntity updateProductPrice(UUID uuid, BigDecimal newPrice){
        ProductEntity productEntity = getByUUID(uuid);

        if (productEntity != null) {
            productEntity.setPrice(newPrice);

            productEntityRepository.save(productEntity);
            return productEntity;
        }

        return null;
    }
}
