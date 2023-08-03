package com.bhavanisarees.bhavanisareesbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer_purchase")
public class CustomerPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_ID")
    @JsonBackReference
    private CustomerDetails customerDetails;

    @Column(name= "purchase_date")
    private LocalDate customerPurchaseDate;

    @Column(name = "purchased_sarees")
    @ElementCollection
    @CollectionTable(name = "purchased_sarees", joinColumns = @JoinColumn(name = "purchase_id"))
    private List<String> purchasedSarees;

    @Column(name = "customer_saree_price")
    private BigDecimal customerSareePrice;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "mode_of_payment")
    private String modeOfPayment;

    // Getters and setters
}
