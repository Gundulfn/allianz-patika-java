package com.burakcanciftci.erpweekeight.service;

import com.burakcanciftci.erpweekeight.database.entity.CustomerEntity;
import com.burakcanciftci.erpweekeight.database.repository.CustomerEntityRepository;
import com.burakcanciftci.erpweekeight.util.dbutil.BaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerEntityService extends BaseEntityService<CustomerEntity> {

    @Autowired
    CustomerEntityRepository customerEntityRepository;

    public CustomerEntity createCustomer(String name, String surname, String email, String phoneNo, String address){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(name);
        customerEntity.setSurname(surname);
        customerEntity.setEmail(email);
        customerEntity.setPhoneNo(phoneNo);
        customerEntity.setAddress(address);

        customerEntityRepository.save(customerEntity);
        return customerEntity;
    }

    @Override
    protected CustomerEntity updateEntity(CustomerEntity oldEntity, CustomerEntity newEntity){
        oldEntity.setName(newEntity.getName());
        oldEntity.setSurname(newEntity.getSurname());
        oldEntity.setEmail(newEntity.getEmail());
        oldEntity.setPhoneNo(newEntity.getPhoneNo());
        oldEntity.setAddress(newEntity.getAddress());

        customerEntityRepository.save(oldEntity);
        return oldEntity;
    }
}
