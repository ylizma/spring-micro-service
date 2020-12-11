package com.ylizma.billservice.services;

import com.ylizma.billservice.entities.Bill;
import com.ylizma.billservice.feign.CustomerRestClient;
import com.ylizma.billservice.feign.ProductRestClient;
import com.ylizma.billservice.models.Customer;
import com.ylizma.billservice.models.Product;
import com.ylizma.billservice.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillService {

    @Autowired
    private  CustomerRestClient customerRestClient;
    @Autowired
    private  BillRepository billRepository;
    @Autowired
    private  ProductRestClient productRestClient;


//    public List<Bill> getAllBills() {
//        List<Bill> bills = billRepository.findAll();
//        bills = bills.stream().map(bill -> {
//            Customer c = customerRestClient.findCustomerById(bill.getCustomerId());
//            bill.setProductItems( bill.getProductItems().stream().map(productItem -> {
//               Product p = productRestClient.findProductById(productItem.getProductId());
//               productItem.setProduct(p);
//            }).collect(Collectors.toList()));
//        }).collect(Collectors.toList());
//        return bills;
//    }

}
