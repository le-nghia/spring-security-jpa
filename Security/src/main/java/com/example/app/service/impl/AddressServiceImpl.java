package com.example.app.service.impl;

import com.example.app.entity.customer.Address;
import com.example.app.reponsitory.IAddressRepository;
import com.example.app.service.IAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements IAddress {

    @Autowired
    IAddressRepository addressRepository;

    @Override
    public List<Address> getAll() {
        System.out.println("===> Get All Address");
        return addressRepository.findAll();
    }
}
