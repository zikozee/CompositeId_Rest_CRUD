package com.zikozee.compositecrud.model;

import com.zikozee.compositecrud.model.compositeModel.CompanyIdentity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "company")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
@IdClass(CompanyIdentity.class)
public class Company {

    @Id
    private int registrationId;  // difficult to do post and update

    @Id
    private int regionId;

    private int companyCode;

    private String ownerName;
}
