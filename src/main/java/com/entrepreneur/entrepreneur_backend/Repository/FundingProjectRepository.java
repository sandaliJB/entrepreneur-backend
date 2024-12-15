package com.entrepreneur.entrepreneur_backend.Repository;

import com.entrepreneur.entrepreneur_backend.Models.FundingProject;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FundingProjectRepository extends MongoRepository<FundingProject, String> {
}
