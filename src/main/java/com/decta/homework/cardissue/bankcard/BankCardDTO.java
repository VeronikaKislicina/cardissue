package com.decta.homework.cardissue.bankcard;

import org.hibernate.validator.constraints.NotEmpty;

public class BankCardDTO {

    @NotEmpty
    private Long cardNumber;

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }
}
