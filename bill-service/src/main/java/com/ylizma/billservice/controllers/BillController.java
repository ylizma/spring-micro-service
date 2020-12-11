package com.ylizma.billservice.controllers;

import com.ylizma.billservice.feign.CustomerRestClient;
import com.ylizma.billservice.feign.ProductRestClient;
import com.ylizma.billservice.repositories.BillRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/bill-rest")
public class BillController {

}
