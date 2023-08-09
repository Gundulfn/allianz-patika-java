package com.allianz.example.database.repository;

import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.util.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderEntityRepository extends IBaseRepository<OrderEntity, Long> {

}
