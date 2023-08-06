package com.burakcanciftci.erpweekeight.service;

import com.burakcanciftci.erpweekeight.database.entity.ProductEntity;
import com.burakcanciftci.erpweekeight.database.entity.StockEntity;
import com.burakcanciftci.erpweekeight.database.repository.StockEntityRepository;
import com.burakcanciftci.erpweekeight.model.Product;
import com.burakcanciftci.erpweekeight.util.dbutil.BaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StockEntityService extends BaseEntityService<StockEntity> {

    @Autowired
    StockEntityRepository stockEntityRepository;

    public StockEntity createStock(ProductEntity product, Integer count){
        StockEntity stockEntity = new StockEntity();
        stockEntity.setProduct(product);
        stockEntity.setCount(count);

        stockEntityRepository.save(stockEntity);
        return stockEntity;
    }

    @Override
    protected StockEntity updateEntity(StockEntity oldEntity, StockEntity newEntity){
        oldEntity.setProduct(newEntity.getProduct());
        oldEntity.setCount(newEntity.getCount());

        stockEntityRepository.save(oldEntity);
        return oldEntity;
    }

    public Boolean hasEnoughStock(Product product, Integer amount){
        StockEntity stockEntity = stockEntityRepository.findByProductUuid(product.getUuid()).orElse(null);
        System.out.println("\nNOTE-2: " + product.getUuid() + " " + stockEntity + "\n");
        if(stockEntity != null && stockEntity.getCount() >= amount){
            return true;
        }

        return false;
    }

    public Boolean hasEnoughStock(UUID uuid, Integer amount){
        StockEntity stockEntity = stockEntityRepository.findByUuid(uuid).orElse(null);
        System.out.println("\nNOTE-3: " + uuid + " " + stockEntity + "\n");
        if(stockEntity != null && stockEntity.getCount() >= amount){
            return true;
        }

        return false;
    }

    public StockEntity reduceStockCount(Product product, Integer amount){
        StockEntity stockEntity = stockEntityRepository.findByProductUuid(product.getUuid()).orElse(null);

        if (stockEntity != null && stockEntity.getCount() >= amount) {
            stockEntity.setCount(stockEntity.getCount() - amount);

            stockEntityRepository.save(stockEntity);
            return stockEntity;
        }

        return null;
    }

    public StockEntity reduceStockCount(UUID uuid, Integer amount){
        StockEntity stockEntity = stockEntityRepository.findByUuid(uuid).orElse(null);

        if (stockEntity != null && stockEntity.getCount() >= amount) {
            stockEntity.setCount(stockEntity.getCount() - amount);

            stockEntityRepository.save(stockEntity);
            return stockEntity;
        }

        return null;
    }
}
