package com.ylizma.billservice;

import com.ylizma.billservice.entities.Bill;
import com.ylizma.billservice.entities.ProductItem;
import com.ylizma.billservice.feign.CustomerRestClient;
import com.ylizma.billservice.feign.ProductRestClient;
import com.ylizma.billservice.models.Customer;
import com.ylizma.billservice.models.Product;
import com.ylizma.billservice.repositories.BillRepository;
import com.ylizma.billservice.repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.*;

@SpringBootApplication
@EnableFeignClients
public class BillServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(CustomerRestClient customerRestClient, ProductRestClient productRestClient, BillRepository billRepository, ProductItemRepository productItemRepository) {
        return args -> {
            Customer customer = customerRestClient.findCustomerById(1L);
            System.out.println("----------------------------");
            System.out.println(customer);
            Bill bill = billRepository.save(new Bill(null, new Date(), null, customer.getId(), customer));
            PagedModel<Product> products = productRestClient.getAllProducts();
            products.forEach(product -> {
                ProductItem item = new ProductItem(null, new Random().nextInt(100) + 1, product.getId(), product, 1200, bill);
                productItemRepository.save(item);
            });
            System.out.println("----------------------------");
//        ProductItem item = new ProductItem(null, 10, p1.getId(), p1, 1200, null);
//        ProductItem item2 = new ProductItem(null, 10, p2.getId(), p2, 900, null);
//        Collection<ProductItem> itemList = new ArrayList<>();
//        itemList.add(item);
//        itemList.add(item2);
//        Bill bill = new Bill(null, new Date(), itemList, customer.getId(), customer);
//        billRepository.save(bill);
        };
    }
}
