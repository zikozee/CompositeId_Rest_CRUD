package com.zikozee.compositecrud.service;

import com.zikozee.compositecrud.model.Company;
import com.zikozee.compositecrud.model.compositeModel.CompanyIdentity;

import java.util.List;
import java.util.Set;

public interface CompanyService {

    Set<Company> findAll();

    Company findById(CompanyIdentity companyIdentity);

    List<Company> findByRegistrationId(int registrationId);

    List<Company> findByRegionId(int registrationId);

    void saveCompany(Company company);

    Company deleteById(CompanyIdentity companyIdentity);



}
