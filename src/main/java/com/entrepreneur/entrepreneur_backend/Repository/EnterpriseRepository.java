package com.entrepreneur.entrepreneur_backend.Repository;
import com.entrepreneur.entrepreneur_backend.Models.Enterprise;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EnterpriseRepository extends MongoRepository<Enterprise, String> {
    Enterprise findByEntrepreneurEmail(String entrepreneurEmail);
}
