package com.decta.homework.cardissue.corporateindividual;

import com.decta.homework.cardissue.registeredaddress.RegisteredAddressEntity;

import javax.persistence.*;

@Entity
public class ExtractFromEnterpriseRegisterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String companyName;
    private String registrationNumber;

    @OneToOne
    private RegisteredAddressEntity registeredAddressEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public RegisteredAddressEntity getRegisteredAddressEntity() {
        return registeredAddressEntity;
    }

    public void setRegisteredAddressEntity(RegisteredAddressEntity registeredAddressEntity) {
        this.registeredAddressEntity = registeredAddressEntity;
    }
}
