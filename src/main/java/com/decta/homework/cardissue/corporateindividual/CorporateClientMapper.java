package com.decta.homework.cardissue.corporateindividual;

import org.springframework.stereotype.Component;

@Component
public class CorporateClientMapper {

    public CorporateClientEntity addCorporateClientDTOtoEntity(CorporateClientDTO corporateClientDTO) {

        CorporateClientEntity corporateClient = new CorporateClientEntity();
        corporateClient.setIdCardNumber(corporateClientDTO.getIdCardNumber());
        corporateClient.setExtractFromTheRegisterOfEnterprises(corporateClientDTO.getExtractFromTheRegisterOfEnterprises());
        corporateClient.setRegistrationNumber(corporateClientDTO.getRegistrationNumber());
        return corporateClient;
    }

}
