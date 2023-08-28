package com.bhavanisarees.bhavanisareesbackend.controller;

import com.bhavanisarees.bhavanisareesbackend.model.Return;
import com.bhavanisarees.bhavanisareesbackend.repository.ReturnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/returns")
public class ReturnController {

    @Autowired
    private ReturnRepository returnRepository;

    @GetMapping
    public List<Return> getAllReturns() {
        return returnRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Return> getReturnById(@PathVariable Long id) {
        Optional<Return> returnOptional = returnRepository.findById(id);
        if (returnOptional.isPresent()) {
            return ResponseEntity.ok(returnOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Return> createReturn(@RequestBody Return aReturn) {
        Return createdReturn = returnRepository.save(aReturn);
        return ResponseEntity.created(URI.create("/api/returns/" + createdReturn.getId())).body(createdReturn);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Return> updateReturns(@PathVariable Long id, @RequestBody Return updatedReturn) {
        Optional<Return> returnOptional = returnRepository.findById(id);
        if (returnOptional.isPresent()) {
            updatedReturn.setId(id); // Ensure the ID matches
            returnRepository.save(updatedReturn);
            return ResponseEntity.ok(updatedReturn);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReturn(@PathVariable Long id) {
        Optional<Return> returnOptional = returnRepository.findById(id);
        if (returnOptional.isPresent()) {
            returnRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/invoice/{invoiceId}")
    public List<Return> getReturnsByInvoice(@PathVariable Long invoiceId) {
        return returnRepository.findByInvoiceId(invoiceId);
    }
}
