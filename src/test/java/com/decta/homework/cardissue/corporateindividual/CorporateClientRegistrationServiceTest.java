package com.decta.homework.cardissue.corporateindividual;

import com.decta.homework.cardissue.registeredaddress.RegisteredAddressDTO;
import com.decta.homework.cardissue.status.RegistrationStatusDTO;
import com.decta.homework.cardissue.validation.Validation;
import com.decta.homework.cardissue.validation.ValidationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CorporateClientRegistrationServiceTest {

    @Mock
    ValidationService validationServiceMock;

    @Autowired
    CorporateClientRepository corporateClientRepository;

    @Autowired
    CorporateClientMapper corporateClientMapper;

    @Autowired
    ExtractFromEnterpriseRegisterMapper extractFromEnterpriseRegisterMapper;

    @Test
    public void shouldRegisterCorporateClient() {

        Mockito.when(validationServiceMock.validate()).thenReturn(Validation.VALID);

        CorporateClientRegistrationService corporateClientRegistrationService =
                new CorporateClientRegistrationService(validationServiceMock, corporateClientRepository,
                        corporateClientMapper, extractFromEnterpriseRegisterMapper);

        corporateClientRegistrationService.validationService = validationServiceMock;

        ExtractFromEnterpriseRegisterDTO extractDTO = new ExtractFromEnterpriseRegisterDTO();
        CorporateClientEntity corporateEntity = new CorporateClientEntity();
        corporateEntity.setRegistrationNumber("Registration12345");

        corporateClientRepository.save(corporateEntity);

//        ExtractFromEnterpriseRegisterDTO extractDTO = new ExtractFromEnterpriseRegisterDTO();
//        extractDTO.setCompanyName("CompanyName");
//        extractDTO.setRegistrationNumber("RegNumber");
//
//        RegisteredAddressDTO addressDTO = new RegisteredAddressDTO();
//        addressDTO.setStreetName("StreetName");
//        addressDTO.setCountry("Country");
//        addressDTO.setCity("City");
//
//        extractDTO.setRegisteredAddressDTO(addressDTO);
//
        RegistrationStatusDTO statusDTO = corporateClientRegistrationService.register(extractDTO);

        assertEquals(statusDTO.getDetails(), "Registration is successful");

    }


    @Test
    public void shouldNotRegisterCorporateClient() {

        Mockito.when(validationServiceMock.validate()).thenReturn(Validation.VALID);

        CorporateClientRegistrationService corporateClientRegistrationService1 =
                new CorporateClientRegistrationService(validationServiceMock,
                        corporateClientRepository, corporateClientMapper, extractFromEnterpriseRegisterMapper);

        corporateClientRegistrationService1.validationService = validationServiceMock;

        ExtractFromEnterpriseRegisterDTO extractDTO1 = new ExtractFromEnterpriseRegisterDTO();
        CorporateClientEntity corporateEntity1 = new CorporateClientEntity();
        corporateEntity1.setRegistrationNumber("Registration12345");

        corporateClientRepository.save(corporateEntity1);



        Mockito.when(validationServiceMock.validate()).thenReturn(Validation.NOT_VALID);

        CorporateClientRegistrationService corporateClientRegistrationService =
                new CorporateClientRegistrationService(validationServiceMock,
                        corporateClientRepository, corporateClientMapper, extractFromEnterpriseRegisterMapper);

        corporateClientRegistrationService.validationService = validationServiceMock;

        ExtractFromEnterpriseRegisterDTO extractDTO = new ExtractFromEnterpriseRegisterDTO();

        CorporateClientEntity corporateEntity = new CorporateClientEntity();
        corporateEntity.setRegistrationNumber("Registration12345");

        corporateClientRepository.save(corporateEntity);


//        extractDTO.setCompanyName("CompanyName");
//        extractDTO.setRegistrationNumber("RegNumber");
//
//        RegisteredAddressDTO addressDTO = new RegisteredAddressDTO();
//        addressDTO.setStreetName("StreetName");
//        addressDTO.setCountry("Country");
//        addressDTO.setCity("City");
//
//        extractDTO.setRegisteredAddressDTO(addressDTO);

        RegistrationStatusDTO statusDTO = corporateClientRegistrationService.register(extractDTO);

        assertEquals(statusDTO.getDetails(), "Registration is rejected");

    }
}