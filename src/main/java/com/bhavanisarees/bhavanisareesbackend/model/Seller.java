package com.bhavanisarees.bhavanisareesbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sellerName;
    private String sellerDetails;
    private String agentName;
    private String accountDetails;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    private List<Invoice> invoices = new ArrayList<>();
}
