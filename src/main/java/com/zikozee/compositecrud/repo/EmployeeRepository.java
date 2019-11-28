package com.zikozee.compositecrud.repo;

import com.zikozee.compositecrud.model.Employee;
import com.zikozee.compositecrud.model.compositeModel.EmployeeIdentity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, EmployeeIdentity> {
    List<Employee> findByEmployeeIdentityEmployeeId(String employeeId);
    List<Employee> findByEmployeeIdentityDepartmentId(int departmentId);
}
