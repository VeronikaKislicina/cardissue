package com.decta.homework.cardissue.corporateindividual;

import com.decta.homework.cardissue.status.RegistrationStatus;
import com.decta.homework.cardissue.status.RegistrationStatusDTO;
import com.decta.homework.cardissue.validation.Validation;
import com.decta.homework.cardissue.validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CorporateClientRegistrationService {

    ValidationService validationService;
    CorporateClientRepository corporateClientRepository;
    CorporateClientMapper corporateClientMapper;
    ExtractFromEnterpriseRegisterMapper extractFromEnterpriseRegisterMapper;

    @Autowired
    public CorporateClientRegistrationService(ValidationService validationService,
                                              CorporateClientRepository corporateClientRepository,
                                              CorporateClientMapper corporateClientMapper,
                                              ExtractFromEnterpriseRegisterMapper extractFromEnterpriseRegisterMapper) {
        this.validationService = validationService;
        this.corporateClientRepository = corporateClientRepository;
        this.corporateClientMapper = corporateClientMapper;
        this.extractFromEnterpriseRegisterMapper = extractFromEnterpriseRegisterMapper;
    }

    @Transactional
    public RegistrationStatusDTO register(ExtractFromEnterpriseRegisterDTO extractFromEnterpriseRegisterDTO) {

        RegistrationStatusDTO statusDTO = new RegistrationStatusDTO();
        String registrationNumber = extractFromEnterpriseRegisterDTO.getRegistrationNumber();

        if ((validationService.validate() == Validation.VALID) &&
        (corporateClientRepository.findByRegistrationNumber(registrationNumber) == null)) {

            CorporateClientEntity corporateClientEntity = new CorporateClientEntity();
            corporateClientEntity.setRegistrationNumber(registrationNumber);

            corporateClientRepository.save(corporateClientEntity);

//            ExtractFromEnterpriseRegisterEntity extract = extractFromEnterpriseRegisterMapper
//                    .addExctractDTOtoEntity(extractFromEnterpriseRegisterDTO);
//
//            CorporateClientEntity client = corporateClientRepository
//                    .findByRegistrationNumber(extract.getRegistrationNumber());
//
//            client.setRegistrationNumber(extract.getRegistrationNumber());
//            client.setIdCardNumber(extract.getRegistrationNumber());
//            corporateClientRepository.save(client);

            statusDTO.setStatus(RegistrationStatus.APPROVED);
            statusDTO.setDetails("Registration is successful");

        } else {
            statusDTO.setStatus(RegistrationStatus.REJECTED);
            statusDTO.setDetails("Registration is rejected");
        }
        return statusDTO;
    }
}
