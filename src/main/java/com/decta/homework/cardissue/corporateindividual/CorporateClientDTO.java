package com.decta.homework.cardissue.corporateindividual;

import org.hibernate.validator.constraints.NotEmpty;

public class CorporateClientDTO {

    @NotEmpty
    private String idCardNumber;
    @NotEmpty
    private String extractFromTheRegisterOfEnterprises;
    @NotEmpty
    private String registrationNumber;

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
