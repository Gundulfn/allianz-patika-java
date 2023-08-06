package com.burakcanciftci.erpweekeight.database.entity;

import com.burakcanciftci.erpweekeight.model.OrderStateEnum;
import com.burakcanciftci.erpweekeight.model.OrderedProduct;
import com.burakcanciftci.erpweekeight.util.dbutil.BaseEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.List;

@Entity
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "order_uuid"
        )
)
@Data
public class OrderEntity extends BaseEntity{
        @ManyToOne
        @JoinColumn(name = "customer_id")
        private CustomerEntity customer;

        @ElementCollection
        @CollectionTable(name = "ordered_product_list", joinColumns = @JoinColumn(name = "ordered_product_id"))
        private List<OrderedProduct> orderedProductList;

        @Column(name = "order_state")
        private OrderStateEnum orderState;

        public List<OrderedProduct> getOrderedProductList() {
                return orderedProductList;
        }

        public void setOrderedProductList(List<OrderedProduct> orderedProductList) {
                this.orderedProductList = orderedProductList;
        }
}
