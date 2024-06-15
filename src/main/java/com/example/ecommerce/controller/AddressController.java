package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Address;
import com.example.ecommerce.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkout")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/saveAddress")
    public Address saveAddress(@RequestBody Address address) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        address.setUsername(username);
        return addressService.saveAddress(address);
    }
}
