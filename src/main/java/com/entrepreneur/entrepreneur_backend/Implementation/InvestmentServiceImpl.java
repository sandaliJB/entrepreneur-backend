package com.entrepreneur.entrepreneur_backend.Implementation;

import com.entrepreneur.entrepreneur_backend.Models.Enterprise;
import com.entrepreneur.entrepreneur_backend.Models.Investment;
import com.entrepreneur.entrepreneur_backend.Repository.EnterpriseRepository;
import com.entrepreneur.entrepreneur_backend.Repository.InvestmentRepository;
import com.entrepreneur.entrepreneur_backend.Service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestmentServiceImpl implements InvestmentService {

@Autowired
private InvestmentRepository investmentRepository;
@Override
    public Investment createInvestment(Investment investor) {
    return investmentRepository.save(investor);
}
@Override
public Investment getInvestmentById(String investorId) {
    return investmentRepository.findById(investorId)
            .orElseThrow(() -> new RuntimeException("User not found with ID: " + investorId));
}
@Override
public Investment getInvestmentByEmail(String investorEmail) {
    return investmentRepository.findByInvestorEmail(investorEmail);
}
@Override
public List<Investment> getAllInvestments() {
    return investmentRepository.findAll();
}
@Override
public Investment updateInvestment(String investorId, Investment investorDetails) {
    return investmentRepository.findById(investorId).map(existingInvestor -> {
        existingInvestor.setInvestorName(investorDetails.getInvestorName());
        existingInvestor.setInvestorJob(investorDetails.getInvestorJob());
        existingInvestor.setInvestorEmail(investorDetails.getInvestorEmail());
        existingInvestor.setAddress(investorDetails.getAddress());
        existingInvestor.setBudgetLimit(investorDetails.getBudgetLimit());
        existingInvestor.setInvestorInterest(investorDetails.getInvestorInterest());
        existingInvestor.setTelNumber(investorDetails.getTelNumber());
        existingInvestor.setInvestorImage(investorDetails.getInvestorImage());
        return investmentRepository.save(existingInvestor);
    }).orElseThrow(() -> new RuntimeException("Investor not found with ID: " + investorId));
}
@Override
public void deleteInvestment(String investorId) {
    investmentRepository.deleteById(investorId);}

}