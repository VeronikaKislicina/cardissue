package com.decta.homework.cardissue.privateindividual;

import com.decta.homework.cardissue.idcard.IdCardDTO;
import com.decta.homework.cardissue.registeredaddress.RegisteredAddressDTO;
import com.decta.homework.cardissue.status.RegistrationStatusDTO;
import com.decta.homework.cardissue.validation.Validation;
import com.decta.homework.cardissue.validation.ValidationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrivateClientRegistrationServiceTest {

    @Autowired
    PrivateClientRegistrationService privateClientRegistrationService;

    @Mock
    ValidationService validationServiceMock;

    @Test
    public void shouldRegisterPrivateClient() {

        Mockito.when(validationServiceMock.validate()).thenReturn(Validation.VALID);

        privateClientRegistrationService.validationService = validationServiceMock;

        IdCardDTO idCardDTO = new IdCardDTO();

        idCardDTO.setName("Name");
        idCardDTO.setSurname("Surname");
        idCardDTO.setPersonalNumber("number");
        idCardDTO.setDateOfBirth("date");

        RegisteredAddressDTO registeredAddressDTO = new RegisteredAddressDTO();
        registeredAddressDTO.setCity("City");
        registeredAddressDTO.setCountry("Country");
        registeredAddressDTO.setStreetName("StreetName");

        RegistrationStatusDTO statusDTO = privateClientRegistrationService.register(idCardDTO, registeredAddressDTO);

        assertEquals(statusDTO.getDetails(), "Registration is successful");

    }


    @Test
    public void shouldNotRegisterPrivateClient() {

        Mockito.when(validationServiceMock.validate()).thenReturn(Validation.NOT_VALID);

        privateClientRegistrationService.validationService = validationServiceMock;

        IdCardDTO idCardDTO = new IdCardDTO();

        idCardDTO.setName("Name");
        idCardDTO.setSurname("Surname");
        idCardDTO.setPersonalNumber("number");
        idCardDTO.setDateOfBirth("date");

        RegisteredAddressDTO registeredAddressDTO = new RegisteredAddressDTO();
        registeredAddressDTO.setCity("City");
        registeredAddressDTO.setCountry("Country");
        registeredAddressDTO.setStreetName("StreetName");

        RegistrationStatusDTO statusDTO = privateClientRegistrationService.register(idCardDTO, registeredAddressDTO);

        assertEquals(statusDTO.getDetails(), "Registration is rejected");

    }
}