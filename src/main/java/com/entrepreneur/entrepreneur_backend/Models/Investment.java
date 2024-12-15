package com.entrepreneur.entrepreneur_backend.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class Investment {
    @Id
    private String investorId;
    private String investorName;
    private String investorJob;
    private String investorEmail;
    private String investorInterest;
    private String budgetLimit;
    private String address;
    private String telNumber;
    private String investorImage;

    public String getInvestorId() {
        return investorId;
    }

    public void setInvestorId(String investorId) {
        this.investorId = investorId;
    }

    public String getInvestorName() {
        return investorName;
    }

    public void setInvestorName(String investorName) {
        this.investorName = investorName;
    }

    public String getInvestorJob() {
        return investorJob;
    }

    public void setInvestorJob(String investorJob) {
        this.investorJob = investorJob;
    }

    public String getInvestorEmail() {
        return investorEmail;
    }

    public void setInvestorEmail(String investorEmail) {
        this.investorEmail = investorEmail;
    }

    public String getInvestorInterest() {
        return investorInterest;
    }

    public void setInvestorInterest(String investorInterest) {
        this.investorInterest = investorInterest;
    }

    public String getBudgetLimit() {
        return budgetLimit;
    }

    public void setBudgetLimit(String budgetLimit) {
        this.budgetLimit = budgetLimit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getInvestorImage() {
        return investorImage;
    }

    public void setInvestorImage(String investorImage) {
        this.investorImage = investorImage;
    }
}
