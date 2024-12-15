package com.entrepreneur.entrepreneur_backend.Repository;

import com.entrepreneur.entrepreneur_backend.Models.Enterprise;
import com.entrepreneur.entrepreneur_backend.Models.Investment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvestmentRepository extends MongoRepository<Investment, String> {
    Investment findByInvestorEmail(String investorEmail);
}
