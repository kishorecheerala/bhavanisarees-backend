package com.bhavanisarees.bhavanisareesbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    private String itemCode;
    private String itemDescription;
    private double originalPrice;
    private double gstPercentage;
    private double sellingPrice;
    private String rateDescription;
    private int quantity;
}
