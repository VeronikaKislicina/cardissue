package com.decta.homework.cardissue.idcard;

import org.springframework.stereotype.Component;

@Component
public class IdCardMapper {

    public IdCardEntity addIdCardDTOtoEntity(IdCardDTO idCardDTO) {
        IdCardEntity idCardEntity = new IdCardEntity();

        idCardEntity.setName(idCardDTO.getName());
        idCardEntity.setSurname(idCardDTO.getSurname());
        idCardEntity.setDateOfBirth(idCardDTO.getDateOfBirth());
        idCardEntity.setPersonalNumber(idCardDTO.getPersonalNumber());

        return idCardEntity;
    }

}
