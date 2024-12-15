package com.entrepreneur.entrepreneur_backend.Controller;
import com.entrepreneur.entrepreneur_backend.Models.Enterprise;
import com.entrepreneur.entrepreneur_backend.Service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrepreneurs")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    // Create a new Entrepreneur
    @PostMapping
    public ResponseEntity<Enterprise> createEntrepreneur(@RequestBody Enterprise entrepreneur) {
        Enterprise createdEntrepreneur = enterpriseService.createEnterprise(entrepreneur);
        return ResponseEntity.ok(createdEntrepreneur);
    }

    // Get Entrepreneur by ID
    @GetMapping("/{id}")
    public ResponseEntity<Enterprise> getEntrepreneurById(@PathVariable("id") String entrepreneurId) {
        Enterprise entrepreneur = enterpriseService.getEnterpriseById(entrepreneurId);
        return ResponseEntity.ok(entrepreneur);
    }

    // Get Entrepreneur by Email
    @GetMapping("/email/{email}")
    public ResponseEntity<Enterprise> getEntrepreneurByEmail(@PathVariable("email") String entrepreneurEmail) {
        Enterprise entrepreneur = enterpriseService.getEnterpriseByEmail(entrepreneurEmail);
        return ResponseEntity.ok(entrepreneur);
    }

    // Get All Entrepreneurs
    @GetMapping
    public ResponseEntity<List<Enterprise>> getAllEntrepreneurs() {
        List<Enterprise> entrepreneurs = enterpriseService.getAllEnterprises();
        return ResponseEntity.ok(entrepreneurs);
    }

    // Update Entrepreneur
    @PutMapping("/{id}")
    public ResponseEntity<Enterprise> updateEntrepreneur(
            @PathVariable("id") String entrepreneurId,
            @RequestBody Enterprise entrepreneurDetails) {
        Enterprise updatedEntrepreneur = enterpriseService.updateEnterprise(entrepreneurId, entrepreneurDetails);
        return ResponseEntity.ok(updatedEntrepreneur);
    }

    // Delete Entrepreneur
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntrepreneur(@PathVariable("id") String entrepreneurId) {
        enterpriseService.deleteEnterprise(entrepreneurId);
        return ResponseEntity.ok("Entrepreneur with ID " + entrepreneurId + " has been deleted successfully.");
    }
}
