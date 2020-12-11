package com.ylizma.billservice.entities;

import com.ylizma.billservice.models.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bill  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date date;

    @OneToMany(mappedBy = "bill")
    private Collection<ProductItem> productItems = new ArrayList<>();;

    private long customerId;

    @Transient
    private Customer customer;
}
