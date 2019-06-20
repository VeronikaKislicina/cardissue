package com.decta.homework.cardissue.privateindividual;

import org.hibernate.validator.constraints.NotEmpty;

public class PrivateClientDTO {

    @NotEmpty
    private String idCardNumber;
    @NotEmpty
    private String placeOfRegistration;

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getPlaceOfRegistration() {
        return placeOfRegistration;
    }

    public void setPlaceOfRegistration(String placeOfRegistration) {
        this.placeOfRegistration = placeOfRegistration;
    }
}
