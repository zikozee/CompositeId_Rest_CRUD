package com.zikozee.compositecrud.model.compositeModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data @NoArgsConstructor @AllArgsConstructor
public class EmployeeIdentity implements Serializable {

    private String employeeId;

    @Column(nullable = false)
    private int departmentId;
}
