package com.bhavanisarees.bhavanisareesbackend.controller;


import com.bhavanisarees.bhavanisareesbackend.model.CustomerPurchase;
import com.bhavanisarees.bhavanisareesbackend.repository.CustomerPurcaseRepository;
import com.bhavanisarees.bhavanisareesbackend.service.CustomerPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class CustomerPurchaseController {

    @Autowired
    private final CustomerPurchaseService customerPurchaseService;

    @Autowired
    private CustomerPurcaseRepository customerPurcaseRepository;

    public CustomerPurchaseController(CustomerPurchaseService customerPurchaseService) {
        this.customerPurchaseService = customerPurchaseService;
    }

    @GetMapping("/customerpurchase")
    public List<CustomerPurchase> getAllCustomerPurchase(){
        return customerPurcaseRepository.findAll();
    }

    @PostMapping("customer/{customerID}/customerpurchase")
    public ResponseEntity<String> addPurchase(
            @PathVariable String customerID,
            @RequestBody CustomerPurchase customerPurchase) {
        customerPurchaseService.addPurchase(customerID, customerPurchase.getCustomerPurchaseDate(),
                customerPurchase.getPurchasedSarees(), customerPurchase.getCustomerSareePrice(),
                customerPurchase.getRemarks(), customerPurchase.getModeOfPayment());
        return ResponseEntity.ok("Purchase added successfully");
    }
}
