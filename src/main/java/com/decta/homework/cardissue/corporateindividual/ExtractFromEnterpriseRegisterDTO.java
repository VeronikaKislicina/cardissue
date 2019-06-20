package com.decta.homework.cardissue.corporateindividual;

import com.decta.homework.cardissue.registeredaddress.RegisteredAddressDTO;
import org.hibernate.validator.constraints.NotEmpty;

public class ExtractFromEnterpriseRegisterDTO {

    @NotEmpty
    private String companyName;
    @NotEmpty
    private String registrationNumber;
    @NotEmpty
    private RegisteredAddressDTO registeredAddressDTO;

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

    public RegisteredAddressDTO getRegisteredAddressDTO(RegisteredAddressDTO addressDTO) {
        return registeredAddressDTO;
    }

    public void setRegisteredAddressDTO(RegisteredAddressDTO registeredAddressDTO) {
        this.registeredAddressDTO = registeredAddressDTO;
    }
}
