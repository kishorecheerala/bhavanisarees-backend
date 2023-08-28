package com.bhavanisarees.bhavanisareesbackend.controller;

import com.bhavanisarees.bhavanisareesbackend.model.Repayment;
import com.bhavanisarees.bhavanisareesbackend.repository.RepaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/repayments")
public class RepaymentController {

    @Autowired
    private RepaymentRepository repaymentRepository;

    @GetMapping
    public List<Repayment> getAllRepayments() {
        return repaymentRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Repayment> getRepaymentById(@PathVariable Long id) {
        Optional<Repayment> repaymentOptional = repaymentRepository.findById(id);
        if (repaymentOptional.isPresent()) {
            return ResponseEntity.ok(repaymentOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Repayment> createRepayment(@RequestBody Repayment repayment) {
        Repayment createdRepayment = repaymentRepository.save(repayment);
        return ResponseEntity.created(URI.create("/api/repayments/" + createdRepayment.getId())).body(createdRepayment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Repayment> updateRepayment(@PathVariable Long id, @RequestBody Repayment updatedRepayment) {
        Optional<Repayment> repaymentOptional = repaymentRepository.findById(id);
        if (repaymentOptional.isPresent()) {
            updatedRepayment.setId(id); // Ensure the ID matches
            repaymentRepository.save(updatedRepayment);
            return ResponseEntity.ok(updatedRepayment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRepayment(@PathVariable Long id) {
        Optional<Repayment> repaymentOptional = repaymentRepository.findById(id);
        if (repaymentOptional.isPresent()) {
            repaymentRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/invoice/{invoiceId}")
    public List<Repayment> getRepaymentsByInvoice(@PathVariable Long invoiceId) {
        return repaymentRepository.findByInvoiceId(invoiceId);
    }
}
