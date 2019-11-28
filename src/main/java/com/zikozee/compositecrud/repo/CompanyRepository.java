package com.zikozee.compositecrud.repo;

import com.zikozee.compositecrud.model.Company;
import com.zikozee.compositecrud.model.compositeModel.CompanyIdentity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, CompanyIdentity> {
    List<Company> findByRegistrationIdOrderByRegistrationIdAsc(int registrationId);
    List<Company> findByRegionIdOrderByRegionIdAsc(int registrationId);
}
