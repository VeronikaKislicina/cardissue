package com.decta.homework.cardissue.registeredaddress;

import org.hibernate.validator.constraints.NotEmpty;

public class RegisteredAddressDTO {

    @NotEmpty
    private String streetName;
    @NotEmpty
    private String city;
    @NotEmpty
    private String country;

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
