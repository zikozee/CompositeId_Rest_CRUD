package com.zikozee.compositecrud.controller;

import com.zikozee.compositecrud.globalHandling.EntityNotFoundException;
import com.zikozee.compositecrud.model.Company;
import com.zikozee.compositecrud.model.compositeModel.CompanyIdentity;
import com.zikozee.compositecrud.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/comp")
    public Set<Company> getCompanies() {
        return companyService.findAll();
    }

    @GetMapping("/comp/{registrationId}/{regionId}")
    public Company getCompanyById(@PathVariable int registrationId, @PathVariable int regionId) {

        CompanyIdentity identity = new CompanyIdentity(registrationId, regionId);

        Company company = companyService.findById(identity);

        if (company == null) {
            throw new RuntimeException("Company id not found - registrationId: " + registrationId + " ,regionId: " + regionId);
        }

        return company;
    }

    @GetMapping("/comp/registration/{registrationId}")
    public List<Company> getCompanyByRegistrationId(@PathVariable int registrationId) {

        List<Company> companies = companyService.findByRegistrationId(registrationId);

        if (companies == null || companies.size() == 0) {
            throw new RuntimeException("Employee id not found - " + registrationId);
        }

        return companies;
    }

    @GetMapping("/comp/region/{regionId}")
    public List<Company> getCompanyByRegionId(@PathVariable int regionId) {
        List<Company> companies = companyService.findByRegionId(regionId);

        if (companies == null || companies.size() == 0) {
            throw new RuntimeException("Employee id not found - " + regionId);
        }

        return companies;
    }

    @PostMapping("/comp")
    public Company createCompany(@RequestBody Company company) {
        CompanyIdentity identity = new CompanyIdentity(company.getRegistrationId(), company.getRegionId());
        Company existingCompany = companyService.findById(identity);

        if(existingCompany != null){
            throw new EntityNotFoundException("Employee already exist");
        }
        companyService.saveCompany(company);

        return company;
    }

    @PutMapping("/comp")
    public Company updateCompany(@RequestBody Company company) {
        companyService.saveCompany(company);

        return company;
    }

    @DeleteMapping("/comp/{registrationId}/{regionId}")
    public Company deleteCompany(@PathVariable int registrationId, @PathVariable int regionId){

        CompanyIdentity identity = new CompanyIdentity(registrationId, regionId);

        return companyService.deleteById(identity);
    }

}
