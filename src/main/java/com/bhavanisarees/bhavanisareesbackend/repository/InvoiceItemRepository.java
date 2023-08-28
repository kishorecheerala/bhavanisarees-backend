package com.bhavanisarees.bhavanisareesbackend.repository;

import com.bhavanisarees.bhavanisareesbackend.model.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {
    List<InvoiceItem> findByInvoiceId(Long invoiceId);
}