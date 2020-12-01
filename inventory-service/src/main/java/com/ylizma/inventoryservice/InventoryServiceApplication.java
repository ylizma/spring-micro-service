package com.ylizma.inventoryservice;

import com.ylizma.inventoryservice.entity.Product;
import com.ylizma.inventoryservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryServiceApplication implements CommandLineRunner {

    @Autowired
    ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(null, "tele", 2000.2));
        productRepository.save(new Product(null, "phone", 4000.0));
        productRepository.save(new Product(null, "mouse", 200.0));
        productRepository.findAll().forEach(product -> {
            System.out.println(product.getId());
        });
    }
}