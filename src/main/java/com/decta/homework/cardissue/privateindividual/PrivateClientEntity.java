package com.decta.homework.cardissue.privateindividual;

import com.decta.homework.cardissue.bankcard.BankCardEntity;
import com.decta.homework.cardissue.idcard.IdCardEntity;
import com.decta.homework.cardissue.registeredaddress.RegisteredAddressEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class PrivateClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private RegisteredAddressEntity placeOfRegistration;

    @OneToOne
    private IdCardEntity idCard;

    @OneToMany
    private List<BankCardEntity> bankCards;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RegisteredAddressEntity getPlaceOfRegistration() {
        return placeOfRegistration;
    }

    public void setPlaceOfRegistration(RegisteredAddressEntity placeOfRegistration) {
        this.placeOfRegistration = placeOfRegistration;
    }

    public IdCardEntity getIdCard() {
        return idCard;
    }

    public void setIdCard(IdCardEntity idCard) {
        this.idCard = idCard;
    }

    public List<BankCardEntity> getBankCards() {
        return bankCards;
    }

    public void setBankCards(List<BankCardEntity> bankCards) {
        this.bankCards = bankCards;
    }
}
