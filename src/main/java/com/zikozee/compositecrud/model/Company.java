package com.zikozee.compositecrud.model;

import com.zikozee.compositecrud.model.compositeModel.CompanyIdentity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "company")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
@IdClass(CompanyIdentity.class)
public class Company {

    @Id
    private int registrationId;

    @Id
    private int regionId;

    private int companyCode;

    private String ownerName;
}
