package com.bhavanisarees.bhavanisareesbackend.repository;

import com.bhavanisarees.bhavanisareesbackend.model.Return;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReturnRepository extends JpaRepository<Return, Long> {
    List<Return> findByInvoiceId(Long invoiceId);
}