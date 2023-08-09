package com.allianz.example.database.repository;

import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.util.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemEntityRepository extends IBaseRepository<OrderItemEntity, Long> {

}
