package com.bhavanisarees.bhavanisareesbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Return {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    private String invoiceNumber;
    private int quantity;
    private double originalPrice;
    private LocalDate returnDate;
    private String lrNumber;
    private double totalAmount;
}
