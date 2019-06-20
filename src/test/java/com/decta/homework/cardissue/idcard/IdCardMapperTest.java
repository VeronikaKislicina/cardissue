package com.decta.homework.cardissue.idcard;

import org.junit.Test;

import static org.junit.Assert.*;

public class IdCardMapperTest {

    @Test
    public void shouldAddIdCardDTOtoEntity() {
        IdCardMapper idCardMapper = new IdCardMapper();
        IdCardDTO idCardDTO = new IdCardDTO();

        idCardDTO.setName("Name");
        idCardDTO.setSurname("Surname");
        idCardDTO.setDateOfBirth("date");
        idCardDTO.setPersonalNumber("PersonalNumber");

        IdCardEntity idCardEntity = idCardMapper.addIdCardDTOtoEntity(idCardDTO);
        assertTrue(idCardEntity.getName().equals(idCardDTO.getName()));
        assertTrue(idCardEntity.getSurname().equals(idCardDTO.getSurname()));
        assertTrue(idCardEntity.getDateOfBirth().equals(idCardDTO.getDateOfBirth()));
        assertTrue(idCardEntity.getPersonalNumber().equals(idCardDTO.getPersonalNumber()));

    }
}