package com.customer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customer.Entity.Customer;
import com.customer.service.AccountRegistrationService;

@RestController 
public class AccountRegistrationController {

    
    private final AccountRegistrationService registrationService;

    public AccountRegistrationController(AccountRegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping ("/api/auth/register")
    public String createAccount(@RequestBody Customer customer) throws Exception{

        String result = registrationService.createAccount(customer);

        return result;
    }


}
