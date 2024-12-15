package com.entrepreneur.entrepreneur_backend.Service;

import com.entrepreneur.entrepreneur_backend.Models.Enterprise;
import com.entrepreneur.entrepreneur_backend.Models.Investment;

import java.util.List;

public interface InvestmentService {


    Investment createInvestment(Investment investor);

    Investment getInvestmentById(String investorId);

    Investment getInvestmentByEmail(String investorEmail);

    List< Investment> getAllInvestments();

    Investment updateInvestment(String investorId,  Investment investorDetails);

    void deleteInvestment(String investorId);
}
