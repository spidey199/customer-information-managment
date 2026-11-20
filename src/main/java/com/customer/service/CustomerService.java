package com.customer.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.customer.Entity.Customer;
import com.customer.annotation.TrackExecutionTime;
import com.customer.repository.CustomerRepository;

@Service 
public class CustomerService {

    CustomerRepository customerRepository;

     
    CustomerService(CustomerRepository repo){
        this.customerRepository = repo;
    }
    
      // Create customer
      @TrackExecutionTime
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Get customer by ID
    @TrackExecutionTime 
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    // Get all customers
    @TrackExecutionTime
    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @TrackExecutionTime
    public Iterable<Customer> getAllCustomers(int pageNum,int pageSize, String sortby) {
        Sort sort =  Sort.by(sortby);
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);

        return customerRepository.findAll(pageable);
    }

    // Update customer
    @TrackExecutionTime
    public Customer updateCustomer(Long id, Customer updatedCustomer) {

        Customer customer = getCustomer(id);

        customer.setName(updatedCustomer.getName());
        customer.setEmail(updatedCustomer.getEmail());
        customer.setPhone(updatedCustomer.getPhone());

        return customerRepository.save(customer);
    }

    // Delete customer
    @TrackExecutionTime
    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer not found");
        }

        customerRepository.deleteById(id);
    }
}
