package com.zikozee.compositecrud.service;

import com.zikozee.compositecrud.model.Employee;
import com.zikozee.compositecrud.model.compositeModel.EmployeeIdentity;
import com.zikozee.compositecrud.repo.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Set<Employee> findAll() {
        Set<Employee> employees = new HashSet<>();

        employeeRepository.findAll().forEach(employees::add);

        return employees;
    }

    @Override
    public Employee findById(EmployeeIdentity employeeIdentity) {
        return employeeRepository.findById(employeeIdentity).orElse(null);
    }


    @Override
    public Employee deleteById(EmployeeIdentity employeeIdentity) {
        Employee employee = findById(employeeIdentity);
        employeeRepository.deleteById(employeeIdentity);
        return employee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }


    @Override
    public List<Employee> findByEmployeeId(String employeeId) {
        return employeeRepository.findByEmployeeIdentityEmployeeId(employeeId);
    }

    @Override
    public List<Employee> findByDepartmentId(int departmentId) {
        return employeeRepository.findByEmployeeIdentityDepartmentId(departmentId);
    }
}
