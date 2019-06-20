package com.decta.homework.cardissue.corporateindividual;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CorporateClientRepository extends CrudRepository<CorporateClientEntity, Long> {

    CorporateClientEntity findByRegistrationNumber(String registrationNumber);

}
