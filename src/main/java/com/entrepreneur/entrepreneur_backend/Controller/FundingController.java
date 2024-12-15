package com.entrepreneur.entrepreneur_backend.Controller;

import com.entrepreneur.entrepreneur_backend.Models.FundTransaction;
import com.entrepreneur.entrepreneur_backend.Models.FundingProject;
import com.entrepreneur.entrepreneur_backend.Service.FundingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funding")
public class FundingController {
    @Autowired
    private FundingService fundingService;

    @PostMapping("/projects")
    public FundingProject createProject(@RequestBody FundingProject fundingProject) {
        return fundingService.createProject(fundingProject);
    }

    @GetMapping("/projects")
    public List<FundingProject> getAllProjects() {
        return fundingService.getAllProjects();
    }

    @PostMapping("/projects/{projectId}/fund")
    public FundTransaction fundProject(@PathVariable String projectId, @RequestParam String investorId, @RequestParam double amount) {
        return fundingService.fundProject(projectId, investorId, amount);
    }

}
