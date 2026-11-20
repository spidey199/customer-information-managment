package com.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.customer.Entity.Customer;
import com.customer.repository.CustomerRepository;

@SpringBootApplication
@EnableAspectJAutoProxy
public class CimApplication implements CommandLineRunner {


	private CustomerRepository repository;
	private PasswordEncoder passwordEncoder;

	public CimApplication(CustomerRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

	public static void main(String[] args) {
		SpringApplication.run(CimApplication.class, args);
	}


	@Override
	public void run(String... args) {
		String email = "bholenath08@gmail.com";

		if (repository.findByEmail(email).isPresent()) {
			return;
		}

		Customer customer = new Customer();
		customer.setName("BHOLENATH");
		customer.setEmail(email);
		customer.setPhone("+91-9264996900");
		customer.setPassword(passwordEncoder.encode("bholenath@08"));
		customer.setRole("ADMIN");

		repository.save(customer);
	}

}
