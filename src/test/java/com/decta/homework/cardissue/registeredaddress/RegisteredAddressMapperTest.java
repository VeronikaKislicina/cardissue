package com.decta.homework.cardissue.registeredaddress;

import org.junit.Test;

import static org.junit.Assert.*;

public class RegisteredAddressMapperTest {

    @Test
    public void shouldAddRegisteredAddressDTOtoEntity() {

        RegisteredAddressMapper registeredAddressMapper = new RegisteredAddressMapper();
        RegisteredAddressDTO registeredAddressDTO = new RegisteredAddressDTO();

        registeredAddressDTO.setCity("City");
        registeredAddressDTO.setCountry("Country");
        registeredAddressDTO.setStreetName("StreetName");

        RegisteredAddressEntity registeredAddressEntity = registeredAddressMapper
                .addRegisteredAddressDTOtoEntity(registeredAddressDTO);

        assertTrue(registeredAddressEntity.getCity().equals(registeredAddressDTO.getCity()));
        assertTrue(registeredAddressEntity.getCountry().equals(registeredAddressDTO.getCountry()));
        assertTrue(registeredAddressEntity.getStreetName().equals(registeredAddressDTO.getStreetName()));

    }
}