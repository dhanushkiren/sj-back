package com.example.ecommerce.service;

import com.example.ecommerce.entity.Address;
import com.example.ecommerce.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address saveAddress(Address address) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return addressRepository.save(address);
    }
}
