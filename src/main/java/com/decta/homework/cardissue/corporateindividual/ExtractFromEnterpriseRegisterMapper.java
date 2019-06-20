package com.decta.homework.cardissue.corporateindividual;

import org.springframework.stereotype.Component;

@Component
public class ExtractFromEnterpriseRegisterMapper {
    public ExtractFromEnterpriseRegisterEntity addExctractDTOtoEntity(ExtractFromEnterpriseRegisterDTO extractDTO) {

        ExtractFromEnterpriseRegisterEntity extract = new ExtractFromEnterpriseRegisterEntity();

        extract.setCompanyName(extractDTO.getCompanyName());
        extract.setRegistrationNumber(extractDTO.getRegistrationNumber());

        return extract;
    }
}