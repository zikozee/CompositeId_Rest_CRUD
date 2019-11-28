package com.zikozee.compositecrud.service;

import com.zikozee.compositecrud.model.Company;
import com.zikozee.compositecrud.model.compositeModel.CompanyIdentity;
import com.zikozee.compositecrud.repo.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Set<Company> findAll() {

        Set<Company> companies = new HashSet<>();
        companyRepository.findAll().forEach(companies::add);
        return companies;
    }

    @Override
    public Company findById(CompanyIdentity companyIdentity) {
        return companyRepository.findById(companyIdentity).orElse(null);
    }

    @Override
    public List<Company> findByRegistrationId(int registrationId) {
        return companyRepository.findByRegistrationIdOrderByRegistrationIdAsc(registrationId);
    }

    @Override
    public List<Company> findByRegionId(int regionId) {
        return companyRepository.findByRegionIdOrderByRegionIdAsc(regionId);
    }

    @Override
    public Company deleteById(CompanyIdentity companyIdentity) {
        Company company = findById(companyIdentity);

        if (company == null) {
            throw new RuntimeException("Company id not found - registrationId: "
                    + companyIdentity.getRegistrationId() + " ,regionId: " + companyIdentity.getRegionId());
        }

        companyRepository.deleteById(companyIdentity);
        return company;
    }

    @Override
    public void saveCompany(Company company) {
        companyRepository.save(company);
    }
}
