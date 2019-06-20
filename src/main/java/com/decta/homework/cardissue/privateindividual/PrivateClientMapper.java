package com.decta.homework.cardissue.privateindividual;

import org.springframework.stereotype.Component;

@Component
public class PrivateClientMapper {

    public PrivateClientEntity addPrivateIndividualDTOtoEntity(PrivateClientDTO privateClientDTO) {

        PrivateClientEntity individualClient = new PrivateClientEntity();

//        individualClient.setPlaceOfRegistration(privateClientDTO.getPlaceOfRegistration());

        return individualClient;

    }
}
