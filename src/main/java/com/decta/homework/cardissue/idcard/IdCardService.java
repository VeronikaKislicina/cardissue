package com.decta.homework.cardissue.idcard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdCardService {

    private IdCardRepository idCardRepository;

    @Autowired
    public IdCardService(IdCardRepository idCardRepository) {
        this.idCardRepository = idCardRepository;
    }

    public IdCardEntity checkIdCardInRepository(String personalNumber) {
        return idCardRepository.findByPersonalNumber(personalNumber);
    }

}
