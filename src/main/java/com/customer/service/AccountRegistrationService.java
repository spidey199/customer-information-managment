package com.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.customer.Entity.Customer;
import com.customer.repository.CustomerRepository;

@Service 
public class AccountRegistrationService {

    @Autowired 
    CustomerRepository repository;

    @Autowired 
    PasswordEncoder passwordEncoder;

    public String createAccount(Customer customer) throws Exception{
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));

        if(repository.findByEmail(customer.getEmail()).isPresent())
             throw new Exception("User Already exists");
        
        
        Customer cust = repository.save(customer);
        
            
        return cust.toString();
    }
    
}
