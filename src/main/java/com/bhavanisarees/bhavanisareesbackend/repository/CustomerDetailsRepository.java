package com.bhavanisarees.bhavanisareesbackend.repository;

import com.bhavanisarees.bhavanisareesbackend.model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, String> {

    //All CRUD database methods
}
