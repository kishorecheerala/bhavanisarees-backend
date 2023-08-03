package com.bhavanisarees.bhavanisareesbackend.controller;

import com.bhavanisarees.bhavanisareesbackend.exception.UserNotFoundException;
import com.bhavanisarees.bhavanisareesbackend.model.CustomerDetails;
import com.bhavanisarees.bhavanisareesbackend.repository.CustomerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController

public class CustomerDetailsController {

    @Autowired
    private CustomerDetailsRepository customerDetailsRepository;

    @GetMapping("/customers")
    public List<CustomerDetails> getAllCustomerDetails(){
        return customerDetailsRepository.findAll();
    }
    @PostMapping("/newcustomer")
    CustomerDetails newCustomer(@RequestBody CustomerDetails customerDetails){
        return  customerDetailsRepository.save(customerDetails);
    }
    @GetMapping("/customer/{customerID}")
    CustomerDetails getUserByID(@PathVariable String customerID){
        return customerDetailsRepository.findById(customerID)
                .orElseThrow(()-> new UserNotFoundException(customerID));
    }

    @PutMapping("/customer/{customerID}")
    CustomerDetails updateUser(@RequestBody CustomerDetails customerDetails, @PathVariable String customerID){
        return customerDetailsRepository.findById(customerID)
                .map(customer ->{
                    customer.setCustomerID(customerDetails.getCustomerID());
                    customer.setCustomerName(customerDetails.getCustomerName());
                    customer.setAddress(customerDetails.getAddress());
                    customer.setPhoneNumber(customerDetails.getPhoneNumber());
                    customer.setReference(customerDetails.getReference());

                    return customerDetailsRepository.save(customer);
                })
                .orElseThrow(() -> new UserNotFoundException(customerID));
    }

    @DeleteMapping("/customer/{customerID}")
    String deleteUser(@PathVariable String customerID){
        if(!customerDetailsRepository.existsById(customerID)){
            throw new UserNotFoundException(customerID);
        }
        customerDetailsRepository.deleteById(customerID);
        return "User with ID "+customerID+" has been deleted Successfully";
    }
}
