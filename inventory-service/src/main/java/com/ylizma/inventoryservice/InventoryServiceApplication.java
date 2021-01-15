package com.ylizma.inventoryservice;

import com.ylizma.inventoryservice.entity.Product;
import com.ylizma.inventoryservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class InventoryServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ProductRepository productRepository, RepositoryRestConfiguration repositoryRestConfiguration) {
        repositoryRestConfiguration.exposeIdsFor(Product.class);
        return args -> {
            productRepository.save(new Product(null, "tele", 2000.2));
            productRepository.save(new Product(null, "phone", 4000.0));
            productRepository.save(new Product(null, "mouse", 200.0));
            productRepository.findAll().forEach(product -> {
                System.out.println(product.getId());
            });
        };
    }
}