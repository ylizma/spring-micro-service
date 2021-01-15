package com.ylizma.customerservice;

import com.ylizma.customerservice.entities.Customer;
import com.ylizma.customerservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }


    @Bean
    public CommandLineRunner run(CustomerRepository customerRepository, RepositoryRestConfiguration repositoryRestConfiguration) {
        repositoryRestConfiguration.exposeIdsFor(Customer.class);
        return args -> {
            Customer c1 = new Customer(null, "youssef", "youssef@gmail");
            Customer c2 = new Customer(null, "aziz", "aziz@gmail");
            Customer c3 = new Customer(null, "ali", "ali@gmail");
            customerRepository.save(c1);
            customerRepository.save(c2);
            customerRepository.save(c3);
        };
    }

}
