package com.zikozee.compositecrud.model.compositeModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data // contains needed getter, setter, and equalAndHashCode
@NoArgsConstructor @AllArgsConstructor
public class CompanyIdentity implements Serializable {

    private int registrationId;

    private int regionId;

}
