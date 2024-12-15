package com.entrepreneur.entrepreneur_backend.Implementation;
import com.entrepreneur.entrepreneur_backend.Models.Enterprise;
import com.entrepreneur.entrepreneur_backend.Repository.EnterpriseRepository;
import com.entrepreneur.entrepreneur_backend.Service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {
    @Autowired
    private EnterpriseRepository enterpriseRepository;
    @Override
    public Enterprise createEnterprise(Enterprise entrepreneur) {
        return enterpriseRepository.save(entrepreneur);
    }
    @Override
    public Enterprise getEnterpriseById(String entrepreneurId) {
        return enterpriseRepository.findById(entrepreneurId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + entrepreneurId));
    }
    @Override
    public Enterprise getEnterpriseByEmail(String entrepreneurEmail) {
        return enterpriseRepository.findByEntrepreneurEmail(entrepreneurEmail);
    }
    @Override
    public List<Enterprise> getAllEnterprises() {
        return enterpriseRepository.findAll();
    }
    @Override
    public Enterprise updateEnterprise(String entrepreneurId, Enterprise entrepreneurDetails) {
        return enterpriseRepository.findById(entrepreneurId).map(existingEntrepreneur -> {
            existingEntrepreneur.setEntrepreneurName(entrepreneurDetails.getEntrepreneurName());
            existingEntrepreneur.setEntrepreneurEmail(entrepreneurDetails.getEntrepreneurEmail());
            existingEntrepreneur.setRegisterNumber(entrepreneurDetails.getRegisterNumber());
            existingEntrepreneur.setOwnerName(entrepreneurDetails.getOwnerName());
            existingEntrepreneur.setEnterpriseType(entrepreneurDetails.getEnterpriseType());
            existingEntrepreneur.setStartingDate(entrepreneurDetails.getStartingDate());
            existingEntrepreneur.setAddress(entrepreneurDetails.getAddress());
            existingEntrepreneur.setTelNumber(entrepreneurDetails.getTelNumber());
            existingEntrepreneur.setCompanyLogo(entrepreneurDetails.getCompanyLogo());
            return enterpriseRepository.save(existingEntrepreneur);
        }).orElseThrow(() -> new RuntimeException("Entrepreneur not found with ID: " + entrepreneurId));
    }
    @Override
    public void deleteEnterprise(String entrepreneurId) {
        enterpriseRepository.deleteById(entrepreneurId);
    }
}
