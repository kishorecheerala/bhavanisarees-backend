package com.bhavanisarees.bhavanisareesbackend.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customer_details")

public class CustomerDetails {

    @Id
    @Column(name="customer_ID")
     private String customerID;
    @Column(name="customer_name")
     private String customerName;
    @Column(name = "address")
     private String address;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "reference")
     private String reference;
//    @Column(name = "balance")
//    private BigDecimal balance;
//
//    @OneToMany(mappedBy = "customerDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<CustomerPurchase> customerPurchase;

}
