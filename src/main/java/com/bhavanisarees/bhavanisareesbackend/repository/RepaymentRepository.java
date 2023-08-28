package com.bhavanisarees.bhavanisareesbackend.repository;

import com.bhavanisarees.bhavanisareesbackend.model.Repayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepaymentRepository extends JpaRepository<Repayment, Long> {
    List<Repayment> findByInvoiceId(Long invoiceId);
}
