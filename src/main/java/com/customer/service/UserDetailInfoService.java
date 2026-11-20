package com.customer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.customer.Entity.Customer;
import com.customer.Entity.UserDetailsInfo;
import com.customer.repository.CustomerRepository;

public class UserDetailInfoService implements UserDetailsService{

    @Autowired 
    CustomerRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        Customer customer = repository.findByEmail(username)
        .orElseThrow(() -> new UsernameNotFoundException("Customer not found"));

        return new UserDetailsInfo(customer.getEmail(), customer.getPassword(), customer.getRole());
    }
    
}
