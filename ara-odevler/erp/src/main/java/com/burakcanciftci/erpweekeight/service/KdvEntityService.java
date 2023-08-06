package com.burakcanciftci.erpweekeight.service;

import com.burakcanciftci.erpweekeight.database.entity.KdvEntity;
import com.burakcanciftci.erpweekeight.database.repository.KdvEntityRepository;
import com.burakcanciftci.erpweekeight.model.ProductCategoryEnum;
import com.burakcanciftci.erpweekeight.util.dbutil.BaseEntityService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KdvEntityService extends BaseEntityService<KdvEntity> {

    @Autowired
    KdvEntityRepository kdvEntityRepository;

    private static Map<ProductCategoryEnum, BigDecimal> kdvRateMap = new HashMap<>();

    private static final BigDecimal ONE_HUNDRED = BigDecimal.valueOf(100);

    @PostConstruct
    public void init() {
        List<KdvEntity> kdvEntityList = kdvEntityRepository.findAll();

        for(KdvEntity kdvEntity : kdvEntityList){
            kdvRateMap.put(kdvEntity.getCategory(), kdvEntity.getKdvRate());
        }
    }

    public KdvEntity createKdv(ProductCategoryEnum category, BigDecimal kdvRate){
        KdvEntity kdvEntity = new KdvEntity();
        kdvEntity.setCategory(category);
        kdvEntity.setKdvRate(kdvRate);

        kdvEntityRepository.save(kdvEntity);
        kdvRateMap.put(category, kdvRate);

        return kdvEntity;
    }

    @Override
    protected KdvEntity updateEntity(KdvEntity oldEntity, KdvEntity newEntity){
        oldEntity.setKdvRate(newEntity.getKdvRate());

        kdvEntityRepository.save(oldEntity);
        return oldEntity;
    }

    public BigDecimal getKdvRate(ProductCategoryEnum category){
        if(kdvRateMap.containsKey(category)){
            return kdvRateMap.get(category);
        }else{
            // New category added, get kdv rate from database
            KdvEntity kdvEntity = kdvEntityRepository.findByCategory(category);

            if(kdvEntity != null){
                kdvRateMap.put(category, kdvEntity.getKdvRate());
                return kdvEntity.getKdvRate();
            }
        }

        // If product category is not defined, return standard kdv rate
        return kdvEntityRepository.findByCategory(ProductCategoryEnum.OTHER).getKdvRate();
    }

    public BigDecimal calculatePriceWithoutKdv(BigDecimal price, BigDecimal kdvRate){
        kdvRate = kdvRate.add(ONE_HUNDRED);
        return (price.multiply(ONE_HUNDRED))
                .divide(kdvRate, 2);
    }

    public BigDecimal calculatePriceWithKdv(BigDecimal price, BigDecimal kdvRate){
        kdvRate = kdvRate.add(ONE_HUNDRED);
        return price.multiply(kdvRate).divide(ONE_HUNDRED);
    }
}
