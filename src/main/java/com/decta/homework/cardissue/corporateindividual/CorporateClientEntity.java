package com.decta.homework.cardissue.corporateindividual;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CorporateClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String idCardNumber;
    private String extractFromTheRegisterOfEnterprises;
    private String registrationNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getExtractFromTheRegisterOfEnterprises() {
        return extractFromTheRegisterOfEnterprises;
    }

    public void setExtractFromTheRegisterOfEnterprises(String extractFromTheRegisterOfEnterprises) {
        this.extractFromTheRegisterOfEnterprises = extractFromTheRegisterOfEnterprises;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}
