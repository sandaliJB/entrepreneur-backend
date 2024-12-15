package com.entrepreneur.entrepreneur_backend.Service;
import com.entrepreneur.entrepreneur_backend.Models.Enterprise;
import java.util.List;

public interface EnterpriseService {

    Enterprise createEnterprise(Enterprise entrepreneur);

    Enterprise getEnterpriseById(String entrepreneurId);

    Enterprise getEnterpriseByEmail(String entrepreneurEmail);

    List<Enterprise> getAllEnterprises();

    Enterprise updateEnterprise(String entrepreneurId, Enterprise entrepreneurDetails);

    void deleteEnterprise(String entrepreneurId);
}

