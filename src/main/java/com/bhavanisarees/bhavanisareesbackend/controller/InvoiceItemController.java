package com.bhavanisarees.bhavanisareesbackend.controller;

import com.bhavanisarees.bhavanisareesbackend.model.InvoiceItem;
import com.bhavanisarees.bhavanisareesbackend.repository.InvoiceItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/invoiceItems")
public class InvoiceItemController {

    @Autowired
    private InvoiceItemRepository invoiceItemRepository;

    @GetMapping
    public List<InvoiceItem> getAllInvoiceItems() {
        return invoiceItemRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceItem> getInvoiceItemById(@PathVariable Long id) {
        Optional<InvoiceItem> invoiceItemOptional = invoiceItemRepository.findById(id);
        if (invoiceItemOptional.isPresent()) {
            return ResponseEntity.ok(invoiceItemOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<InvoiceItem> createInvoiceItem(@RequestBody InvoiceItem invoiceItem) {
        InvoiceItem createdInvoiceItem = invoiceItemRepository.save(invoiceItem);
        return ResponseEntity.created(URI.create("/api/invoiceItems/" + createdInvoiceItem.getId())).body(createdInvoiceItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvoiceItem> updateInvoiceItem(@PathVariable Long id, @RequestBody InvoiceItem updatedInvoiceItem) {
        Optional<InvoiceItem> invoiceItemOptional = invoiceItemRepository.findById(id);
        if (invoiceItemOptional.isPresent()) {
            updatedInvoiceItem.setId(id); // Ensure the ID matches
            invoiceItemRepository.save(updatedInvoiceItem);
            return ResponseEntity.ok(updatedInvoiceItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoiceItem(@PathVariable Long id) {
        Optional<InvoiceItem> invoiceItemOptional = invoiceItemRepository.findById(id);
        if (invoiceItemOptional.isPresent()) {
            invoiceItemRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/invoice/{invoiceId}")
    public List<InvoiceItem> getInvoiceItemsByInvoice(@PathVariable Long invoiceId) {
        return invoiceItemRepository.findByInvoiceId(invoiceId);
    }
}
