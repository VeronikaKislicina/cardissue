package com.decta.homework.cardissue.privateindividual;

import com.decta.homework.cardissue.idcard.IdCardDTO;
import com.decta.homework.cardissue.idcard.IdCardEntity;
import com.decta.homework.cardissue.idcard.IdCardMapper;
import com.decta.homework.cardissue.idcard.IdCardRepository;
import com.decta.homework.cardissue.registeredaddress.RegisteredAddressDTO;
import com.decta.homework.cardissue.registeredaddress.RegisteredAddressEntity;
import com.decta.homework.cardissue.registeredaddress.RegisteredAddressMapper;
import com.decta.homework.cardissue.status.RegistrationStatus;
import com.decta.homework.cardissue.status.RegistrationStatusDTO;
import com.decta.homework.cardissue.validation.Validation;
import com.decta.homework.cardissue.validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PrivateClientRegistrationService {

    ValidationService validationService;
    private IdCardMapper idCardMapper;
    private RegisteredAddressMapper registeredAddressMapper;
    private IdCardRepository idCardRepository;

    @Autowired
    public PrivateClientRegistrationService(ValidationService validationService, IdCardMapper idCardMapper,
                                            RegisteredAddressMapper registeredAddressMapper,
                                            IdCardRepository idCardRepository) {
        this.validationService = validationService;
        this.idCardMapper = idCardMapper;
        this.registeredAddressMapper = registeredAddressMapper;
        this.idCardRepository = idCardRepository;
    }

    @Transactional
    public RegistrationStatusDTO register(IdCardDTO idCardDTO, RegisteredAddressDTO registeredAddressDTO) {

        RegistrationStatusDTO statusDTO = new RegistrationStatusDTO();

        if (validationService.validate() == Validation.VALID) {

            IdCardEntity newCard = idCardMapper.addIdCardDTOtoEntity(idCardDTO);
            RegisteredAddressEntity registrationAddress = registeredAddressMapper
                    .addRegisteredAddressDTOtoEntity(registeredAddressDTO);

            PrivateClientEntity newClient = new PrivateClientEntity();
            newClient.setIdCard(newCard);
            newClient.setPlaceOfRegistration(registrationAddress);
            newCard.setPrivateClientEntity(newClient);
            idCardRepository.save(newCard);

            statusDTO.setStatus(RegistrationStatus.APPROVED);
            statusDTO.setDetails("Registration is successful");
        } else {
            statusDTO.setStatus(RegistrationStatus.REJECTED);
            statusDTO.setDetails("Registration is rejected");
        }
        return statusDTO;
    }

}