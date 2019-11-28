package com.zikozee.compositecrud.controller;

import com.zikozee.compositecrud.model.Employee;
import com.zikozee.compositecrud.model.compositeModel.EmployeeIdentity;
import com.zikozee.compositecrud.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/employees")
    public Set<Employee> getEmployee() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}/{departmentId}")
    public Employee getEmployeeById(@PathVariable String employeeId, @PathVariable int departmentId) {

        EmployeeIdentity identity = new EmployeeIdentity(employeeId, departmentId);

        Employee employee = employeeService.findById(identity);

        if (employee == null) {
            throw new RuntimeException("Company id not found - employeeId: "
                    + employeeId + " ,departmentId: " + departmentId);
        }

        return employee;
    }

    @GetMapping("/employees/employee/{employeeId}")
    public List<Employee> getEmployeeByEmployeeId(@PathVariable String employeeId) {

        List<Employee> employees = employeeService.findByEmployeeId(employeeId);

        if (employees == null || employees.size() == 0) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return employees;
    }

    @GetMapping("/companies/department/{departmentId}")
    public List<Employee> getCompanyByRegionId(@PathVariable int departmentId) {
        List<Employee> employees = employeeService.findByDepartmentId(departmentId);

        if (employees == null || employees.size() == 0) {
            throw new RuntimeException("Employee id not found - " + departmentId);
        }

        return employees;
    }

    @PostMapping("/employees")
    public Employee createCompany(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);

        return employee;
    }

    @PutMapping("/employees")
    public Employee updateCompany(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);

        return employee;
    }

    @DeleteMapping("/employees/{employeeId}/{departmentId}")
    public Employee deleteCompany(@PathVariable String employeeId, @PathVariable int departmentId){

        EmployeeIdentity identity = new EmployeeIdentity(employeeId, departmentId);

        return employeeService.deleteById(identity);
    }
}
