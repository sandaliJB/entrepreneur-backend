package com.entrepreneur.entrepreneur_backend.Repository;

import com.entrepreneur.entrepreneur_backend.Models.FundTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FundTransactionRepository  extends MongoRepository<FundTransaction, String> {
    List<FundTransaction> findByProjectId(String projectId);
}
