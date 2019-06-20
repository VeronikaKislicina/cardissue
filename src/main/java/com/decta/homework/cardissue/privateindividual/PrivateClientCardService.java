package com.decta.homework.cardissue.privateindividual;

import com.decta.homework.cardissue.bankcard.BankCardEntity;
import com.decta.homework.cardissue.idcard.IdCardDTO;
import com.decta.homework.cardissue.idcard.IdCardEntity;
import com.decta.homework.cardissue.idcard.IdCardRepository;
import com.decta.homework.cardissue.idcard.IdCardService;
import com.decta.homework.cardissue.registeredaddress.RegisteredAddressDTO;
import com.decta.homework.cardissue.status.CardIssueStatusDTO;
import com.decta.homework.cardissue.status.InquiryStatusDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PrivateClientCardService {

    private IdCardService idCardService;
    private IdCardRepository idCardRepository;

    @Autowired
    public PrivateClientCardService(IdCardService idCardService, IdCardRepository idCardRepository) {
        this.idCardService = idCardService;
        this.idCardRepository = idCardRepository;
    }

    @Transactional
    public CardIssueStatusDTO cardIssue(IdCardDTO idCardDTO) {
        CardIssueStatusDTO cardIssueStatusDTO = new CardIssueStatusDTO();

        IdCardEntity idCardEntity = idCardService.checkIdCardInRepository(idCardDTO.getPersonalNumber());
        if (idCardEntity == null) {
            cardIssueStatusDTO.setDetails("This client does not exist");
        }

        PrivateClientEntity privateIndividualClient = idCardEntity.getPrivateClientEntity();
        if (privateIndividualClient == null) {
            BankCardEntity bankCardEntity = new BankCardEntity();
            bankCardEntity.setCardNumber(idCardEntity.getId());
            idCardRepository.save(idCardEntity);
            cardIssueStatusDTO.setDetails("Bank card has been issued successfully");
        }

        return cardIssueStatusDTO;
    }


    @Transactional
    public InquiryStatusDTO getInquiry(IdCardDTO idCardDTO, RegisteredAddressDTO addressDTO) {
        InquiryStatusDTO inquiryStatusDTO = new InquiryStatusDTO();

        IdCardEntity idCardEntity = idCardService.checkIdCardInRepository(idCardDTO.getPersonalNumber());

        if ((idCardEntity == null) || (addressDTO == null)) {
            inquiryStatusDTO.setDetails("This card was not found");
        }

        PrivateClientEntity privateIndividualClient = idCardEntity.getPrivateClientEntity();
        if (privateIndividualClient == null) {
            inquiryStatusDTO.setDetails("This client was not found");
        }

        return inquiryStatusDTO;
    }

}