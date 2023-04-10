package com.amigoscode.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigoscode.repositories.CustomerRepository;
import com.amigoscode.entities.Customer;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;
    

    public List<Customer> findAll(){
        return repository.findAll();
    }
}
