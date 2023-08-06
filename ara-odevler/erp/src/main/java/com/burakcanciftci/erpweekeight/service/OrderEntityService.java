package com.burakcanciftci.erpweekeight.service;

import com.burakcanciftci.erpweekeight.database.entity.CustomerEntity;
import com.burakcanciftci.erpweekeight.database.entity.OrderEntity;
import com.burakcanciftci.erpweekeight.model.OrderedProduct;
import com.burakcanciftci.erpweekeight.database.repository.OrderEntityRepository;
import com.burakcanciftci.erpweekeight.model.OrderStateEnum;
import com.burakcanciftci.erpweekeight.util.dbutil.BaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderEntityService extends BaseEntityService<OrderEntity> {

    @Autowired
    OrderEntityRepository orderEntityRepository;

    @Autowired
    BillEntityService billEntityService;

    @Autowired
    StockEntityService stockEntityService;

    public OrderEntity createOrder(CustomerEntity customer, List<OrderedProduct> orderedProductList) {
        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setCustomer(customer);
        System.err.println(orderedProductList);
        orderEntity.setOrderedProductList(getOrderedProductListAfterStockProcess(orderedProductList));

        // stock is not available, cancel order
        if(orderEntity.getOrderedProductList().equals(null)){
            return null;
        }

        orderEntity.setOrderState(OrderStateEnum.WAITING_TO_APPROVE);

        orderEntityRepository.save(orderEntity);
        return orderEntity;
    }

    @Override
    protected OrderEntity updateEntity(OrderEntity oldEntity, OrderEntity newEntity) {
        oldEntity.setCustomer(newEntity.getCustomer());
        oldEntity.setOrderedProductList(getOrderedProductListAfterStockProcess(newEntity.getOrderedProductList()));

        // stock is not available, cancel order
        if(oldEntity.getOrderedProductList().size() == 0){
            return null;
        }

        oldEntity.setOrderState(newEntity.getOrderState());

        orderEntityRepository.save(oldEntity);
        return oldEntity;
    }

    public OrderEntity updateOrderState(UUID uuid, OrderStateEnum orderState, String companyName) {
        OrderEntity order = getByUUID(uuid);

        if (order != null) {
            if (orderState.equals(OrderStateEnum.APPROVED)) {
                billEntityService.createBill(order, companyName);
            }

            order.setOrderState(orderState);

            orderEntityRepository.save(order);
            return order;
        }

        return null;
    }

    private List<OrderedProduct> getOrderedProductListAfterStockProcess(List<OrderedProduct> orderedProductList){
        System.out.println("\nNOTE: " + orderedProductList + "\n");
        for (OrderedProduct orderedProduct : orderedProductList) {
            Boolean hasEnoughStock = stockEntityService.hasEnoughStock(
                    orderedProduct.getProduct(), orderedProduct.getCount());

            if(!hasEnoughStock){
                return new ArrayList<>();
            }

            stockEntityService.reduceStockCount(orderedProduct.getProduct(), orderedProduct.getCount());

            // Setting price of that time according to KDV appliance
            if(orderedProduct.getProduct().getIsKdvApplied()){
                orderedProduct.setPriceWithKdv(orderedProduct.getProduct().getPrice());
            }else{
                orderedProduct.setPriceWithoutKdv(orderedProduct.getProduct().getPrice());
            }
        }

        return orderedProductList;
    }
}
