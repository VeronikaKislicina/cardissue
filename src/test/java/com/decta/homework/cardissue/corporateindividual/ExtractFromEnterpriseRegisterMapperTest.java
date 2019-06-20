package com.decta.homework.cardissue.corporateindividual;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExtractFromEnterpriseRegisterMapperTest {

    @Test
    public void shouldAddExctractDTOtoEntity() {

        ExtractFromEnterpriseRegisterMapper extractFromEnterpriseRegisterMapper =
                new ExtractFromEnterpriseRegisterMapper();
        ExtractFromEnterpriseRegisterDTO extractDTO = new ExtractFromEnterpriseRegisterDTO();

        extractDTO.setRegistrationNumber("Number");
        extractDTO.setCompanyName("Company");

        ExtractFromEnterpriseRegisterEntity extractEntity = extractFromEnterpriseRegisterMapper
                .addExctractDTOtoEntity(extractDTO);

        assertTrue(extractEntity.getCompanyName().equals(extractDTO.getCompanyName()));
        assertTrue(extractEntity.getRegistrationNumber().equals(extractDTO.getRegistrationNumber()));
    }
}