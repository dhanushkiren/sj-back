package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address,String> {
}
