package com.decta.homework.cardissue.bankcard;

import org.springframework.stereotype.Component;

@Component
public class BankCardMapper {
    public BankCardEntity addBankCardDTOtoEntity(BankCardDTO bankCardDTO) {
        BankCardEntity bankCardEntity = new BankCardEntity();

        bankCardEntity.setCardNumber(bankCardDTO.getCardNumber());

        return bankCardEntity;
    }
}
