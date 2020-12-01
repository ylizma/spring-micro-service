package com.ylizma.billservice;

import com.ylizma.billservice.feign.ProductRestClient;
import com.ylizma.billservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class BillServiceApplication  {


    public static void main(String[] args) {
        SpringApplication.run(BillServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ProductRestClient client){
        return args -> {
            System.out.println(client.findProductById(2L));
            System.out.println("hiii");
        };
    }

}
