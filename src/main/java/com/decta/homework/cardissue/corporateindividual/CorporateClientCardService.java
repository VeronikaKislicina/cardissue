package com.decta.homework.cardissue.corporateindividual;

import com.decta.homework.cardissue.bankcard.BankCardEntity;
import com.decta.homework.cardissue.idcard.IdCardDTO;
import com.decta.homework.cardissue.idcard.IdCardEntity;
import com.decta.homework.cardissue.idcard.IdCardRepository;
import com.decta.homework.cardissue.idcard.IdCardService;
import com.decta.homework.cardissue.registeredaddress.RegisteredAddressDTO;
import com.decta.homework.cardissue.registeredaddress.RegisteredAddressEntity;
import com.decta.homework.cardissue.registeredaddress.RegisteredAddressMapper;
import com.decta.homework.cardissue.status.CardIssueStatusDTO;
import com.decta.homework.cardissue.status.InquiryStatusDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CorporateClientCardService {

    private IdCardService idCardService;
    private IdCardRepository idCardRepository;
    private ExtractFromEnterpriseRegisterMapper extractFromEnterpriseRegisterMapper;
    private CorporateClientRepository corporateClientRepository;
    private RegisteredAddressMapper registeredAddressMapper;

    @Autowired
    public CorporateClientCardService(IdCardService idCardService, IdCardRepository idCardRepository,
                                      ExtractFromEnterpriseRegisterMapper extractFromEnterpriseRegisterMapper,
                                      CorporateClientRepository corporateClientRepository,
                                      RegisteredAddressMapper registeredAddressMapper) {
        this.idCardService = idCardService;
        this.idCardRepository = idCardRepository;
        this.extractFromEnterpriseRegisterMapper = extractFromEnterpriseRegisterMapper;
        this.corporateClientRepository = corporateClientRepository;
        this.registeredAddressMapper = registeredAddressMapper;
    }

    @Transactional
    public CardIssueStatusDTO cardIssue(IdCardDTO idCardDTO, ExtractFromEnterpriseRegisterDTO extractFromEnterpriseRegisterDTO) {

        CardIssueStatusDTO cardIssueStatusDTO = new CardIssueStatusDTO();

        IdCardEntity idCard = idCardService.checkIdCardInRepository(idCardDTO.getPersonalNumber());

        ExtractFromEnterpriseRegisterEntity extract = extractFromEnterpriseRegisterMapper
                .addExctractDTOtoEntity(extractFromEnterpriseRegisterDTO);

        CorporateClientEntity client = corporateClientRepository
                .findByRegistrationNumber(extract.getRegistrationNumber());

        if (client == null) {
            cardIssueStatusDTO.setDetails("This client does not exist");
        }

        CorporateClientEntity corporateClientEntity = idCard.getCorporateClientEntity();

        if (corporateClientEntity == null) {
            BankCardEntity bankCardEntity = new BankCardEntity();
            bankCardEntity.setCardNumber(idCard.getId());
            idCardRepository.save(idCard);
            cardIssueStatusDTO.setDetails("Bank card has been issued successfully");
        }

        return cardIssueStatusDTO;

    }


    @Transactional
    public InquiryStatusDTO getInquiry(ExtractFromEnterpriseRegisterDTO extractFromEnterpriseRegisterDTO,
                                       RegisteredAddressDTO registeredAddressDTO) {

        InquiryStatusDTO inquiryStatusDTO = new InquiryStatusDTO();

        ExtractFromEnterpriseRegisterEntity extract =
                extractFromEnterpriseRegisterMapper.addExctractDTOtoEntity(extractFromEnterpriseRegisterDTO);
        CorporateClientEntity client =
                corporateClientRepository.findByRegistrationNumber(extract.getRegistrationNumber());

        RegisteredAddressEntity registeredAddress = registeredAddressMapper
                .addRegisteredAddressDTOtoEntity(registeredAddressDTO);

        if ((client == null) || (registeredAddress == null)) {
            inquiryStatusDTO.setDetails("Customer does not exist");
        }

        return inquiryStatusDTO;
    }
}