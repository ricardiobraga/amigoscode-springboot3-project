package com.amigoscode.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.amigoscode.repositories.CustomerRepository;
import com.amigoscode.services.exceptions.DatabaseException;
import com.amigoscode.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

import com.amigoscode.entities.Customer;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;
    

    public List<Customer> findAll(){
        return repository.findAll();
    }

    public Customer insert(Customer obj){
        return repository.save(obj);
    }


    public void delete(Integer id){
        
        try {
            repository.deleteById(id);
        } catch(EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }


    public Customer update(Integer id, Customer obj){
        try{
            Customer entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Customer entity, Customer obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setAge(obj.getAge());
    }
}
