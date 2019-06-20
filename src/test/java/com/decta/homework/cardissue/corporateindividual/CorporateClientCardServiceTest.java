package com.decta.homework.cardissue.corporateindividual;

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

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CorporateClientCardServiceTest {


    @Autowired
    IdCardRepository idCardRepository;

    @Autowired
    CorporateClientCardService corporateClientCardService;

    @Autowired
    IdCardMapper idCardMapper;

    @Test
    public void shouldIssueCardForCorporateClient() {

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

        ExtractFromEnterpriseRegisterDTO extractFromEnterpriseRegisterDTO = new ExtractFromEnterpriseRegisterDTO();
        extractFromEnterpriseRegisterDTO.setCompanyName("CompanyName");
        extractFromEnterpriseRegisterDTO.setRegistrationNumber("RegistrationNumber");

        CardIssueStatusDTO statusDTO = corporateClientCardService.cardIssue(idCardDTO, extractFromEnterpriseRegisterDTO);
        assertEquals(statusDTO.getDetails(), "Bank card has been issued successfully");

    }

    @Test
    public void shouldNotIssueNewCard() {

        IdCardDTO idCardDTO = new IdCardDTO();
        idCardDTO.setName("Name");
        idCardDTO.setSurname("Surname");
        idCardDTO.setDateOfBirth("date");
        idCardDTO.setPersonalNumber("number");

        ExtractFromEnterpriseRegisterDTO extractFromEnterpriseRegisterDTO = new ExtractFromEnterpriseRegisterDTO();
        extractFromEnterpriseRegisterDTO.setCompanyName("CompanyName");
        extractFromEnterpriseRegisterDTO.setRegistrationNumber("RegNumber");

        RegisteredAddressDTO registeredAddressDTO = new RegisteredAddressDTO();
        registeredAddressDTO.setCountry("Country");
        registeredAddressDTO.setStreetName("Street");
        registeredAddressDTO.setCity("City");

        extractFromEnterpriseRegisterDTO.setRegisteredAddressDTO(registeredAddressDTO);

        CardIssueStatusDTO statusDTO = corporateClientCardService.cardIssue(idCardDTO, extractFromEnterpriseRegisterDTO);
        assertEquals(statusDTO.getDetails(), "This client does not exist");

    }

    @Test
    public void getInquiryWhenClientNotFound() {

        ExtractFromEnterpriseRegisterDTO extractDTO = new ExtractFromEnterpriseRegisterDTO();
        extractDTO.setCompanyName("Company");
        extractDTO.setRegistrationNumber("RegAddress");

        RegisteredAddressDTO registeredAddressDTO = new RegisteredAddressDTO();
        registeredAddressDTO.setCity("City");
        registeredAddressDTO.setStreetName("Street");
        registeredAddressDTO.setCountry("Country");

        extractDTO.setRegisteredAddressDTO(registeredAddressDTO);

        InquiryStatusDTO inquiryStatusDTO = corporateClientCardService.getInquiry(extractDTO, registeredAddressDTO);
        assertEquals(inquiryStatusDTO.getDetails(), "Customer does not exist");

    }
}