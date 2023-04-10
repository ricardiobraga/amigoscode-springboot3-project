package com.amigoscode.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amigoscode.entities.Customer;
import com.amigoscode.services.CustomerService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerResource {

    @Autowired
    private CustomerService service;


    @GetMapping
    public ResponseEntity<List<Customer>> findAll(){
        List<Customer> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

}
