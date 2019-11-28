package com.zikozee.compositecrud.controller;

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

    @GetMapping("/companies")
    public Set<Company> getCompanies() {
        return companyService.findAll();
    }

    @GetMapping("/companies/{registrationId}/{regionId}")
    public Company getCompanyById(@PathVariable int registrationId, @PathVariable int regionId) {

        CompanyIdentity identity = new CompanyIdentity(registrationId, regionId);

        Company company = companyService.findById(identity);

        if (company == null) {
            throw new RuntimeException("Company id not found - registrationId: " + registrationId + " ,regionId: " + regionId);
        }

        return company;
    }

    @GetMapping("/companies/registration/{registrationId}")
    public List<Company> getCompanyByRegistrationId(@PathVariable int registrationId) {

        List<Company> companies = companyService.findByRegistrationId(registrationId);

        if (companies == null || companies.size() == 0) {
            throw new RuntimeException("Employee id not found - " + registrationId);
        }

        return companies;
    }

    @GetMapping("/companies/region/{regionId}")
    public List<Company> getCompanyByRegionId(@PathVariable int regionId) {
        List<Company> companies = companyService.findByRegionId(regionId);

        if (companies == null || companies.size() == 0) {
            throw new RuntimeException("Employee id not found - " + regionId);
        }

        return companies;
    }

    @PostMapping("/companies")
    public Company createCompany(@RequestBody Company company) {
        companyService.saveCompany(company);

        return company;
    }

    @PutMapping("/companies")
    public Company updateCompany(@RequestBody Company company) {
        companyService.saveCompany(company);

        return company;
    }

    @DeleteMapping("/companies/{registrationId}/{regionId}")
    public Company deleteCompany(@PathVariable int registrationId, @PathVariable int regionId){

        CompanyIdentity identity = new CompanyIdentity(registrationId, regionId);

        return companyService.deleteById(identity);
    }

}
