package com.entrepreneur.entrepreneur_backend.Service;

import com.entrepreneur.entrepreneur_backend.Models.FundTransaction;
import com.entrepreneur.entrepreneur_backend.Models.FundingProject;

import java.util.List;

public interface FundingService {
    FundingProject createProject(FundingProject fundingProject);
    List<FundingProject> getAllProjects();
    FundTransaction fundProject(String projectId, String investorId, double amount);
}
