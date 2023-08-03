package com.bhavanisarees.bhavanisareesbackend.service;

import com.bhavanisarees.bhavanisareesbackend.model.CustomerDetails;
import com.bhavanisarees.bhavanisareesbackend.model.CustomerPurchase;
import com.bhavanisarees.bhavanisareesbackend.repository.CustomerDetailsRepository;
import com.bhavanisarees.bhavanisareesbackend.repository.CustomerPurcaseRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class CustomerPurchaseService {

        @Autowired
        private final CustomerDetailsRepository customerDetailsRepository;

        @Autowired
        private final CustomerPurcaseRepository customerPurchaseRepository;

        public CustomerPurchaseService(CustomerDetailsRepository customerDetailsRepository,
                                       CustomerPurcaseRepository customerPurchaseRepository) {
            this.customerDetailsRepository = customerDetailsRepository;
            this.customerPurchaseRepository = customerPurchaseRepository;
        }

        public void addPurchase(String customerID, LocalDate customerPurchaseDate, List<String> purchasedSarees,
                                BigDecimal customerSareePrice, String remarks, String modeOfPayment) {
            CustomerDetails customerDetails = customerDetailsRepository.findById(customerID)
                    .orElseThrow(() -> new EntityNotFoundException("Customer not found with ID: " + customerID));

            CustomerPurchase customerPurchase = new CustomerPurchase();
            customerPurchase.setCustomerDetails(customerDetails);
            customerPurchase.setCustomerPurchaseDate(customerPurchaseDate);
            customerPurchase.setPurchasedSarees(purchasedSarees);
            customerPurchase.setCustomerSareePrice(customerSareePrice);
            customerPurchase.setRemarks(remarks);
            customerPurchase.setModeOfPayment(modeOfPayment);

//            BigDecimal previousBalance = customerDetails.getBalance();
//            BigDecimal totalSareePrice = previousBalance.add(customerSareePrice);
//            customerDetails.setBalance(totalSareePrice);

            customerPurchaseRepository.save(customerPurchase);
            customerDetailsRepository.save(customerDetails);
    }
}
