package com.customer.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Table ("customers")
@Data
public class Customer {

    @Id 
    private Long id;

    private String name;
    private String email;
    private String phone;

    // Getters and Setters


    private String password;
    private String role;
}