package com.ylizma.billservice.controllers;

import com.ylizma.billservice.entities.Bill;
import com.ylizma.billservice.feign.CustomerRestClient;
import com.ylizma.billservice.feign.ProductRestClient;
import com.ylizma.billservice.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("bill")
public class BillController {

    private final BillRepository billRepository;
    private final CustomerRestClient customerRestClient;
    private final ProductRestClient productRestClient;

    public BillController(BillRepository billRepository, CustomerRestClient customerRestClient, ProductRestClient productRestClient) {
        this.billRepository = billRepository;
        this.customerRestClient = customerRestClient;
        this.productRestClient = productRestClient;
    }

    @GetMapping("/all")
    public List<Bill> getAllBills(){
        List<Bill> bills = billRepository.findAll();
        bills.forEach(bill -> {
            bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerId()));
            bill.getProductItems().forEach(productItem -> {
                productItem.setProduct(productRestClient.findProductById(productItem.getProductId()));
            });
        });
        return bills;
    }

    @GetMapping("/{id}")
    public Bill getBill(@PathVariable Long id){
        Optional<Bill> bill = billRepository.findById(id);
        bill.get().setCustomer(customerRestClient.findCustomerById(bill.get().getCustomerId()));
        bill.get().getProductItems().forEach(productItem -> {
            productItem.setProduct(productRestClient.findProductById(productItem.getProductId()));
        });
        return bill.get();
    }
}
