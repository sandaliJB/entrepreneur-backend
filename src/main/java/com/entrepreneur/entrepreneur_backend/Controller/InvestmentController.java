package com.entrepreneur.entrepreneur_backend.Controller;


import com.entrepreneur.entrepreneur_backend.Models.Enterprise;
import com.entrepreneur.entrepreneur_backend.Models.Investment;
import com.entrepreneur.entrepreneur_backend.Service.EnterpriseService;
import com.entrepreneur.entrepreneur_backend.Service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/investors")

public class InvestmentController {

    @Autowired
    private InvestmentService investmentService;

    // Create a new Investor
    @PostMapping
    public ResponseEntity<Investment> createInvestor(@RequestBody Investment investor) {
        Investment createdInvestor = investmentService.createInvestment(investor);
        return ResponseEntity.ok(createdInvestor);
    }

    // Get Investor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Investment> getInvestorById(@PathVariable("id") String investorId) {
        Investment investor = investmentService.getInvestmentById(investorId);
        return ResponseEntity.ok(investor);
    }

    // Get Investor by Email
    @GetMapping("/email/{email}")
    public ResponseEntity<Investment> getInvestorByEmail(@PathVariable("email") String investorEmail) {
        Investment investor = investmentService.getInvestmentByEmail(investorEmail);
        return ResponseEntity.ok(investor);
    }

    // Get All Investors
    @GetMapping
    public ResponseEntity<List<Investment>> getAllInvestors() {
        List<Investment> investors = investmentService.getAllInvestments();
        return ResponseEntity.ok(investors);
    }

    // Update Investor
    @PutMapping("/{id}")
    public ResponseEntity<Investment> updateInvestor(
            @PathVariable("id") String investorId,
            @RequestBody Investment investorDetails) {
        Investment updatedInvestor = investmentService.updateInvestment(investorId, investorDetails);
        return ResponseEntity.ok(updatedInvestor);
    }

    // Delete Investor
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInvestor(@PathVariable("id") String investorId) {
        investmentService.deleteInvestment(investorId);
        return ResponseEntity.ok("Investor with ID " + investorId + " has been deleted successfully.");
    }

}
