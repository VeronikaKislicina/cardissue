package com.decta.homework.cardissue.privateindividual;

import com.decta.homework.cardissue.idcard.IdCardDTO;
import com.decta.homework.cardissue.idcard.IdCardEntity;
import com.decta.homework.cardissue.idcard.IdCardMapper;
import com.decta.homework.cardissue.idcard.IdCardRepository;
import com.decta.homework.cardissue.registeredaddress.RegisteredAddressDTO;
import com.decta.homework.cardissue.status.CardIssueStatusDTO;
import com.decta.homework.cardissue.status.InquiryStatusDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrivateClientCardServiceTest {

    @Autowired
    IdCardRepository idCardRepository;

    @Autowired
    PrivateClientCardService privateClientCardService;

    @Autowired
    IdCardMapper idCardMapper;

    @Test
    public void shouldIssueNewCard() {

        IdCardEntity idCard = new IdCardEntity();
        idCard.setName("Name");
        idCard.setSurname("Surname");
        idCard.setDateOfBirth("date");
        idCard.setPersonalNumber("number");
        idCardRepository.save(idCard);

        IdCardDTO idCardDTO = new IdCardDTO();
        idCardDTO.setName("Name");
        idCardDTO.setSurname("Surname");
        idCardDTO.setDateOfBirth("date");
        idCardDTO.setPersonalNumber("number");

        CardIssueStatusDTO statusDTO = privateClientCardService.cardIssue(idCardDTO);
        assertEquals(statusDTO.getDetails(), "Bank card has been issued successfully");

    }

    @Test
    public void shouldNotIssueNewCard() {

        IdCardDTO idCardDTO = new IdCardDTO();
        idCardDTO.setName("Name");
        idCardDTO.setSurname("Surname");
        idCardDTO.setDateOfBirth("date");
        idCardDTO.setPersonalNumber("number");

        CardIssueStatusDTO statusDTO = privateClientCardService.cardIssue(idCardDTO);
        assertEquals(statusDTO.getDetails(), "This client does not exist");

    }

    @Test
    public void getInquiryWhenCardNotFound() {

        IdCardDTO idCardDTO = new IdCardDTO();
        idCardDTO.setName("Name");
        idCardDTO.setSurname("Surname");
        idCardDTO.setPersonalNumber("PN");
        idCardDTO.setDateOfBirth("date");

        RegisteredAddressDTO registeredAddressDTO = new RegisteredAddressDTO();
        registeredAddressDTO.setCity("City");
        registeredAddressDTO.setStreetName("Street");
        registeredAddressDTO.setCountry("Country");

        InquiryStatusDTO inquiryStatusDTO = privateClientCardService.getInquiry(idCardDTO, registeredAddressDTO);
        assertEquals(inquiryStatusDTO.getDetails(), "This card was not found");

    }


    @Test
    public void getInquiryWhenClientNotFound() {

        IdCardDTO idCardDTO = new IdCardDTO();
        idCardDTO.setName("Name");
        idCardDTO.setSurname("Surname");
        idCardDTO.setPersonalNumber("PN");
        idCardDTO.setDateOfBirth("date");

        IdCardEntity idCard = idCardMapper.addIdCardDTOtoEntity(idCardDTO);
        idCardRepository.save(idCard);

        RegisteredAddressDTO registeredAddressDTO = new RegisteredAddressDTO();
        registeredAddressDTO.setCity("City");
        registeredAddressDTO.setStreetName("Street");
        registeredAddressDTO.setCountry("Country");

        InquiryStatusDTO inquiryStatusDTO = privateClientCardService.getInquiry(idCardDTO, registeredAddressDTO);
        assertEquals(inquiryStatusDTO.getDetails(), "This client was not found");

    }
}