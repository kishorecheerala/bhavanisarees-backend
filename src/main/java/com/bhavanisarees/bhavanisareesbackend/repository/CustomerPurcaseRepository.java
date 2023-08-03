package com.bhavanisarees.bhavanisareesbackend.repository;

import com.bhavanisarees.bhavanisareesbackend.model.CustomerPurchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerPurcaseRepository extends JpaRepository<CustomerPurchase,Long> {

}
