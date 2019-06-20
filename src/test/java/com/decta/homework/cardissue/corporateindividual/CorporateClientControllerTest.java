package com.decta.homework.cardissue.corporateindividual;

import com.decta.homework.cardissue.registeredaddress.RegisteredAddressDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CorporateClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void register() throws Exception {

        ExtractFromEnterpriseRegisterDTO extractFromEnterpriseRegisterDTO = new ExtractFromEnterpriseRegisterDTO();
        RegisteredAddressDTO registeredAddressDTO = new RegisteredAddressDTO();

        extractFromEnterpriseRegisterDTO.setRegisteredAddressDTO(registeredAddressDTO);
        mockMvc.perform(MockMvcRequestBuilders
                .post("/corporate/registrations")
                .content(asJsonString(extractFromEnterpriseRegisterDTO))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}