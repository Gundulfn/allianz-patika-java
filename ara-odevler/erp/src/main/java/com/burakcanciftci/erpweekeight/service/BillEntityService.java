package com.burakcanciftci.erpweekeight.service;

import com.burakcanciftci.erpweekeight.database.entity.BillEntity;
import com.burakcanciftci.erpweekeight.database.entity.OrderEntity;
import com.burakcanciftci.erpweekeight.model.OrderedProduct;
import com.burakcanciftci.erpweekeight.database.repository.BillEntityRepository;
import com.burakcanciftci.erpweekeight.util.dbutil.BaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BillEntityService extends BaseEntityService<BillEntity> {

    @Autowired
    BillEntityRepository billEntityRepository;

    @Autowired
    KdvEntityService kdvEntityService;

    public BillEntity createBill(OrderEntity order, String companyName) {
        BillEntity billEntity = new BillEntity();
        billEntity.setOrder(order);
        billEntity.setCompanyName(companyName);

        billEntity = calculatePrices(billEntity);

        billEntityRepository.save(billEntity);
        return billEntity;
    }

    @Override
    protected BillEntity updateEntity(BillEntity oldEntity, BillEntity newEntity) {
        oldEntity.setOrder(newEntity.getOrder());
        oldEntity.setCompanyName(newEntity.getCompanyName());

        oldEntity = calculatePrices(oldEntity);

        billEntityRepository.save(oldEntity);
        return oldEntity;
    }

    private BillEntity calculatePrices(BillEntity billEntity) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        BigDecimal totalKdv = BigDecimal.ZERO;

        BigDecimal kdvRate = BigDecimal.ZERO;
        for (OrderedProduct orderedProduct : billEntity.getOrder().getOrderedProductList()) {
            kdvRate = kdvEntityService.getKdvRate(orderedProduct.getProduct().getCategory());
            orderedProduct.setKdv("%" + kdvRate);

            if (orderedProduct.getProduct().getIsKdvApplied()) {
                orderedProduct.setPriceWithoutKdv(
                        kdvEntityService.calculatePriceWithoutKdv(orderedProduct.getProduct().getPrice(), kdvRate));
            }else{
                orderedProduct.setPriceWithKdv(
                        kdvEntityService.calculatePriceWithKdv(orderedProduct.getProduct().getPrice(), kdvRate));
            }

            totalPrice = totalPrice.add(orderedProduct.getPriceWithKdv());
            totalKdv = totalKdv.add(orderedProduct.getPriceWithKdv().subtract(orderedProduct.getPriceWithoutKdv()));
        }

        billEntity.setTotalPrice(totalPrice);
        billEntity.setTotalKdv(totalKdv);
        return billEntity;
    }
}
