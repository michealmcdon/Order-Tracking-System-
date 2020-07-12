package com.sales.services;

import java.util.*;

import com.sales.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Customer;

@Service
public class CustomerServices {
    @Autowired
    CustomerRepository cr;

    public ArrayList<Customer> findAll() {
        return (ArrayList<Customer>) cr.findAll();
    }

    public void save(Customer c) {
        cr.save(c);
    }

    public Customer findOne(Long cId) {
        return cr.findOne(cId);
    }
}
