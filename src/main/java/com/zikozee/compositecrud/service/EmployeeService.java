package com.zikozee.compositecrud.service;

import com.zikozee.compositecrud.model.Employee;
import com.zikozee.compositecrud.model.compositeModel.EmployeeIdentity;

import java.util.List;
import java.util.Set;

public interface EmployeeService {
    Set<Employee> findAll();

    Employee findById(EmployeeIdentity employeeIdentity);

    Employee deleteById(EmployeeIdentity employeeIdentity);

    Employee saveEmployee(Employee employee);

    List<Employee> findByEmployeeId(String employeeId);

    List<Employee> findByDepartmentId(int departmentId);
}
