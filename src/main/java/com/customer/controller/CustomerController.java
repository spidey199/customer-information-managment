package com.customer.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customer.Entity.Customer;
import com.customer.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping ("/api/customers")
@RequiredArgsConstructor 
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping 
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }

    // @GetMapping
    // public Iterable<Customer> getAllCustomers() {
    //     return customerService.getAllCustomers();
    // }

    @GetMapping("/admin")
    public Iterable<Customer> getAllCustomers(@RequestParam int pageNum, @RequestParam String sortBy) {
        return customerService.getAllCustomers(pageNum, 5, sortBy);
    }

    @PutMapping ("/{id}")
    public Customer updateCustomer(
            @PathVariable Long id,
            @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping ("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}
