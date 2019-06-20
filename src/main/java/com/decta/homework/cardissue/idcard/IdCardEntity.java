package com.decta.homework.cardissue.idcard;

import com.decta.homework.cardissue.corporateindividual.CorporateClientEntity;
import com.decta.homework.cardissue.privateindividual.PrivateClientEntity;

import javax.persistence.*;

@Entity
public class IdCardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;
    private String dateOfBirth;
    private String personalNumber;

    @OneToOne
    private PrivateClientEntity privateClientEntity;

    @OneToOne
    private CorporateClientEntity corporateClientEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public PrivateClientEntity getPrivateClientEntity() {
        return privateClientEntity;
    }

    public void setPrivateClientEntity(PrivateClientEntity privateClientEntity) {
        this.privateClientEntity = privateClientEntity;
    }

    public CorporateClientEntity getCorporateClientEntity() {
        return corporateClientEntity;
    }

    public void setCorporateClientEntity(CorporateClientEntity corporateClientEntity) {
        this.corporateClientEntity = corporateClientEntity;
    }
}
