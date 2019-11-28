package com.zikozee.compositecrud.model;

import com.zikozee.compositecrud.model.compositeModel.EmployeeIdentity;
import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Employee {

    @EmbeddedId
    private EmployeeIdentity employeeIdentity;

    private String name;

    private Double height ;// can be null
}
