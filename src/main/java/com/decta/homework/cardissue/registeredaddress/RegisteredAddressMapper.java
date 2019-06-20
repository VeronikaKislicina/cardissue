package com.decta.homework.cardissue.registeredaddress;

import org.springframework.stereotype.Component;

@Component
public class RegisteredAddressMapper {

    public RegisteredAddressEntity addRegisteredAddressDTOtoEntity(RegisteredAddressDTO registeredAddressDTO) {
        RegisteredAddressEntity registeredAddressEntity = new RegisteredAddressEntity();

        registeredAddressEntity.setCity(registeredAddressDTO.getCity());
        registeredAddressEntity.setCountry(registeredAddressDTO.getCountry());
        registeredAddressEntity.setStreetName(registeredAddressDTO.getStreetName());

        return registeredAddressEntity;
    }
}
